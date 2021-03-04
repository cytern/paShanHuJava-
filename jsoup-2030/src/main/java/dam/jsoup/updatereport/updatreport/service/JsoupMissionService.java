package dam.jsoup.updatereport.updatreport.service;

import dam.jsoup.updatereport.updatreport.pojo.JsoupMissionAllHistory;
import dam.jsoup.updatereport.updatreport.vo.MissionAllData;

import java.util.List;

/**
 * 涉及到mission层的操作
 */
public interface JsoupMissionService {
    /**
     * 获取格式化的任务数据
     * @param missionAllId 任务总id
     * @return 格式化数据
     */
    MissionAllData getMissionAllData(Integer missionAllId,Integer userId);

    /**
     * 获取某个用户的全部可使用脚本
     * @param userId 用户id
     * @return 格式化数据
     */
    List<MissionAllData> getOnesOrder(Integer userId);


    /**
     * 获取某个用户的全部脚本执行历史
     * @param userId 用户id
     * @return 脚本历史
     */
    List<JsoupMissionAllHistory> getMissionAllHistory(Integer userId);

}
