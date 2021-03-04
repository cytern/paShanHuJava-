package dam.jsoup.updatereport.updatreport.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "dam-jsoup-updatereport-updatreport-pojo-JsoupUserAssets")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsoupUserAssets implements Serializable {
    /**
     * 用户资产id
     */
    @ApiModelProperty(value = "用户资产id")
    private Integer userAssetsId;

    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private Integer userId;

    /**
     * 硬币数目
     */
    @ApiModelProperty(value = "硬币数目")
    private Integer cornNum;

    /**
     * 金币数目
     */
    @ApiModelProperty(value = "金币数目")
    private Integer goldNum;

    private static final long serialVersionUID = 1L;
}