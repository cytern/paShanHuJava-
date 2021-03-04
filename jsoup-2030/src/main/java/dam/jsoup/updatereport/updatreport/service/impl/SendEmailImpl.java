package dam.jsoup.updatereport.updatreport.service.impl;

import dam.jsoup.updatereport.updatreport.service.SendEmail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @author dam
 * @version 1.0
 * @date 2020/12/22 18:32
 */
@Slf4j
@Service
public class SendEmailImpl implements SendEmail {
    private final JavaMailSender javaMailSender;

    public SendEmailImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendEmail(String email, String msg,String title) {
        log.info("简单邮件发送器开始发送邮件   入参: email=[{}],msg=[{}],title=[{}]"+ email + msg + title);
        //创建SimpleMailMessage对象
        SimpleMailMessage message = new SimpleMailMessage();
        //邮件发送人
        message.setFrom("cytern@qq.com");
        //邮件接收人
        message.setTo(email);
        //邮件主题
        message.setSubject(title);
        //邮件内容
        message.setText(msg);
        //发送邮件
        javaMailSender.send(message);
    }

    @Override
    public void sendHtmlEmail(String email, String msg, String title) {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper;
        log.info("html邮件发送器开始发送邮件   入参: email=[{}],msg=[{}],title=[{}]"+ email + msg + title);
        try {
            messageHelper = new MimeMessageHelper(message, true);
            //邮件发送人
            messageHelper.setFrom("cytern@qq.com");
            //邮件接收人
            messageHelper.setTo(email);
            //邮件主题
            message.setSubject(title);
            //邮件内容，html格式
            messageHelper.setText(msg, true);
            //发送
            javaMailSender.send(message);
            //日志信息

        } catch (MessagingException e) {
            log.error("html邮件发送器发送邮件失败   入参: email=[{}],msg=[{}],title=[{}]"+ email + msg + title + e);
        }
    }
}
