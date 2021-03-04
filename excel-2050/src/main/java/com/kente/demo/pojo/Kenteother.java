package com.kente.demo.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@ApiModel(value = "com-kente-demo-pojo-Kenteother")
@Data
public class Kenteother implements Serializable {
    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Integer id;

    /**
     * 月份
     */
    @ApiModelProperty(value = "月份")
    private String mouth;

    /**
     * 开标日期
     */
    @ApiModelProperty(value = "开标日期")
    private String startTime;

    /**
     * 行业分类
     */
    @ApiModelProperty(value = "行业分类")
    private String type;

    /**
     * 级别
     */
    @ApiModelProperty(value = "级别")
    private String lv;

    /**
     * 项目类别
     */
    @ApiModelProperty(value = "项目类别")
    private String objType;

    /**
     * 产品类别
     */
    @ApiModelProperty(value = "产品类别")
    private String proType;

    /**
     * 代理商名称
     */
    @ApiModelProperty(value = "代理商名称")
    private String otherName;

    /**
     * 项目编号
     */
    @ApiModelProperty(value = "项目编号")
    private String projectId;

    /**
     * 项目名称
     */
    @ApiModelProperty(value = "项目名称")
    private String projectName;

    /**
     * 终端用户名称
     */
    @ApiModelProperty(value = "终端用户名称")
    private String finalUserName;

    /**
     * 招标数量
     */
    @ApiModelProperty(value = "招标数量")
    private Integer needNum;

    /**
     * 招标金额
     */
    @ApiModelProperty(value = "招标金额")
    private String needPrice;

    /**
     * 投标结果
     */
    @ApiModelProperty(value = "投标结果")
    private String needRes;

    /**
     * 中标单位
     */
    @ApiModelProperty(value = "中标单位")
    private String finalWin;

    /**
     * 未中标原因
     */
    @ApiModelProperty(value = "未中标原因")
    private String notReason;

    /**
     * 中标金额
     */
    @ApiModelProperty(value = "中标金额")
    private String finalPrice;

    /**
     * 未中标原因 详细
     */
    @ApiModelProperty(value = "未中标原因 详细")
    private String notReasonDetail;

    /**
     * KenteExcel
     */
    @ApiModelProperty(value = "KenteExcel")
    private String haveContract;

    /**
     * 合同金额
     */
    @ApiModelProperty(value = "合同金额")
    private String contractPrice;

    /**
     * 部门
     */
    @ApiModelProperty(value = "部门")
    private String department;

    /**
     * 销售区域
     */
    @ApiModelProperty(value = "销售区域")
    private String saleArea;

    /**
     * 销售
     */
    @ApiModelProperty(value = "销售")
    private String saleMan;

    /**
     * 未中次数
     */
    @ApiModelProperty(value = "未中次数")
    private Integer unTractNum;

    /**
     * 任务id
     */
    @ApiModelProperty(value = "任务id")
    private Integer taskId;

    private static final long serialVersionUID = 1L;
}