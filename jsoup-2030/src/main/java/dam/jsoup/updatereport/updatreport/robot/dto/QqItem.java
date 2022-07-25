package dam.jsoup.updatereport.updatreport.robot.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * qq_item
 * @author 
 */
@Data
public class QqItem implements Serializable {
    private Integer id;

    /**
     * 物品名称
     */
    private String itemName;

    /**
     * 物品类型
     */
    private String itemType;

    /**
     * 物品图片信息
     */
    private String itemImgName;

    /**
     * 物品描述
     */
    private String itemDes;

    /**
     * 物品属性
     */
    private String itemPop;

    private String delFlag;

    private Date updateTime;

    /**
     * 机器人标识
     */
    private String rotCode;

    private static final long serialVersionUID = 1L;
}