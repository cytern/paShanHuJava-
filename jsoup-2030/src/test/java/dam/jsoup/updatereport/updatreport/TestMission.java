package dam.jsoup.updatereport.updatreport;

import dam.jsoup.updatereport.updatreport.dao.JsoupMissionMapper;
import dam.jsoup.updatereport.updatreport.pojo.JsoupMission;
import dam.jsoup.updatereport.updatreport.pojo.JsoupMissionExample;
import dam.jsoup.updatereport.updatreport.service.ExecutorMission;
import dam.jsoup.updatereport.updatreport.service.ExecutorMissionAll;
import dam.jsoup.updatereport.updatreport.service.SendEmail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class TestMission {
    @Autowired
    private  JsoupMissionMapper jsoupMissionMapper;
    @Autowired
    private  ExecutorMission excuteMission;
    @Autowired
    private  SendEmail sendEmail;
    @Autowired
    private ExecutorMissionAll executorMissionAll;



    @Test
   public void go(){

       JsoupMissionExample jsoupMissionExample = new JsoupMissionExample();

       List<JsoupMission> missions = jsoupMissionMapper.selectByExample(jsoupMissionExample);
       for (JsoupMission mission : missions) {
           Map<String,String> map= excuteMission.startMission(mission.getMissionId());
           sendEmail.sendEmail(mission.getNoticeEmail(),map.get("msg"),map.get("title"));
       }
   }

@Test
   public void goAll() {
     Map map =  executorMissionAll.startMissionAll(3);
       System.out.println(map);
   }
}
