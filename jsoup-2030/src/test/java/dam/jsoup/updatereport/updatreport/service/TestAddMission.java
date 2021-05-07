package dam.jsoup.updatereport.updatreport.service;

import dam.jsoup.updatereport.updatreport.dao.JsoupMissionAllHistoryMapper;
import dam.jsoup.updatereport.updatreport.pojo.JsoupMissionAllHistory;
import dam.jsoup.updatereport.updatreport.pojo.JsoupMissionAllHistoryExample;
import dam.jsoup.updatereport.updatreport.service.order.JsoupMissionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author : dam
 * @description :
 * @create :2021-05-07 11:53:00
 */
@SpringBootTest
public class TestAddMission {
    @Autowired
    private JsoupMissionService jsoupMissionService;
    @Autowired
    private JsoupMissionAllHistoryMapper allHistoryMapper;
    @Test
    public void run() {
        JsoupMissionAllHistoryExample example = new JsoupMissionAllHistoryExample();
        example.createCriteria().andMissionStateEqualTo("5");
        List<JsoupMissionAllHistory> jsoupMissionAllHistories = allHistoryMapper.selectByExample(example);
        example.clear();
        example.createCriteria().andMissionStateEqualTo("1");
        List<JsoupMissionAllHistory> jsoupMissionAllHistories1 = allHistoryMapper.selectByExample(example);
        jsoupMissionAllHistories.addAll(jsoupMissionAllHistories1);
        for (JsoupMissionAllHistory jsoupMissionAllHistory : jsoupMissionAllHistories) {
            try {
                jsoupMissionService.addRunningParameter(jsoupMissionAllHistory.getMissionAllHistoryId());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
    @Test
    public void run2() {
        JsoupMissionAllHistory jsoupMissionAllHistory = allHistoryMapper.selectByPrimaryKey(4644);
        System.out.println(jsoupMissionAllHistory);
    }
}
