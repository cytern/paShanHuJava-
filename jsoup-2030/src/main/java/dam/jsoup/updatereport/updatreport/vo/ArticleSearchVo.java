package dam.jsoup.updatereport.updatreport.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author : dam
 * @description :
 * @create :2021-04-29 14:46:00
 */
@ToString(callSuper=true)
@EqualsAndHashCode(callSuper = true)
@Data
public class ArticleSearchVo extends PageVoHelper{
    private Integer userId;
    private String title;
}
