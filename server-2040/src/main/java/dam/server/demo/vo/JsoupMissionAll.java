package dam.server.demo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


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
     * 用户id 与用户表关联
     */
    @ApiModelProperty(value = "用户id 与用户表关联")
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

    private static final long serialVersionUID = 1L;
}

