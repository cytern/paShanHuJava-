package dam.jsoup.updatereport.updatreport.robot.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * qq_age_list
 * @author 
 */
@Data
public class QqAgeList implements Serializable {
    private Integer id;

    private String qqId;

    private String groupId;

    private String type;

    private Integer rank;

    private Integer elo;

    private Integer matchTimes;

    private String winRate;

    private Date createTime;

    private Integer defult;

    private String ageName;

    private static final long serialVersionUID = 1L;
}