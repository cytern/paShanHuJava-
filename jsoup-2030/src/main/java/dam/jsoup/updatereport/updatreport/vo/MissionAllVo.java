package dam.jsoup.updatereport.updatreport.vo;

import dam.jsoup.updatereport.updatreport.pojo.JsoupMissionAll;
import lombok.Data;

import java.util.List;

/**
 * 总任务对象
 */
@Data
public class MissionAllVo {
    private JsoupMissionAll jsoupMissionAll;
    //标签列表
    private List<String> tips;
}
