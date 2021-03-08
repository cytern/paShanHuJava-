package dam.jsoup.updatereport.updatreport.service.impl;

import dam.jsoup.updatereport.updatreport.dao.JsoupMissionAllHistoryMapper;
import dam.jsoup.updatereport.updatreport.pojo.JsoupMissionAllHistory;
import dam.jsoup.updatereport.updatreport.pojo.JsoupMissionAllHistoryExample;
import dam.jsoup.updatereport.updatreport.service.RunJavaSoup;
import dam.jsoup.updatereport.updatreport.service.SendExcutorServcie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class RunJavaSoupImpl implements RunJavaSoup {

    private final SendExcutorServcie sendExcutorServcie;
    private final JsoupMissionAllHistoryMapper jsoupMissionAllHistoryMapper;

    public RunJavaSoupImpl(SendExcutorServcie sendExcutorServcie, JsoupMissionAllHistoryMapper jsoupMissionAllHistoryMapper) {
        this.sendExcutorServcie = sendExcutorServcie;
        this.jsoupMissionAllHistoryMapper = jsoupMissionAllHistoryMapper;
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
        if (!jsoupMissionAllHistory.getMissionState().equals("1")){
            return;
        }
        //发送执行服务
        Map map;
        try {
             map = sendExcutorServcie.sendGoExcutor(jsoupMissionAllHistory.getMissionAllId(), userId);
             if (map.get("code").equals("error")){
                 throw new RuntimeException("错误的状态码");
             }
        } catch (Exception e) {
           log.error("执行错误",e);
        }
        //进行下一步 将数据发送至文件生成器
        return;


    }
}
