package dam.jsoup.updatereport.updatreport.controller;

import dam.jsoup.updatereport.updatreport.dao.JsoupMissionMapper;
import dam.jsoup.updatereport.updatreport.pojo.JsoupMission;
import dam.jsoup.updatereport.updatreport.pojo.JsoupMissionExample;
import dam.jsoup.updatereport.updatreport.service.ExecutorMission;
import dam.jsoup.updatereport.updatreport.service.SendEmail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class TestController {
    private final JsoupMissionMapper jsoupMissionMapper;
    private final ExecutorMission excuteMission;
    private final SendEmail sendEmail;

    public TestController(JsoupMissionMapper jsoupMissionMapper, ExecutorMission excuteMission, SendEmail sendEmail) {
        this.jsoupMissionMapper = jsoupMissionMapper;
        this.excuteMission = excuteMission;
        this.sendEmail = sendEmail;
    }


    @GetMapping("everyone/test")
    public String sendExcutor () {
        return "ok";
    }


    @GetMapping("everyone/sayTrans")
    public String sayTrans() {
        try {
            fuckException();
        } catch (Exception e) {
            log.info("补货到异常");
        }
        log.info("");
        nonono();
        return "fuck";
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public void fuckException() {
        log.info("正常打印 正常");
        throw new RuntimeException("fuck");
    }

    private void nonono() {
        fuckException();
    }

}
