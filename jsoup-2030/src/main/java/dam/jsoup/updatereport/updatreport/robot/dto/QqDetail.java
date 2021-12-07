package dam.jsoup.updatereport.updatreport.robot.dto;

import java.io.Serializable;
import lombok.Data;

/**
 * qq_detail
 * @author 
 */
@Data
public class QqDetail implements Serializable {
    private Integer id;

    private String relQqId;

    private String formName;

    private String fieldValue;

    private static final long serialVersionUID = 1L;
}