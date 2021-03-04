package com.kente.demo.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@ApiModel(value = "com-kente-demo-pojo-Approve")
@Data
public class Approve implements Serializable {
    @ApiModelProperty(value = "")
    private Integer id;

    @ApiModelProperty(value = "")
    private Integer kenteId;

    @ApiModelProperty(value = "")
    private String approveOne;

    @ApiModelProperty(value = "")
    private String approveTwo;

    @ApiModelProperty(value = "")
    private String approveThree;

    @ApiModelProperty(value = "")
    private String approveFour;

    @ApiModelProperty(value = "")
    private String approveFive;

    @ApiModelProperty(value = "")
    private String approveSix;

    private static final long serialVersionUID = 1L;
}