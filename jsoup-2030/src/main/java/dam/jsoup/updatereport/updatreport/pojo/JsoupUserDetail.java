package dam.jsoup.updatereport.updatreport.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "dam-jsoup-updatereport-updatreport-pojo-JsoupUserDetail")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsoupUserDetail implements Serializable {
    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    private Integer userDetailId;

    /**
     * 真名
     */
    @ApiModelProperty(value = "真名")
    private String userRealName;

    /**
     * 小名
     */
    @ApiModelProperty(value = "小名")
    private String userNickName;

    /**
     * 头像url
     */
    @ApiModelProperty(value = "头像url")
    private String userImageUrl;

    /**
     * 描述-签名
     */
    @ApiModelProperty(value = "描述-签名")
    private String userDes;

    /**
     * 关连建
     */
    @ApiModelProperty(value = "关连建")
    private Integer userId;

    @ApiModelProperty(value = "")
    private String userEmail;

    @ApiModelProperty(value = "")
    private String userPhone;

    private static final long serialVersionUID = 1L;
}