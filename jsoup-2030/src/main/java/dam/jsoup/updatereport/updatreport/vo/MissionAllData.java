package dam.jsoup.updatereport.updatreport.vo;

import dam.jsoup.updatereport.updatreport.pojo.JsoupMissionAll;
import dam.jsoup.updatereport.updatreport.pojo.JsoupMissionOrder;
import lombok.Data;

import java.util.List;

/**
 * jsoup 总任务实体
 *
 */
@Data
public class MissionAllData {
    /**
     * 与之关联的总任务order
     */
    private List<JsoupMissionOrder> orders;
    /**
     * mission Data
     */
    private List<MissionData> missionDataList;
    /**
     * mission all 的数据
     */
    private JsoupMissionAll jsoupMissionAll;
    /**
     * 是否是拥有者{可否修改}
     */
    private Integer isOwner;

}
