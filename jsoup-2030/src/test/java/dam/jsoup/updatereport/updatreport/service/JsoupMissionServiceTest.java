package dam.jsoup.updatereport.updatreport.service;

import dam.jsoup.updatereport.updatreport.service.order.JsoupMissionService;
import dam.jsoup.updatereport.updatreport.vo.MissionAllData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JsoupMissionServiceTest {
   @Autowired
   private JsoupMissionService jsoupMissionService;
    @Test
    void getMissionAllData() {
        MissionAllData data = jsoupMissionService.getMissionAllData(1,1);
        System.out.println(data);
    }
}