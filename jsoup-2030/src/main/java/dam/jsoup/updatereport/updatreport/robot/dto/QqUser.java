package dam.jsoup.updatereport.updatreport.robot.dto;

import java.io.Serializable;
import lombok.Data;

/**
 * qq_user
 * @author 
 */
@Data
public class QqUser implements Serializable {
    private Integer id;

    private Long qqId;

    private String qqMark;

    private String qqName;

    private Integer level;

    private String honor;

    private Integer point;

    private static final long serialVersionUID = 1L;
}