package dam.jsoup.updatereport.updatreport.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="dam-jsoup-updatereport-updatreport-pojo-TaskExecutionParams")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskExecutionParams implements Serializable {
    @ApiModelProperty(value="")
    private Long taskExecutionId;

    @ApiModelProperty(value="")
    private String taskParam;

    private static final long serialVersionUID = 1L;
}