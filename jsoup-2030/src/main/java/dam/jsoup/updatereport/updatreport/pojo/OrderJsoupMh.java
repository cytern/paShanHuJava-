package dam.jsoup.updatereport.updatreport.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "dam-jsoup-updatereport-updatreport-pojo-OrderJsoupMh")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderJsoupMh implements Serializable {
    /**
     * 订单id
     */
    @ApiModelProperty(value = "订单id")
    private Integer orderId;

    /**
     * 持有者用户id
     */
    @ApiModelProperty(value = "持有者用户id")
    private Integer ownerUserId;

    /**
     * 历史id
     */
    @ApiModelProperty(value = "历史id")
    private Integer mhId;

    /**
     * 购买时间
     */
    @ApiModelProperty(value = "购买时间")
    private Date createTime;

    /**
     * 顾客id
     */
    @ApiModelProperty(value = "顾客id")
    private Integer customerUserId;

    /**
     * 购买时价格
     */
    @ApiModelProperty(value = "购买时价格")
    private BigDecimal finishPrice;

    /**
     * 用户评分
     */
    @ApiModelProperty(value = "用户评分")
    private Integer score;

    /**
     * 用户评价
     */
    @ApiModelProperty(value = "用户评价")
    private String des;

    private static final long serialVersionUID = 1L;
}