package dam.jsoup.updatereport.updatreport.service;

import java.util.Map;

/**
 * @author dam
 * @version 1.0
 * @date 2020/12/22 18:27
 */
public interface ExecutorMission {
    /**
     * 执行driver操作
     * @param missionId 任务id
     * @return 执行结果
     */
    Map<String,String> startMission(int missionId);
}
