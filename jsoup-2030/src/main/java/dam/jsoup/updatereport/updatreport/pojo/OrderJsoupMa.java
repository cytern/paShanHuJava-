package dam.jsoup.updatereport.updatreport.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="dam-jsoup-updatereport-updatreport-pojo-OrderJsoupMa")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderJsoupMa implements Serializable {
    /**
    * 订单号
    */
    @ApiModelProperty(value="订单号")
    private Integer orderId;

    /**
    * 持有者id
    */
    @ApiModelProperty(value="持有者id")
    private Integer ownerUserId;

    /**
    * 购买者id
    */
    @ApiModelProperty(value="购买者id")
    private Integer customerUserId;

    /**
    * 完成时间
    */
    @ApiModelProperty(value="完成时间")
    private Date createTime;

    /**
    * 完成价格
    */
    @ApiModelProperty(value="完成价格")
    private BigDecimal finishPrice;

    /**
    * 分数
    */
    @ApiModelProperty(value="分数")
    private Integer score;

    /**
    * 总任务id
    */
    @ApiModelProperty(value="总任务id")
    private Integer maId;

    private static final long serialVersionUID = 1L;
}