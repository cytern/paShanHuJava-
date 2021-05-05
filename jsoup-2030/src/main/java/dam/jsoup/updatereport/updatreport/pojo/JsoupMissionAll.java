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

@ApiModel(value = "dam-jsoup-updatereport-updatreport-pojo-JsoupMissionAll")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsoupMissionAll implements Serializable {
    /**
     * 任务主id
     */
    @ApiModelProperty(value = "任务主id ")
    private Integer maId;

    /**
     * 任务名
     */
    @ApiModelProperty(value = "任务名")
    private String maName;

    /**
     * 任务描述
     */
    @ApiModelProperty(value = "任务描述")
    private String maTip;

    /**
     * 起始url
     */
    @ApiModelProperty(value = "起始url")
    private String malStartUrl;

    /**
     * 任务完成后生成文件名
     */
    @ApiModelProperty(value = "任务完成后生成文件名")
    private String maSuccessFileName;

    /**
     * 用户id 与用户表关联 已废弃
     */
    @ApiModelProperty(value = "用户id 与用户表关联 已废弃")
    private Integer maUserId;

    /**
     * 任务完成后提示邮箱
     */
    @ApiModelProperty(value = "任务完成后提示邮箱")
    private String maNoticeEmail;

    /**
     * 拥有者id
     */
    @ApiModelProperty(value = "拥有者id")
    private Integer userId;

    /**
     * 任务状态
     * 0 编辑中
     * 1 未上架
     * 2 已上架
     */
    @ApiModelProperty(value = "任务状态,0 编辑中,1 未上架,2 已上架")
    private Integer maState;

    /**
     * 价格
     */
    @ApiModelProperty(value = "价格")
    private BigDecimal maPrice;

    /**
     * 创造时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创造时间")
    private Date createTime;

    /**
     * 评分
     */
    @ApiModelProperty(value = "评分")
    private String maRate;

    /**
     * 售卖份数
     */
    @ApiModelProperty(value = "售卖份数")
    private Integer maSaleNum;

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
    private String isAuto;

    /**
     * 脚本图片
     */
    @ApiModelProperty(value = "脚本图片")
    private String maUrl;

    private static final long serialVersionUID = 1L;
}