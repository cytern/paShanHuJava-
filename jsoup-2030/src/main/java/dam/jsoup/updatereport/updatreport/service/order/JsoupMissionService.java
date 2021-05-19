package dam.jsoup.updatereport.updatreport.service.order;

import dam.jsoup.updatereport.updatreport.pojo.JsoupMissionAll;
import dam.jsoup.updatereport.updatreport.pojo.JsoupMissionAllHistory;
import dam.jsoup.updatereport.updatreport.pojo.JsoupPragram;
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
     * 获取一个执行任务数据
     * @param mhId
     * @return
     */
    MissionAllData getRunningMissionData(Integer mhId);
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

    /**
     * 获取能够购买的全部任务
     * @return
     */
    List<JsoupMissionAll> getSalesMa(Integer userId);


    /**
     * 获取能够购买的全部结果集
     */
    List<JsoupMissionAllHistory> getSalesMh(Integer userId);


    /**
     * 设置结果集状态 售价
     * @param jsoupMissionAllHistory 历史
     * @return
     */
    Map setMhState (JsoupMissionAllHistory jsoupMissionAllHistory,Integer userId);

    /**
     * 购买一个脚本
     * @param userId 用户id
     * @param maId 脚本id
     * @return
     */
    Map byMa(Integer userId,Integer maId);


    /**
     * 购买一个结果集
     * @param userId 用户id
     * @param mhId  结果集id
     * @return
     */
    Map byMh(Integer userId,Integer mhId);

    /**
     * 通过 ma 或者 mh 的id 获取 一个详细信息
     * @param id id
     * @param type 类型 1 为 ma 2 为mh
     * @return
     */
    Map getGoodUserDetail(Integer id,Integer type);

    /**
     * 获取商品详情
     * @param id
     * @param type
     * @return
     */
    List getGoodOrderDetail(Integer id,Integer type);

    /**
     * 发送一个定时任务脚本
     * @param maId
     * @param userId
     * @param corn
     * @return
     */
    Map addAutoWorkMission(Integer maId, Integer userId, String corn, Integer times, List<JsoupPragram> jsoupPragrams);

    /**
     * 删除一个定时任务
     * @param mhId
     * @param userId
     * @return
     */
    Map deleteAutoWorkMission(Integer mhId,Integer userId);

    /**
     * 更新一个定时任务
     * @param mhId
     * @param corn
     * @return
     */
    Map updateAutoWorkMission(Integer mhId,String corn,Integer times,Integer userId);


     void addRunningParameter(Integer mhId);

     Map copyNewMission(Integer maId,Integer userId);
}
