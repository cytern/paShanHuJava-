package dam.jsoup.updatereport.updatreport.pojo;

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
     * 任务执行状态0 或空 异常状态2 执行中1 排队执行中3 执行完成且成功4 执行完成但失败5 定时任务原数据
     */
    @ApiModelProperty(value = "任务执行状态0 或空 异常状态2 执行中1 排队执行中3 执行完成且成功4 执行完成但失败5 定时任务原数据")
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
    @ApiModelProperty(value = "发送执行时间")
    private Date sentTime;

    /**
     * 完成时间
     */
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
     * 0 未上架1 已上架
     */
    @ApiModelProperty(value = "0 未上架1 已上架,")
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

    /**
     * 是否是定时任务
     */
    @ApiModelProperty(value = "是否是定时任务")
    private Integer isTimeTask;

    /**
     * 定时任务执行次数 -1 为无限循环
     */
    @ApiModelProperty(value = "定时任务执行次数 -1 为无限循环")
    private Integer timeNum;

    /**
     * 定时任务表达式
     */
    @ApiModelProperty(value = "定时任务表达式")
    private String timeCorn;

    /**
     * 执行器cpu标识码
     */
    @ApiModelProperty(value = "执行器cpu标识码")
    private String excutorCode;

    /**
     * 执行器token值
     */
    @ApiModelProperty(value = "执行器token值")
    private String excutorToken;

    /**
     * 点踩数
     */
    @ApiModelProperty(value = "点踩数")
    private Integer downNum;

    private static final long serialVersionUID = 1L;
}