package dam.jsoup.updatereport.updatreport.vo;

import dam.jsoup.updatereport.updatreport.pojo.JsoupMissionAllHistory;
import lombok.Data;

import java.util.List;

@Data
public class HistoryAllVo {
    private JsoupMissionAllHistory jsoupMissionAllHistory;
    //标签列表
    private List<String> tips;
}
