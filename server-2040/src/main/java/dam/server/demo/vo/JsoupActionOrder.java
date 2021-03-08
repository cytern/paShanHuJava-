package dam.server.demo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsoupActionOrder implements Serializable {
    @ApiModelProperty(value="")
    private Integer actionOrderId;

    @ApiModelProperty(value="")
    private Integer actionId;

    @ApiModelProperty(value="")
    private Integer missionId;

    @ApiModelProperty(value="")
    private Integer missionAllId;

    @ApiModelProperty(value="")
    private Integer rank;

    private static final long serialVersionUID = 1L;
}

