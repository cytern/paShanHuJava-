package dam.jsoup.updatereport.updatreport.robot.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * qq_rot
 * @author 
 */
@Data
public class QqRot implements Serializable {
    private Integer id;

    private String cpuId;

    private String qqId;

    private Date lastLiveTime;

    private Date createTime;

    private Integer delFlag;

    private static final long serialVersionUID = 1L;
}