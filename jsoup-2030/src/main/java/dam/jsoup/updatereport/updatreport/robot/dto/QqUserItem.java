package dam.jsoup.updatereport.updatreport.robot.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * qq_user_item
 * @author 
 */
@Data
public class QqUserItem implements Serializable {
    private Integer id;

    private String qqId;

    /**
     * 物品名称
     */
    private String itemName;

    /**
     * 物品数量
     */
    private Integer num;

    private Integer delFlag;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 机器人唯一标识
     */
    private String rotCode;

    private static final long serialVersionUID = 1L;
}