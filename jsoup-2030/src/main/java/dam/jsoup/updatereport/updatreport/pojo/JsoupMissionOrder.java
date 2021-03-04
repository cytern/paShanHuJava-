package dam.jsoup.updatereport.updatreport.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "dam-jsoup-updatereport-updatreport-pojo-JsoupMissionOrder")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsoupMissionOrder implements Serializable {
    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    private Integer missionOrderId;

    /**
     * 任务组id
     */
    @ApiModelProperty(value = "任务组id")
    private Integer moMissionId;

    /**
     * 主任务id
     */
    @ApiModelProperty(value = "主任务id")
    private Integer moMissionAllId;

    /**
     * 添加时间
     */
    @ApiModelProperty(value = "添加时间")
    private Date moAddTime;

    /**
     * 任务顺序
     */
    @ApiModelProperty(value = "任务顺序")
    private Integer moRank;

    private static final long serialVersionUID = 1L;
}