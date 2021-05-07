package dam.jsoup.updatereport.updatreport.service;

import dam.jsoup.updatereport.updatreport.vo.MissionAllData;
import dam.jsoup.updatereport.updatreport.vo.TimeTaskRequest;

import java.util.Map;

/**
 * 执行一个javaSoup
 */
public interface RunJavaSoup {
    /**
     * 执行服务
     * @param orderId
     * @param userId
     */
    void runJavaSoup(Integer orderId, Integer userId);


    void sendJavaSoup(Integer maId, Integer userId, TimeTaskRequest timeTaskRequest);
}
