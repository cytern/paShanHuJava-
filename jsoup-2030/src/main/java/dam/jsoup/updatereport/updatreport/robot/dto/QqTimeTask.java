package dam.jsoup.updatereport.updatreport.robot.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * qq_time_task
 * @author 
 */
@Data
public class QqTimeTask implements Serializable {
    private Integer id;

    /**
     * 备注
     */
    private String mark;

    private String createBy;

    private Integer targetType;

    private String targetId;

    private String message;

    private String cron;

    private Date createTime;

    private Integer cycleType;

    private Integer times;

    private static final long serialVersionUID = 1L;
}