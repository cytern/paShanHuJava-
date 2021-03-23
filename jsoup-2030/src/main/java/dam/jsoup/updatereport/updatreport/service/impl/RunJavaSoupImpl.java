package dam.jsoup.updatereport.updatreport.service.impl;

import dam.jsoup.updatereport.updatreport.dao.JsoupMissionAllHistoryMapper;
import dam.jsoup.updatereport.updatreport.dao.JsoupMissionAllMapper;
import dam.jsoup.updatereport.updatreport.pojo.JsoupMissionAll;
import dam.jsoup.updatereport.updatreport.pojo.JsoupMissionAllHistory;
import dam.jsoup.updatereport.updatreport.pojo.JsoupMissionAllHistoryExample;
import dam.jsoup.updatereport.updatreport.service.FileExcutorService;
import dam.jsoup.updatereport.updatreport.service.RunJavaSoup;
import dam.jsoup.updatereport.updatreport.service.SendExcutorServcie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class RunJavaSoupImpl implements RunJavaSoup {

    private final SendExcutorServcie sendExcutorServcie;
    private final JsoupMissionAllHistoryMapper jsoupMissionAllHistoryMapper;
    private final FileExcutorService fileExcutorService;
    private final String dir = "E:\\projects\\excelData\\";
    private final JsoupMissionAllMapper missionAllMapper;

    public RunJavaSoupImpl(SendExcutorServcie sendExcutorServcie, JsoupMissionAllHistoryMapper jsoupMissionAllHistoryMapper, FileExcutorService fileExcutorService, JsoupMissionAllMapper missionAllMapper) {
        this.sendExcutorServcie = sendExcutorServcie;
        this.jsoupMissionAllHistoryMapper = jsoupMissionAllHistoryMapper;
        this.fileExcutorService = fileExcutorService;
        this.missionAllMapper = missionAllMapper;
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
    public void sendJavaSoup(Integer maId, Integer userId) {
        //添加一个序列1 的 missionOrder
        JsoupMissionAll jsoupMissionAll = missionAllMapper.selectByPrimaryKey(maId);
        JsoupMissionAllHistory history = new JsoupMissionAllHistory();
        history.setSentTime(new Date());
        history.setMissionAllId(jsoupMissionAll.getMaId());
        history.setMissionState("2");
        history.setUserId(userId);
        history.setMissionAllName(jsoupMissionAll.getMaName());
        history.setMissionAllDis(jsoupMissionAll.getMaTip());
        int i = jsoupMissionAllHistoryMapper.insertSelective(history);
        //直接执行这个order
        try {
            runJavaSoup(history.getMissionAllHistoryId(),userId);
        } catch (Exception e) {
           history.setMissionState("4");
           if (e.getMessage().contains("Invalid cell range") || e.getMessage().contains("Merged region")){
               history.setMissionFailReason("内部异常:文件生成器");
           }else if (e.getMessage().contains("interrupt")){
               history.setMissionFailReason("内部异常:脚本执行器");
           }else if (e.getMessage().contains("com.netflix.client.ClientException: Load balancer does not have available server for client")){
               history.setMissionFailReason("内部异常:集群服务");
           }else {
               history.setMissionFailReason(e.getMessage());
           }
           jsoupMissionAllHistoryMapper.updateByPrimaryKeySelective(history);
           throw new RuntimeException(e.getMessage());
        }

    }
}
