package dam.jsoup.updatereport.updatreport.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "dam-jsoup-updatereport-updatreport-pojo-JsoupComplaint")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsoupComplaint implements Serializable {
    @ApiModelProperty(value = "")
    private Integer id;

    /**
     * 1:脚本 2:数据 3:文章
     */
    @ApiModelProperty(value = "1:脚本 2:数据 3:文章")
    private String typeId;

    /**
     * 商品id
     */
    @ApiModelProperty(value = "商品id")
    private Integer connectId;

    /**
     * 发起人用户id
     */
    @ApiModelProperty(value = "发起人用户id")
    private Integer userId;

    /**
     * 投诉简要
     */
    @ApiModelProperty(value = "投诉简要")
    private String desType;

    /**
     * 投诉内容
     */
    @ApiModelProperty(value = "投诉内容")
    private String des;

    /**
     * 状态： 1 已接受  2 已处理
     */
    @ApiModelProperty(value = "状态： 1 已接受  2 已处理")
    private String status;

    @ApiModelProperty(value = "")
    private Date sentTime;

    @ApiModelProperty(value = "")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}