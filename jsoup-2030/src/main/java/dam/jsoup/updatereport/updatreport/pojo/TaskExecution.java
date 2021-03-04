package dam.jsoup.updatereport.updatreport.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="dam-jsoup-updatereport-updatreport-pojo-TaskExecution")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskExecution implements Serializable {
    @ApiModelProperty(value="")
    private Long taskExecutionId;

    @ApiModelProperty(value="")
    private Date startTime;

    @ApiModelProperty(value="")
    private Date endTime;

    @ApiModelProperty(value="")
    private String taskName;

    @ApiModelProperty(value="")
    private Integer exitCode;

    @ApiModelProperty(value="")
    private String exitMessage;

    @ApiModelProperty(value="")
    private String errorMessage;

    @ApiModelProperty(value="")
    private Date lastUpdated;

    @ApiModelProperty(value="")
    private String externalExecutionId;

    @ApiModelProperty(value="")
    private Long parentExecutionId;

    private static final long serialVersionUID = 1L;
}