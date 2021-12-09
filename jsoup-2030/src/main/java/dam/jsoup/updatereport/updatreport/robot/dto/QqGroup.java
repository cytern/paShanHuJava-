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

    private Integer groupId;

    private String groupName;

    private static final long serialVersionUID = 1L;
}