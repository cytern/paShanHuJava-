package dam.jsoup.updatereport.updatreport.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="dam-jsoup-updatereport-updatreport-pojo-JsoupArticle")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsoupArticle implements Serializable {
    /**
    * 主键
    */
    @ApiModelProperty(value="主键")
    private Integer id;

    /**
    * 创建日期
    */
    @ApiModelProperty(value="创建日期")
    private Date createTime;

    /**
    * 更新日期
    */
    @ApiModelProperty(value="更新日期")
    private Date updateTime;

    /**
    * 用户id
    */
    @ApiModelProperty(value="用户id")
    private Integer userId;

    /**
    * 标题
    */
    @ApiModelProperty(value="标题")
    private String title;

    /**
    * 内容
    */
    @ApiModelProperty(value="内容")
    private String body;

    /**
    * 点赞数
    */
    @ApiModelProperty(value="点赞数")
    private Integer upNum;

    /**
    * 点差评数目
    */
    @ApiModelProperty(value="点差评数目")
    private Integer downNum;

    private static final long serialVersionUID = 1L;
}