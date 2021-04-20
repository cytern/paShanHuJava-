package dam.jsoup.updatereport.updatreport.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "dam-jsoup-updatereport-updatreport-pojo-JsoupExcutor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsoupExcutor implements Serializable {
    @ApiModelProperty(value = "")
    private Integer id;

    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private Integer userId;

    /**
     * 执行器cpu标码
     */
    @ApiModelProperty(value = "执行器cpu标码")
    private String excutorCode;

    /**
     * 执行器token值
     */
    @ApiModelProperty(value = "执行器token值")
    private String excutorToken;

    /**
     * 执行器执行次数
     */
    @ApiModelProperty(value = "执行器执行次数")
    private Integer excutorTimes;

    /**
     * 成功次数
     */
    @ApiModelProperty(value = "成功次数")
    private Integer successTimes;

    @ApiModelProperty(value = "")
    private Date liveUpdateTime;

    /**
     * 1在线 2不在线
     */
    @ApiModelProperty(value = "1在线 2不在线")
    private String status;

    @ApiModelProperty(value = "")
    private Date createTime;

    private static final long serialVersionUID = 1L;
}