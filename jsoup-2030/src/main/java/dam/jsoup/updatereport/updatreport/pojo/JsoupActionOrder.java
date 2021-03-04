package dam.jsoup.updatereport.updatreport.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="dam-jsoup-updatereport-updatreport-pojo-JsoupActionOrder")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsoupActionOrder implements Serializable {
    @ApiModelProperty(value="")
    private Integer actionOrderId;

    @ApiModelProperty(value="")
    private Integer actionId;

    @ApiModelProperty(value="")
    private Integer missionId;

    @ApiModelProperty(value="")
    private Integer missionAllId;

    @ApiModelProperty(value="")
    private Integer rank;

    private static final long serialVersionUID = 1L;
}