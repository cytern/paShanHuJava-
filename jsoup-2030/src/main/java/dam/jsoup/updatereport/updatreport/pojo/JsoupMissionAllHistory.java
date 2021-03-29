package dam.jsoup.updatereport.updatreport.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "dam-jsoup-updatereport-updatreport-pojo-JsoupMissionAllHistory")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsoupMissionAllHistory implements Serializable {
    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    private Integer missionAllHistoryId;

    /**
     * 总任务id
     */
    @ApiModelProperty(value = "总任务id")
    private Integer missionAllId;

    /**
     * 任务执行状态
     * 0 或空 异常状态
     * 2 执行中
     * 1 排队执行中
     * 3 执行完成且成功
     * 4 执行完成但失败
     */
    @ApiModelProperty(value = "任务执行状态,0 或空 异常状态,2 执行中,1 排队执行中,3 执行完成且成功,4 执行完成但失败")
    private String missionState;

    /**
     * 执行完成文件地址
     */
    @ApiModelProperty(value = "执行完成文件地址")
    private String missionResultUrl;

    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private Integer userId;

    /**
     * 失败原因
     */
    @ApiModelProperty(value = "失败原因")
    private String missionFailReason;

    /**
     * 发送执行时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "发送执行时间")
    private Date sentTime;

    /**
     * 完成时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "完成时间")
    private Date finishTime;

    /**
     * 任务名称
     */
    @ApiModelProperty(value = "任务名称")
    private String missionAllName;

    /**
     * 任务作用
     */
    @ApiModelProperty(value = "任务作用")
    private String missionAllDis;

    /**
     * 0 未上架
     * 1 已上架
     */
    @ApiModelProperty(value = "0 未上架,1 已上架,")
    private String onSale;

    /**
     * 出售价格
     */
    @ApiModelProperty(value = "出售价格,")
    private BigDecimal salePrice;

    /**
     * 评分
     */
    @ApiModelProperty(value = "评分")
    private String saleRate;

    /**
     * 出售份数
     */
    @ApiModelProperty(value = "出售份数")
    private Integer saleNum;

    /**
     * 标签
     */
    @ApiModelProperty(value = "标签")
    private String tips;

    /**
     * 作者名称
     */
    @ApiModelProperty(value = "作者名称")
    private String userName;

    /**
     * 是否是官方来源
     */
    @ApiModelProperty(value = "是否是官方来源")
    private String isAoto;

    /**
     * 图片
     */
    @ApiModelProperty(value = "图片")
    private String hsUrl;

    private static final long serialVersionUID = 1L;
}