package dam.jsoup.updatereport.updatreport.service;

import java.util.Map;

public interface ExecutorMissionAll {
    /**
     * 启动一个总任务
     * @param missionAllId 总领任务id
     * @return 任务执行情况
     */
    Map<String,String> startMissionAll(int missionAllId);
}
