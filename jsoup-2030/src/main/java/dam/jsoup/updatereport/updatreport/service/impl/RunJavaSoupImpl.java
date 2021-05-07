package dam.jsoup.updatereport.updatreport.service.impl;

import dam.jsoup.updatereport.updatreport.dao.JsoupMapper;
import dam.jsoup.updatereport.updatreport.dao.JsoupMissionAllHistoryMapper;
import dam.jsoup.updatereport.updatreport.dao.JsoupMissionAllMapper;
import dam.jsoup.updatereport.updatreport.dao.JsoupPragramMapper;
import dam.jsoup.updatereport.updatreport.pojo.JsoupMissionAll;
import dam.jsoup.updatereport.updatreport.pojo.JsoupMissionAllHistory;
import dam.jsoup.updatereport.updatreport.pojo.JsoupMissionAllHistoryExample;
import dam.jsoup.updatereport.updatreport.pojo.JsoupPragram;
import dam.jsoup.updatereport.updatreport.service.FileExcutorService;
import dam.jsoup.updatereport.updatreport.service.RunJavaSoup;
import dam.jsoup.updatereport.updatreport.service.SendExcutorServcie;
import dam.jsoup.updatereport.updatreport.service.order.JsoupMissionService;
import dam.jsoup.updatereport.updatreport.vo.TimeTaskRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class RunJavaSoupImpl implements RunJavaSoup {

    private final SendExcutorServcie sendExcutorServcie;
    private final JsoupMissionAllHistoryMapper jsoupMissionAllHistoryMapper;
    private final FileExcutorService fileExcutorService;
    private final String dir = "/export/data/";
    private final JsoupMissionAllMapper missionAllMapper;
    private final JsoupMissionService jsoupMissionService;
    private final JsoupMapper jsoupMapper;
    private final JsoupPragramMapper pragramMapper;

    public RunJavaSoupImpl(SendExcutorServcie sendExcutorServcie, JsoupMissionAllHistoryMapper jsoupMissionAllHistoryMapper, FileExcutorService fileExcutorService, JsoupMissionAllMapper missionAllMapper, JsoupMissionService jsoupMissionService, JsoupMapper jsoupMapper, JsoupPragramMapper pragramMapper) {
        this.sendExcutorServcie = sendExcutorServcie;
        this.jsoupMissionAllHistoryMapper = jsoupMissionAllHistoryMapper;
        this.fileExcutorService = fileExcutorService;
        this.missionAllMapper = missionAllMapper;
        this.jsoupMissionService = jsoupMissionService;
        this.jsoupMapper = jsoupMapper;
        this.pragramMapper = pragramMapper;
    }

    /**
     * 执行服务
     *
     * @param orderId
     * @param userId
     */
    @Override
    public void runJavaSoup(Integer orderId, Integer userId) {
        JsoupMissionAllHistoryExample example = new JsoupMissionAllHistoryExample();
        example.createCriteria().andMissionAllHistoryIdEqualTo(orderId);
        List<JsoupMissionAllHistory> histories = jsoupMissionAllHistoryMapper.selectByExample(example);
        JsoupMissionAllHistory jsoupMissionAllHistory = histories.get(0);
        //如果是非待执行请求 直接中止
        if (!jsoupMissionAllHistory.getMissionState().equals("2")){
            throw new RuntimeException("任务异常:该任务已经执行完毕");
        }
        //发送执行服务
        Map map;
             map = sendExcutorServcie.sendGoExcutor(jsoupMissionAllHistory.getMissionAllId(), userId);
             if (map.get("code").equals("error")){
                 throw new RuntimeException((String) map.get("msg"));
             }

        JsoupMissionAll jsoupMissionAll = missionAllMapper.selectByPrimaryKey(jsoupMissionAllHistory.getMissionAllId());
        //进行下一步 将数据发送至文件生成器
        List<Map<String,String>> res = (List<Map<String, String>>) map.get("result");
        String fileName = fileExcutorService.fileInput(res, dir, jsoupMissionAll.getMaSuccessFileName());
        //将文件名保存在his内
        jsoupMissionAllHistory.setMissionState("3");
        jsoupMissionAllHistory.setMissionResultUrl(fileName);
        jsoupMissionAllHistory.setFinishTime(new Date());
        jsoupMissionAllHistoryMapper.updateByPrimaryKeySelective(jsoupMissionAllHistory);

    }

    /**
     * 这里发送服务
     * @param maId
     * @param userId
     * @return
     */
    @Override
    public void sendJavaSoup(Integer maId, Integer userId, TimeTaskRequest timeTaskRequest) {
        //添加一个序列1 的 missionOrder
        JsoupMissionAll jsoupMissionAll = missionAllMapper.selectByPrimaryKey(maId);
        JsoupMissionAllHistory history = new JsoupMissionAllHistory();
        history.setSentTime(new Date());
        history.setMissionAllId(jsoupMissionAll.getMaId());
        history.setMissionState("1");
        history.setUserId(userId);
        history.setMissionAllName(jsoupMissionAll.getMaName());
        history.setMissionAllDis(jsoupMissionAll.getMaTip());
        history.setSaleNum(0);
        history.setSalePrice(new BigDecimal(200));
        history.setSaleRate("0");
        jsoupMissionAllHistoryMapper.insertSelective(history);
        //获取参数列表 实际上参数列表来源于之前网络请求的参数列表  但是这里需要修改确认参数是否合理
        List<JsoupPragram> pragrams = timeTaskRequest.getPragrams();
        for (JsoupPragram pragram : pragrams) {
            pragram.setFatherId(pragram.getPragramId());
            pragram.setMhId(history.getMissionAllHistoryId());
            pragram.setDeep(1);
            pragram.setNeedAdd(0);
            pragramMapper.insertSelective(pragram);
        }
        jsoupMissionService.addRunningParameter(history.getMissionAllHistoryId());

    }
}
