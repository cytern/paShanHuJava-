package dam.jsoup.updatereport.updatreport.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "dam-jsoup-updatereport-updatreport-pojo-JsoupMission")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsoupMission implements Serializable {
    /**
     * 主id
     */
    @ApiModelProperty(value = "主id")
    private Integer missionId;

    /**
     * 动作组名称
     */
    @ApiModelProperty(value = "动作组名称")
    private String missionName;

    /**
     * 起始action id
     */
    @ApiModelProperty(value = "起始action id ")
    private Integer startActionId;

    /**
     * 废弃字段  提示邮箱  已放入 mission all
     */
    @ApiModelProperty(value = "废弃字段  提示邮箱  已放入 mission all")
    private String noticeEmail;

    /**
     * 废弃字段  完成任务提示
     */
    @ApiModelProperty(value = "废弃字段  完成任务提示")
    private String endTagContains;

    /**
     * 废弃字段  起始url  已放入 mission all
     */
    @ApiModelProperty(value = "废弃字段  起始url  已放入 mission all")
    private String missionStartUrl;

    /**
     * 废弃字段 已放入 mission all
     */
    @ApiModelProperty(value = "废弃字段 已放入 mission all")
    private String missionSuccessExcelName;

    private static final long serialVersionUID = 1L;
}