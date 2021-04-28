package dam.jsoup.updatereport.updatreport.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="dam-jsoup-updatereport-updatreport-pojo-JsoupUpDown")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsoupUpDown implements Serializable {
    /**
    * 主键
    */
    @ApiModelProperty(value="主键")
    private Integer id;

    /**
    * 发起人id
    */
    @ApiModelProperty(value="发起人id")
    private Integer userId;

    /**
    * 1:脚本 2:数据 3：文章
    */
    @ApiModelProperty(value="1:脚本 2:数据 3：文章")
    private Integer typeId;

    /**
    * 关联id
    */
    @ApiModelProperty(value="关联id")
    private Integer connectId;

    /**
    * 1:赞 -1：差评
    */
    @ApiModelProperty(value="1:赞 -1：差评")
    private Integer upDown;

    /**
    * 创建日期
    */
    @ApiModelProperty(value="创建日期")
    private Date createTime;

    private static final long serialVersionUID = 1L;
}