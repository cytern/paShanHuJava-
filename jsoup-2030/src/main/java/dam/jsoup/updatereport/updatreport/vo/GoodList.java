package dam.jsoup.updatereport.updatreport.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author : dam
 * @description :商品列表
 * @create :2021-04-27 14:50:00
 */
@Data
public class GoodList {
    /**
     * 名
     */
    private String goodName;
    /**
     * 用途
     */
    private String des;
    /**
     * 类型 1脚本 2数据
     */
    private Integer type;
    /**
     * 评分
     */
    private Integer rate;
    /**
     * 创造用户名
     */
    private String createUser;
    /**
     * 卖出数量
     */
    private String saleNum;
    /**
     * 上架日期
     */
    private Date sendTime;
    /**
     * 标签
     */
    private String tips;
    /**
     * 持有者id
     */
    private Integer ownerId;
    /**
     * 商品主键
     */
    private Integer id;
    /**
     * 是否拥有
     */
    private Integer have;
    /**
     * 价格
     */
    private BigDecimal price;

}
