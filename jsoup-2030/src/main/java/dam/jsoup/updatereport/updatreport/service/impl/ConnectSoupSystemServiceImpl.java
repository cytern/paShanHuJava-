package dam.jsoup.updatereport.updatreport.service.impl;

import dam.jsoup.updatereport.updatreport.dao.JsoupMissionAllHistoryMapper;
import dam.jsoup.updatereport.updatreport.dao.JsoupMissionAllMapper;
import dam.jsoup.updatereport.updatreport.dao.MhMapper;
import dam.jsoup.updatereport.updatreport.pojo.JsoupMissionAll;
import dam.jsoup.updatereport.updatreport.pojo.JsoupMissionAllHistory;
import dam.jsoup.updatereport.updatreport.service.ConnectSoupSystemService;
import dam.jsoup.updatereport.updatreport.service.FileExcutorService;
import dam.jsoup.updatereport.updatreport.vo.MissionAllData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class ConnectSoupSystemServiceImpl implements ConnectSoupSystemService {
    private final MhMapper mapper;
    private final JsoupMissionAllHistoryMapper historyMapper;
    private final FileExcutorService fileExcutorService;
    private final String dir = "E:\\projects\\excelData\\";
    private final JsoupMissionAllMapper missionAllMapper;

    public ConnectSoupSystemServiceImpl(MhMapper mapper, JsoupMissionAllHistoryMapper historyMapper, FileExcutorService fileExcutorService, JsoupMissionAllMapper missionAllMapper) {
        this.mapper = mapper;
        this.historyMapper = historyMapper;
        this.fileExcutorService = fileExcutorService;
        this.missionAllMapper = missionAllMapper;
    }

    /**
     * 获取待执行服务
     *
     * @return
     */
    @Override
    public JsoupMissionAllHistory getOneWaitService() {
        return mapper.getOneWaitToDoTask();
    }

    /**
     * 接受执行完毕数据
     *
     * @param result
     * @param missionAllData
     */
    @Override
    public void storeBackData(List result, MissionAllData missionAllData) {
        JsoupMissionAllHistory mh = null;
        String fileName = null;
        try {
            JsoupMissionAllHistory temp = missionAllData.getMissionAllHistory();
            //获取任务序号
            mh = historyMapper.selectByPrimaryKey(temp.getMissionAllHistoryId());
            //获取任务总情况
            JsoupMissionAll missionAll = missionAllMapper.selectByPrimaryKey(mh.getMissionAllId());
            fileName = fileExcutorService.fileInput(result, dir, missionAll.getMaSuccessFileName());
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
