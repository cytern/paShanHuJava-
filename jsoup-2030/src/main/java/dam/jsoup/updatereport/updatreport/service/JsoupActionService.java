package dam.jsoup.updatereport.updatreport.service;

import dam.jsoup.updatereport.updatreport.pojo.JsoupAction;
import dam.jsoup.updatereport.updatreport.pojo.JsoupPragram;
import dam.jsoup.updatereport.updatreport.vo.ActionVo;

import java.util.List;
import java.util.Map;

public interface JsoupActionService {
    /**
     * 修改mission 下的jsoup 此方法为覆盖式修改，如没有actionId 则会创建id
     * @param  actionList list格式入参的action
     * @return 是否修改成功
     */
    Integer updateAction(List<JsoupAction> actionList);

    /**
     * 获取一个mission 下的全部action
     * @param missionId 任务id
     * @return 列表mission
     */
     List<JsoupAction> searchByMissionId (Integer missionId);

    /**
     * 此方法为更新一个mission 的全部action 此方法为常用方法 会清楚原有action 重新载入全部mission
     * @param actionList 行动列表
     * @return 是否成功
     */
    Integer updateMission (List<JsoupAction> actionList);

    /**
     * 此方法为删除一群action
     * @param actionIds 行动id
     * @return 是否成功
     */
    Integer deleteAction(List<Integer> actionIds);

    /**
     * 此方法为删除一个mission 中的全部action
     * @param missionId 任务id
     * @return 是否成功
     */
    Integer deleteMission(Integer missionId);

    /**
     * 获取一个mission id missionAll id 下的全部 actionVo
     * @param missionId
     * @return
     */
    List<ActionVo> getAllActionVos(Integer missionId);
}
