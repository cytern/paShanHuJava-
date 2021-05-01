package dam.jsoup.updatereport.updatreport.vo;

import lombok.Data;

/**
 * 获取页面
 */
@Data
public class PageSizeVo {
    private int index;
    private int pre;
    private int last;
    private int pageSize;


    public PageSizeVo(int index, int pageSize) {
        this.index = index;
        this.pageSize = pageSize;
        this.last = index*pageSize;
        this.pre = (index -1)*pageSize;
    }
}
