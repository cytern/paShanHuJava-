package dam.jsoup.updatereport.updatreport.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "dam-jsoup-updatereport-updatreport-pojo-JsoupUser")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsoupUser implements Serializable {
    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Integer userId;

    /**
     * 账号
     */
    @ApiModelProperty(value = "账号")
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String password;

    /**
     * 建立时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    @ApiModelProperty(value = "建立时间")
    private Date createTime;

    /**
     * 用户标记 用于记录登录情况
     */
    @ApiModelProperty(value = "用户标记 用于记录登录情况")
    private String userToken;

    /**
     * 用户类型 用于记录用户类型
     * 1001： root 类型
     * 1002：customer 类型
     */
    @ApiModelProperty(value = "用户类型 用于记录用户类型,1001： root 类型,1002：customer 类型")
    private String userType;

    private static final long serialVersionUID = 1L;
}