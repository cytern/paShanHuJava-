package dam.jsoup.updatereport.updatreport.robot.dto;

import java.io.Serializable;
import lombok.Data;

/**
 * qq_group
 * @author 
 */
@Data
public class QqGroup implements Serializable {
    private Integer id;

    private String groupId;

    private String groupName;

    private Integer groupLevel;

    private String groupRole;

    private static final long serialVersionUID = 1L;
}