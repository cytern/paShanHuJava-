package dam.jsoup.updatereport.updatreport.service.impl;

import dam.jsoup.updatereport.updatreport.service.SendEmail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SendEmailImplTest {
    @Autowired
private SendEmail sendEmail;
    @Test
    void sendEmail() {
        sendEmail.sendEmail("18325930067@163.com","测试文件","测试右键");
    }
}