package dam.jsoup.updatereport.updatreport.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "dam-jsoup-updatereport-updatreport-pojo-JsoupMissionHistory")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsoupMissionHistory implements Serializable {
    /**
     * 历史状态id
     */
    @ApiModelProperty(value = "历史状态id")
    private Integer missionStateId;

    /**
     * 历史任务id
     */
    @ApiModelProperty(value = "历史任务id")
    private Integer missionId;

    /**
     * 执行时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    @ApiModelProperty(value = "执行时间")
    private Date missionTime;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String content;

    /**
     * 历史总任务id
     */
    @ApiModelProperty(value = "历史总任务id")
    private Integer missionAllId;

    private static final long serialVersionUID = 1L;
}