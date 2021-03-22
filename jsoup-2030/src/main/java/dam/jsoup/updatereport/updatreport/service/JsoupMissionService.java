package dam.jsoup.updatereport.updatreport.service;

import dam.jsoup.updatereport.updatreport.pojo.JsoupMissionAll;
import dam.jsoup.updatereport.updatreport.pojo.JsoupMissionAllHistory;
import dam.jsoup.updatereport.updatreport.vo.MissionAllData;

import java.util.List;
import java.util.Map;

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


    /**
     * 存取一个完整的脚本信息
     * @param missionAllData 总集合
     * @return 总集合
     */
    Integer saveMissionAll( MissionAllData missionAllData,Integer userId);

    /**
     * 更改保存用户总订单id
     * @param jsoupMissionAll  总任务
     * @param userId  用户id
     * @return
     */
    Map setMissionAllState (JsoupMissionAll jsoupMissionAll,Integer userId);



}
