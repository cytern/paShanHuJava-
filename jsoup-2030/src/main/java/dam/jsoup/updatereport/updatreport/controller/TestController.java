package dam.jsoup.updatereport.updatreport.controller;

import dam.jsoup.updatereport.updatreport.dao.JsoupMissionMapper;
import dam.jsoup.updatereport.updatreport.pojo.JsoupMission;
import dam.jsoup.updatereport.updatreport.pojo.JsoupMissionExample;
import dam.jsoup.updatereport.updatreport.service.ExecutorMission;
import dam.jsoup.updatereport.updatreport.service.SendEmail;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class TestController {
    private final JsoupMissionMapper jsoupMissionMapper;
    private final ExecutorMission excuteMission;
    private final SendEmail sendEmail;

    public TestController(JsoupMissionMapper jsoupMissionMapper, ExecutorMission excuteMission, SendEmail sendEmail) {
        this.jsoupMissionMapper = jsoupMissionMapper;
        this.excuteMission = excuteMission;
        this.sendEmail = sendEmail;
    }


    @GetMapping("test/test")
    public String sendExcutor () {
        return "ok";
    }

}
