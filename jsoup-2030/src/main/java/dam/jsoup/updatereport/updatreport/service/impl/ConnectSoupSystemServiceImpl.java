package dam.jsoup.updatereport.updatreport.service.impl;

import dam.jsoup.updatereport.updatreport.dao.JsoupMissionAllHistoryMapper;
import dam.jsoup.updatereport.updatreport.dao.JsoupMissionAllMapper;
import dam.jsoup.updatereport.updatreport.dao.MhMapper;
import dam.jsoup.updatereport.updatreport.pojo.JsoupMissionAll;
import dam.jsoup.updatereport.updatreport.pojo.JsoupMissionAllHistory;
import dam.jsoup.updatereport.updatreport.service.ConnectSoupSystemService;
import dam.jsoup.updatereport.updatreport.service.FileExcutorService;
import dam.jsoup.updatereport.updatreport.service.JsoupMissionService;
import dam.jsoup.updatereport.updatreport.vo.HttpMissionDataVo;
import dam.jsoup.updatereport.updatreport.vo.MissionAllData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class ConnectSoupSystemServiceImpl implements ConnectSoupSystemService {
    private final MhMapper mapper;
    private final JsoupMissionAllHistoryMapper historyMapper;
    private final FileExcutorService fileExcutorService;
    private final String dir = "E:\\projects\\excelData\\";
    private final JsoupMissionAllMapper missionAllMapper;
    private final JsoupMissionService missionService;

    public ConnectSoupSystemServiceImpl(MhMapper mapper, JsoupMissionAllHistoryMapper historyMapper, FileExcutorService fileExcutorService, JsoupMissionAllMapper missionAllMapper, JsoupMissionService missionService) {
        this.mapper = mapper;
        this.historyMapper = historyMapper;
        this.fileExcutorService = fileExcutorService;
        this.missionAllMapper = missionAllMapper;
        this.missionService = missionService;
    }

    /**
     * 获取待执行服务
     *
     * @return
     */
    @Override
    public HttpMissionDataVo getOneWaitService() {
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
        HttpMissionDataVo httpMissionDataVo = new HttpMissionDataVo();
        httpMissionDataVo.setMissionAllData(missionAllData);
        httpMissionDataVo.setJsoupMissionAllHistory(oneWaitToDoTask);
        httpMissionDataVo.setState(1);
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
            historyMapper.updateByPrimaryKeySelective(mh);
            return;
        }
        //生成文件服务
        String fileName = null;
        try {
            //获取任务总情况
            JsoupMissionAll missionAll = missionAllMapper.selectByPrimaryKey(mh.getMissionAllId());
            fileName = fileExcutorService.fileInput(httpMissionDataVo.getResult(), dir, missionAll.getMaSuccessFileName());
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
            historyMapper.updateByPrimaryKeySelective(mh);
        }
        //将文件名保存在his内
        mh.setMissionState("3");
        mh.setMissionResultUrl(fileName);
        mh.setFinishTime(new Date());
        historyMapper.updateByPrimaryKeySelective(mh);
    }
}
