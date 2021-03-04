package com.kente.demo.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "com-kente-demo-pojo-Kentecom")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Kentecom implements Serializable {
    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    private Integer id;

    /**
     * 月份
     */
    @ApiModelProperty(value = "月份")
    private String mouth;

    /**
     * 日期
     */
    @ApiModelProperty(value = "日期")
    private String date;

    /**
     * 商务制作人
     */
    @ApiModelProperty(value = "商务制作人")
    private String businessCreater;

    /**
     * 技术制作人
     */
    @ApiModelProperty(value = "技术制作人")
    private String techCreater;

    /**
     * 行业分类
     */
    @ApiModelProperty(value = "行业分类")
    private String industry;

    /**
     * 级别
     */
    @ApiModelProperty(value = "级别")
    private String lv;

    /**
     * 项目类别
     */
    @ApiModelProperty(value = "项目类别")
    private String type;

    /**
     * 产品名称
     */
    @ApiModelProperty(value = "产品名称")
    private String proName;

    /**
     * 项目名称
     */
    @ApiModelProperty(value = "项目名称")
    private String name;

    /**
     * 招标单位
     */
    @ApiModelProperty(value = "招标单位")
    private String customer;

    /**
     * 数量
     */
    @ApiModelProperty(value = "数量")
    private String needNum;

    /**
     * 招标金额
     */
    @ApiModelProperty(value = "招标金额")
    private String needPrice;

    /**
     * 投标结果
     */
    @ApiModelProperty(value = "投标结果")
    private String afterResult;

    /**
     * 中标金额
     */
    @ApiModelProperty(value = "中标金额")
    private String afterPrice;

    /**
     * 未中原因
     */
    @ApiModelProperty(value = "未中原因")
    private String afterReason;

    /**
     * 中标单位
     */
    @ApiModelProperty(value = "中标单位")
    private String afterCompany;

    /**
     * 金额
     */
    @ApiModelProperty(value = "金额")
    private String price;

    /**
     * 未中标原因分析
     */
    @ApiModelProperty(value = "未中标原因分析")
    private String canNotReason;

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
     * 任务id
     */
    @ApiModelProperty(value = "任务id")
    private Integer taskId;

    private static final long serialVersionUID = 1L;
}