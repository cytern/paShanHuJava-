package dam.jsoup.updatereport.updatreport.vo;

import dam.jsoup.updatereport.updatreport.pojo.JsoupPragram;
import lombok.Data;

import java.util.List;

/**
 * @author : dam
 * @description :
 * @create :2021-05-06 14:59:00
 */
@Data
public class TimeTaskRequest {
    private List<JsoupPragram> pragrams;
    private TimeTaskVo timeTaskVo;
}
