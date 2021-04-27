package dam.jsoup.updatereport.updatreport.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author : dam
 * @description :条件查询
 * @create :2021-04-27 15:00:00
 */
@Data
public class SearchGoodsVo {
    /**
     * 标签
     */
    private String tip;
    /**
     * name
     */
    private String name;
    /**
     * 下时间
     */
    private Date leftDate;
    /**
     * 上时间
     */
    private Date rightDate;
    /**
     * id
     */
    private Integer id;
    /**
     * 制作者名
     */
    private Integer userId;
    /**
     * 下载量排行 1开启
     */
    private Integer sortByDownload;
    /**
     * 评分排行 1开启
     */
    private Integer sortByRate;
    /**
     * 起始页
     */
    private Integer pageStart;
    /**
     * 结束页
     */
    private Integer pageEnd;

    /**
     * 当前用户id
     */
    private Integer currentUser;


    public void resPageData(Integer pageSize,Integer index) {
        pageStart = (index-1)*pageSize;
        pageEnd = index*pageSize;
    }

}
