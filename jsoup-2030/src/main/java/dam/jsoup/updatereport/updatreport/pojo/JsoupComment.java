package dam.jsoup.updatereport.updatreport.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="dam-jsoup-updatereport-updatreport-pojo-JsoupComment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsoupComment implements Serializable {
    /**
    * 主键
    */
    @ApiModelProperty(value="主键")
    private Integer id;

    /**
    * 关联主键：是否是楼中楼
    */
    @ApiModelProperty(value="关联主键：是否是楼中楼")
    private Integer fatherId;

    /**
    * 1：脚本 2：数据 3：帖子
    */
    @ApiModelProperty(value="1：脚本 2：数据 3：帖子")
    private Integer typeId;

    /**
    * 评价
    */
    @ApiModelProperty(value="评价")
    private String comment;

    /**
    * 点赞数
    */
    @ApiModelProperty(value="点赞数")
    private Integer upNum;

    /**
    * 点差数
    */
    @ApiModelProperty(value="点差数")
    private Integer downNum;

    /**
    * 用户名
    */
    @ApiModelProperty(value="用户名")
    private Integer userId;

    /**
    * 关联键主键id
    */
    @ApiModelProperty(value="关联键主键id")
    private Integer connectId;

    /**
    * 创建日期
    */
    @ApiModelProperty(value="创建日期")
    private Date cteateTime;

    private static final long serialVersionUID = 1L;
}