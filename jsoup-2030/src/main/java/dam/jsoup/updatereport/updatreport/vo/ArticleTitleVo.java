package dam.jsoup.updatereport.updatreport.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author : dam
 * @description :
 * @create :2021-04-29 14:53:00
 */
@Data
public class ArticleTitleVo {
    private String title;
    private String userId;
    private String userName;
    private String id;
    private Date updateTime;
}
