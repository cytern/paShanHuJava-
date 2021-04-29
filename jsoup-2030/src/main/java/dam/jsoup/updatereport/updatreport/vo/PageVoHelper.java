package dam.jsoup.updatereport.updatreport.vo;

import lombok.Data;

/**
 * @author : dam
 * @description :分页辅助
 * @create :2021-04-29 14:48:00
 */
@Data
public class PageVoHelper {
    private Integer pageStart;
    private Integer pageEnd;
    public void resPageData(Integer pageSize,Integer index) {
        pageStart = (index-1)*pageSize;
        pageEnd = index*pageSize;
    }
}
