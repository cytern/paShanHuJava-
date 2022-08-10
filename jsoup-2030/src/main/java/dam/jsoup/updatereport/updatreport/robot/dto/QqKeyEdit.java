package dam.jsoup.updatereport.updatreport.robot.dto;

import java.io.Serializable;
import lombok.Data;

/**
 * qq_key_edit
 * @author 
 */
@Data
public class QqKeyEdit implements Serializable {
    private Integer id;

    private String qqId;

    /**
     * 编辑文件code
     */
    private String resCode;

    /**
     * 类型 1 字典 2 物品
     */
    private String type;

    /**
     * 文件存储
     */
    private String json;

    private static final long serialVersionUID = 1L;
}