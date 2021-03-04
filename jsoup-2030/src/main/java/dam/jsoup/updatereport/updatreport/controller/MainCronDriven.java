package dam.jsoup.updatereport.updatreport.controller;

import dam.jsoup.updatereport.updatreport.dao.JsoupMissionMapper;
import dam.jsoup.updatereport.updatreport.pojo.JsoupMission;
import dam.jsoup.updatereport.updatreport.pojo.JsoupMissionExample;
import dam.jsoup.updatereport.updatreport.service.ExecutorMission;
import dam.jsoup.updatereport.updatreport.service.SendEmail;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;
import java.util.Map;

@Configuration
@EnableScheduling
public class MainCronDriven {

   private final JsoupMissionMapper jsoupMissionMapper;
   private final ExecutorMission excuteMission;
   private final SendEmail sendEmail;
    public MainCronDriven(JsoupMissionMapper jsoupMissionMapper, ExecutorMission excuteMission, SendEmail sendEmail) {
        this.jsoupMissionMapper = jsoupMissionMapper;
        this.excuteMission = excuteMission;
        this.sendEmail = sendEmail;
    }

    @Scheduled(cron = "0 0 2 1/1 * ? ")
     void fistDo(){
        sendExecutor();
    }

     @Scheduled(cron = "0 0 6 1/1 * ? ")
    void secondDo (){
         sendExecutor();
     }

    private void sendExecutor() {
        JsoupMissionExample jsoupMissionExample = new JsoupMissionExample();
        List<JsoupMission> missions = jsoupMissionMapper.selectByExample(jsoupMissionExample);
        for (JsoupMission mission : missions) {
            Map<String,String> map= excuteMission.startMission(mission.getMissionId());
            sendEmail.sendEmail(mission.getNoticeEmail(),map.get("msg"),map.get("title"));
        }
    }
}
