package dam.jsoup.updatereport.updatreport.vo;

import dam.jsoup.updatereport.updatreport.pojo.JsoupArticle;
import dam.jsoup.updatereport.updatreport.pojo.JsoupUserDetail;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author : dam
 * @description :文章详情
 * @create :2021-04-29 15:14:00
 */

@Data
public class ArticleVo  {
    private JsoupArticle jsoupArticle;
    private JsoupUserDetail userDetail;
}
