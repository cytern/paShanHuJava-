package dam.jsoup.updatereport.updatreport;

import dam.jsoup.updatereport.updatreport.dao.JsoupMissionMapper;
import dam.jsoup.updatereport.updatreport.excutor.QqSenderTaskService;
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
public class TestTask {
    @Autowired
    private QqSenderTaskService qqSenderTaskService;


    @Test
    public void go() {
        qqSenderTaskService.checkExcutor();

    }

}
