package dam.jsoup.updatereport.updatreport.service.impl;

import dam.jsoup.updatereport.updatreport.dao.*;
import dam.jsoup.updatereport.updatreport.pojo.*;
import dam.jsoup.updatereport.updatreport.service.ConnectSoupSystemService;
import dam.jsoup.updatereport.updatreport.service.FileExcutorService;
import dam.jsoup.updatereport.updatreport.service.SendEmail;
import dam.jsoup.updatereport.updatreport.service.order.JsoupMissionService;
import dam.jsoup.updatereport.updatreport.util.BusyUtil;
import dam.jsoup.updatereport.updatreport.util.MissionDataRunPriceUtil;
import dam.jsoup.updatereport.updatreport.util.MyResponse;
import dam.jsoup.updatereport.updatreport.vo.HttpMissionDataVo;
import dam.jsoup.updatereport.updatreport.vo.MissionAllData;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@AllArgsConstructor
public class ConnectSoupSystemServiceImpl implements ConnectSoupSystemService {
    private final HandMapper mapper;
    private final JsoupMissionAllHistoryMapper historyMapper;
    private final FileExcutorService fileExcutorService;
    private final String dir = "/export/data/";
    private final JsoupMissionAllMapper missionAllMapper;
    private final JsoupMissionService missionService;
    private final JsoupUserAssetsMapper jsoupUserAssetsMapper;
    private final SendEmail sendEmail;
    private final JsoupExcutorMapper excutorMapper;

    /**
     * 获取待执行服务
     */
    @Override
    public HttpMissionDataVo getOneWaitService(String code,String token) {
        //校验code与token
        JsoupExcutor excutor = mapper.getExcutorByCpuCodeAndToken(token, code);
        if (excutor == null) {
            HttpMissionDataVo httpMissionDataVo = new HttpMissionDataVo();
            httpMissionDataVo.setState(0);
            httpMissionDataVo.setException("无效的执行器");
            return httpMissionDataVo;
        }
        //获取一个待执行任务
        JsoupMissionAllHistory oneWaitToDoTask = mapper.getOneWaitToDoTask();
        if (oneWaitToDoTask == null) {
            //没有待执行任务
            HttpMissionDataVo httpMissionDataVo = new HttpMissionDataVo();
            httpMissionDataVo.setState(2);
            httpMissionDataVo.setException("当前队列中无任务等待执行");
            return httpMissionDataVo;
        }
        //通过maId 序列化得到missionAll
        MissionAllData missionAllData = missionService.getMissionAllData(oneWaitToDoTask.getMissionAllId(), 1);
//        判断用户余额足以支持执行脚本
        BigDecimal bigDecimal = MissionDataRunPriceUtil.checkMissionAllDataPrice(missionAllData);
        JsoupUserAssetsExample assetsExample = new JsoupUserAssetsExample();
        assetsExample.createCriteria().andUserIdEqualTo(oneWaitToDoTask.getUserId());
        List<JsoupUserAssets> jsoupUserAssets = jsoupUserAssetsMapper.selectByExample(assetsExample);
        JsoupUserAssets userAssets = jsoupUserAssets.get(0);
        if (userAssets.getCornNum().compareTo(bigDecimal) <0  ) {

//            金币是否充足  1：:1000
            if (userAssets.getGoldNum().multiply(new BigDecimal(1000)).compareTo(bigDecimal) <0){
                sendEmail.sendNoticeEmail(oneWaitToDoTask.getUserId(),"对不起，您的余额不足","您的余额不足以支持执行此次任务。您的点数剩余:  " + userAssets.getCornNum().toString() + "   您的金币剩余:  " +userAssets.getGoldNum().toString() + "需要消耗的金额为: " +bigDecimal.toString());
            }else {
//                扣除金币
                userAssets.setGoldNum(userAssets.getGoldNum().subtract(bigDecimal.multiply(new BigDecimal(0.001))));
                jsoupUserAssetsMapper.updateByPrimaryKeySelective(userAssets);
            }

             }else {
//            扣钱
            userAssets.setCornNum(userAssets.getCornNum().subtract(bigDecimal));
            jsoupUserAssetsMapper.updateByPrimaryKeySelective(userAssets);
        }
        sendEmail.sendNoticeEmail(oneWaitToDoTask.getUserId(),"您的任务"+missionAllData.getJsoupMissionAll().getMaName() +"开始执行","执行耗费为:  " + bigDecimal.toString());
        HttpMissionDataVo httpMissionDataVo = new HttpMissionDataVo();
        httpMissionDataVo.setMissionAllData(missionAllData);
        httpMissionDataVo.setJsoupMissionAllHistory(oneWaitToDoTask);
        httpMissionDataVo.setState(1);
        //返回前需要将任务状态重新设置  已经被任务器拿走 状态修改为2 执行中 添加现在时间为finish time
        oneWaitToDoTask.setMissionState("2");
        oneWaitToDoTask.setFinishTime(new Date());
        oneWaitToDoTask.setExcutorCode(code);
        oneWaitToDoTask.setExcutorToken(token);
        historyMapper.updateByPrimaryKeySelective(oneWaitToDoTask);
        return httpMissionDataVo;
    }

    /**
     * 接受执行完毕数据
     */
    @Override
    public void storeBackData(HttpMissionDataVo httpMissionDataVo) {
        JsoupMissionAllHistory mh = httpMissionDataVo.getJsoupMissionAllHistory();
        //重新审视mh
        mh = historyMapper.selectByPrimaryKey(mh.getMissionAllHistoryId());
        if (!mh.getMissionState().equals("2")) {
            log.error("  数据异常  并非正在执行中的任务  ");
        }
        //判断执行结果是否正确
        if (httpMissionDataVo.getState() != 1) {
            //执行结果异常 不进入文件生成线程 直接弹出
            mh.setMissionState("4");
            String e = httpMissionDataVo.getException();
            if (e.contains("interrupt")) {
                mh.setMissionFailReason("系统内部异常 脚本执行器");
            }else {
                mh.setMissionFailReason(e);
            }
            //获取脚本执行器
            JsoupExcutor excutorByToekn = mapper.getExcutorByToekn(mh.getExcutorToken());
            excutorByToekn.setExcutorTimes(excutorByToekn.getExcutorTimes() +1);
            excutorMapper.updateByPrimaryKeySelective(excutorByToekn);
            historyMapper.updateByPrimaryKeySelective(mh);
            return;
        }
        //生成文件服务
        String fileName;
        try {
            //获取任务总情况
            JsoupMissionAll missionAll = missionAllMapper.selectByPrimaryKey(mh.getMissionAllId());
            fileName = fileExcutorService.fileInput(httpMissionDataVo.getResult(), dir, missionAll.getMaSuccessFileName());
            //将文件名保存在his内
            mh.setMissionState("3");
            mh.setMissionResultUrl(fileName);
            mh.setFinishTime(new Date());
            historyMapper.updateByPrimaryKeySelective(mh);
        } catch (Exception e) {
            mh.setMissionState("4");
            if (e.getMessage().contains("Invalid cell range") || e.getMessage().contains("Merged region")) {
                mh.setMissionFailReason("内部异常:文件生成器");
            } else if (e.getMessage().contains("interrupt")) {
                mh.setMissionFailReason("内部异常:脚本执行器");
            } else if (e.getMessage().contains("com.netflix.client.ClientException: Load balancer does not have available server for client")) {
                mh.setMissionFailReason("内部异常:集群服务");
            } else {
                mh.setMissionFailReason(e.getMessage());
            }
            mh.setFinishTime(new Date());
            JsoupExcutor excutorByToekn = mapper.getExcutorByToekn(mh.getExcutorToken());
            excutorByToekn.setExcutorTimes(excutorByToekn.getExcutorTimes() +1);
            excutorByToekn.setSuccessTimes(excutorByToekn.getSuccessTimes() +1);
            excutorMapper.updateByPrimaryKeySelective(excutorByToekn);
            historyMapper.updateByPrimaryKeySelective(mh);
        }

    }

    /**
     * 心跳包维持
     *
     */
    @Override
    public Map heartHit(String excutorCode,String excutorToken) {
        log.info("进入执行器注册程序  入参= [{}]",excutorCode+"    ========     " + excutorToken);
        Map<String,Object> map = new HashMap<>();
        JsoupExcutor excutorByToekn = mapper.getExcutorByToekn(excutorToken);
        if (excutorByToekn == null ) {
            log.error("查无此注册执行器");
            return MyResponse.myResponseError("无效的执行器");
        }
        if (excutorByToekn.getExcutorCode()!= null &&!excutorByToekn.getExcutorCode().equals(excutorCode)) {
            log.info("此注册器识别码不一致");
            return MyResponse.myResponseError("识别码不一致");
        }
        //注册新的执行器
        if (excutorByToekn.getExcutorCode() == null) {
            excutorByToekn.setExcutorCode(excutorCode);
            excutorByToekn.setCreateTime(new Date());
            excutorByToekn.setSuccessTimes(0);
            excutorByToekn.setExcutorTimes(0);
        }
        excutorByToekn.setLiveUpdateTime(new Date());
        excutorByToekn.setStatus("1");
        //更新服务状态
        mapper.updateExcutorByExcutorToken(excutorByToekn);
        Integer num = mapper.getWaitExecutorNum();
        Integer integer = BusyUtil.backStatus(num);
        map.put("status",integer);
        return MyResponse.myResponseOk(map,"心跳续约成功");
    }
}
