package dam.jsoup.updatereport.updatreport;

import dam.jsoup.updatereport.updatreport.service.SendExcutorServcie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
public class HttpExcutorTest {
    @Autowired
    private SendExcutorServcie sendExcutorServcie;

    @Test
    void go() {
        Map map = sendExcutorServcie.sendGoExcutor(4, 1);
        System.out.println(map);
    }
}
