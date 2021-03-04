package dam.jsoup.updatereport.updatreport.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "dam-jsoup-updatereport-updatreport-pojo-Setting")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Setting implements Serializable {
    @ApiModelProperty(value = "")
    private Integer settingId;

    @ApiModelProperty(value = "")
    private String settingValue;

    /**
     * 设备主板id
     */
    @ApiModelProperty(value = "设备主板id")
    private String biosId;

    /**
     * 1 .浏览器的执行器位置
     */
    @ApiModelProperty(value = "1 .浏览器的执行器位置")
    private String settingType;

    private static final long serialVersionUID = 1L;
}