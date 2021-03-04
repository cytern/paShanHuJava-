package dam.jsoup.updatereport.updatreport.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="dam-jsoup-updatereport-updatreport-pojo-TaskLock")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskLock implements Serializable {
    @ApiModelProperty(value="")
    private String lockKey;

    @ApiModelProperty(value="")
    private String region;

    @ApiModelProperty(value="")
    private String clientId;

    @ApiModelProperty(value="")
    private Date createdDate;

    private static final long serialVersionUID = 1L;
}