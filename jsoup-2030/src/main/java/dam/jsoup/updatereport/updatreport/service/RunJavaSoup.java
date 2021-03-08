package dam.jsoup.updatereport.updatreport.service;

import dam.jsoup.updatereport.updatreport.vo.MissionAllData;

/**
 * 执行一个javaSoup
 */
public interface RunJavaSoup {
    /**
     * 执行服务
     * @param maId
     * @param userId
     */
    void runJavaSoup(Integer maId,Integer userId);
}
