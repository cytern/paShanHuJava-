package dam.jsoup.updatereport.updatreport.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "dam-jsoup-updatereport-updatreport-pojo-JsoupActionHis")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsoupActionHis implements Serializable {
    /**
     * 历史id 主键
     */
    @ApiModelProperty(value = "历史id 主键")
    private Integer actionHisId;

    /**
     * 历史建的值
     */
    @ApiModelProperty(value = "历史建的值")
    private String actionHisEleValue;

    /**
     * 历史日期
     */
    @ApiModelProperty(value = "历史日期")
    private Date actionHisDate;

    /**
     * 历史mission id
     */
    @ApiModelProperty(value = "历史mission id")
    private Integer actionHisMissionId;

    /**
     * 历史action id
     */
    @ApiModelProperty(value = "历史action id")
    private Integer actionHisActionId;

    /**
     * 历史汇总任务id
     */
    @ApiModelProperty(value = "历史汇总任务id")
    private Integer ahMaId;

    private static final long serialVersionUID = 1L;
}