package dam.server.demo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsoupPragram implements Serializable {
    /**
     * 字段id主键
     */
    @ApiModelProperty(value = "字段id主键")
    private Integer pragramId;

    /**
     * 任务组id
     */
    @ApiModelProperty(value = "任务组id")
    private Integer missionId;

    /**
     * 动作id
     */
    @ApiModelProperty(value = "动作id")
    private Integer actionId;

    /**
     * 值的数据类型 int  decimal  string  date  variable  page
     */
    @ApiModelProperty(value = "值的数据类型 int  decimal  string  date  variable  page")
    private String pragramType;

    /**
     * 如果值为 decimal 的小数位数 最大值为5位
     */
    @ApiModelProperty(value = "如果值为 decimal 的小数位数 最大值为5位")
    private Integer pragramAccuracy;

    /**
     * 0 为否  1 为是
     */
    @ApiModelProperty(value = "0 为否  1 为是")
    private Integer isRamdom;

    /**
     * 上区间 随机数
     */
    @ApiModelProperty(value = "上区间 随机数")
    private BigDecimal upNum;

    /**
     * 下区间 随机数
     */
    @ApiModelProperty(value = "下区间 随机数")
    private BigDecimal downNum;

    /**
     * 字段值
     */
    @ApiModelProperty(value = "字段值")
    private String pragramValue;

    /**
     * 主任务进程id 监控全进程id
     */
    @ApiModelProperty(value = "主任务进程id 监控全进程id")
    private Integer missionAllId;

    /**
     * 字段别名
     */
    @ApiModelProperty(value = "字段别名 ")
    private String programContent;

    private static final long serialVersionUID = 1L;
}

