package dam.server.demo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
    /**
     * 是否有通过的测试集
     */
    private Integer isSuccess;
    /**
     * 任务历史数据
     */
    private JsoupMissionAllHistory missionAllHistory;

}


