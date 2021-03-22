package dam.jsoup.updatereport.updatreport.service.impl;

import dam.jsoup.updatereport.updatreport.service.SendEmail;
import dam.jsoup.updatereport.updatreport.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Map;

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

    /**
     * 发送注册完成的链接
     *
     * @param email
     * @param link
     * @param userVo
     */
    @Override
    public void sendLinkEmail(String email, String link, UserVo userVo) {
        String headerHtml = "<div style=\"background-color:#ECECEC; padding: 35px;\">\n" +
                "    <table cellpadding=\"0\" align=\"center\"\n" +
                "           style=\"width: 600px; margin: 0px auto; text-align: left; position: relative; border-top-left-radius: 5px; border-top-right-radius: 5px; border-bottom-right-radius: 5px; border-bottom-left-radius: 5px; font-size: 14px; font-family:微软雅黑, 黑体; line-height: 1.5; box-shadow: rgb(153, 153, 153) 0px 0px 5px; border-collapse: collapse; background-position: initial initial; background-repeat: initial initial;background:#fff;\">\n" +
                "        <tbody>\n" +
                "        <tr>\n" +
                "            <th valign=\"middle\"\n" +
                "                style=\"height: 25px; line-height: 25px; padding: 15px 35px; border-bottom-width: 1px; border-bottom-style: solid; border-bottom-color: #42a3d3; background-color: #49bcff; border-top-left-radius: 5px; border-top-right-radius: 5px; border-bottom-right-radius: 0px; border-bottom-left-radius: 0px;\">\n" +
                "                <font face=\"微软雅黑\" size=\"5\" style=\"color: rgb(255, 255, 255); \">注册成功,但需要点击下方链接验证激活您的邮箱</font>\n" +
                "            </th>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td>\n" +
                "                <div style=\"padding:25px 35px 40px; background-color:#fff;\">\n" +
                "                    <h2 style=\"margin: 5px 0px; \">\n" +
                "                        <font color=\"#333333\" style=\"line-height: 20px; \">\n" +
                "                            <font style=\"line-height: 22px; \" size=\"4\">\n" +
                "                                亲爱的 爬山虎平台用户</font>\n" +
                "                        </font>\n" +
                "                    </h2>\n" +
                "                    <p>首先感谢您加入本站！下面是您的账号信息<br>  " +
                " 您的账号：<b>"+userVo.getJsoupUser().getUsername()+"</b>\n" +
                "                        <br>\n" +
                "                        您的邮箱：<b>"+userVo.getJsoupUserDetail().getUserEmail()+"</b><br>\n" +
                "                        您注册时的日期：<b>"+userVo.getJsoupUser().getCreateTime()+"</b>\n" +
                "                       <br>\n" +
                "                        当您在使用本网站时，遵守当地法律法规。<br>\n" +
                "                        如果您有什么疑问可以联系管理员，Email: cytern@foxmail.com</p>\n" +
                "                    <p align=\"right\">爬山虎平台</p>\n" +
                "                    <p align=\"right\"><a href=\""+link+userVo.getJsoupUser().getUserToken()+"\">激活账号点击此链接</a></p>\n" +
                "                    <div style=\"width:700px;margin:0 auto;\">\n" +
                "                        <div style=\"padding:10px 10px 0;border-top:1px solid #ccc;color:#747474;margin-bottom:20px;line-height:1.3em;font-size:12px;\">\n" +
                "                            <p>此为系统邮件，请勿回复<br>\n" +
                "                                请保管好您的邮箱，避免账号被他人盗用\n" +
                "                            </p>\n" +
                "                            <p>©cytern</p>\n" +
                "                        </div>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "        </tbody>\n" +
                "    </table>\n" +
                "</div>\n";
              sendHtmlEmail(email,headerHtml,"激活账号提醒");
    }

    /**
     * 发送验证码于邮箱中
     *
     * @param email 邮箱
     * @param code  验证码
     */
    @Override
    public void sendCodeEmail(String email, String code) {
        String headerHtml = "<div style=\"background-color:#ECECEC; padding: 35px;\">\n" +
                "    <table cellpadding=\"0\" align=\"center\"\n" +
                "           style=\"width: 600px; margin: 0px auto; text-align: left; position: relative; border-top-left-radius: 5px; border-top-right-radius: 5px; border-bottom-right-radius: 5px; border-bottom-left-radius: 5px; font-size: 14px; font-family:微软雅黑, 黑体; line-height: 1.5; box-shadow: rgb(153, 153, 153) 0px 0px 5px; border-collapse: collapse; background-position: initial initial; background-repeat: initial initial;background:#fff;\">\n" +
                "        <tbody>\n" +
                "        <tr>\n" +
                "            <th valign=\"middle\"\n" +
                "                style=\"height: 25px; line-height: 25px; padding: 15px 35px; border-bottom-width: 1px; border-bottom-style: solid; border-bottom-color: #42a3d3; background-color: #49bcff; border-top-left-radius: 5px; border-top-right-radius: 5px; border-bottom-right-radius: 0px; border-bottom-left-radius: 0px;\">\n" +
                "                <font face=\"微软雅黑\" size=\"5\" style=\"color: rgb(255, 255, 255); \">重置密码，验证码</font>\n" +
                "            </th>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td>\n" +
                "                <div style=\"padding:25px 35px 40px; background-color:#fff;\">\n" +
                "                    <h2 style=\"margin: 5px 0px; \">\n" +
                "                        <font color=\"#333333\" style=\"line-height: 20px; \">\n" +
                "                            <font style=\"line-height: 22px; \" size=\"4\">\n" +
                "                                亲爱的 爬山虎平台用户</font>\n" +
                "                        </font>\n" +
                "                    </h2>\n" +
                "                    <p>以下为您更新密码的验证码<br>  " +
                " 验证码：<b>"+code+"</b>\n" +
                "                        <br>\n" +
                "                        当您在使用本网站时，遵守当地法律法规。<br>\n" +
                "                        如果您有什么疑问可以联系管理员，Email: cytern@foxmail.com</p>\n" +
                "                    <p align=\"right\">爬山虎平台</p>\n" +
                "                    <div style=\"width:700px;margin:0 auto;\">\n" +
                "                        <div style=\"padding:10px 10px 0;border-top:1px solid #ccc;color:#747474;margin-bottom:20px;line-height:1.3em;font-size:12px;\">\n" +
                "                            <p>此为系统邮件，请勿回复<br>\n" +
                "                                请保管好您的邮箱，避免账号被他人盗用\n" +
                "                            </p>\n" +
                "                            <p>©cytern</p>\n" +
                "                        </div>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "        </tbody>\n" +
                "    </table>\n" +
                "</div>\n";
        sendHtmlEmail(email,headerHtml,"重置密码提醒");
    }

    @Override
    public void sendResEmail(String email, String codeMsg, String maName, String failReason) {
        String headerHtml = "<div style=\"background-color:#ECECEC; padding: 35px;\">\n" +
                "    <table cellpadding=\"0\" align=\"center\"\n" +
                "           style=\"width: 600px; margin: 0px auto; text-align: left; position: relative; border-top-left-radius: 5px; border-top-right-radius: 5px; border-bottom-right-radius: 5px; border-bottom-left-radius: 5px; font-size: 14px; font-family:微软雅黑, 黑体; line-height: 1.5; box-shadow: rgb(153, 153, 153) 0px 0px 5px; border-collapse: collapse; background-position: initial initial; background-repeat: initial initial;background:#fff;\">\n" +
                "        <tbody>\n" +
                "        <tr>\n" +
                "            <th valign=\"middle\"\n" +
                "                style=\"height: 25px; line-height: 25px; padding: 15px 35px; border-bottom-width: 1px; border-bottom-style: solid; border-bottom-color: #42a3d3; background-color: #49bcff; border-top-left-radius: 5px; border-top-right-radius: 5px; border-bottom-right-radius: 0px; border-bottom-left-radius: 0px;\">\n" +
                "                <font face=\"微软雅黑\" size=\"5\" style=\"color: rgb(255, 255, 255); \">任务执行完毕提醒</font>\n" +
                "            </th>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td>\n" +
                "                <div style=\"padding:25px 35px 40px; background-color:#fff;\">\n" +
                "                    <h2 style=\"margin: 5px 0px; \">\n" +
                "                        <font color=\"#333333\" style=\"line-height: 20px; \">\n" +
                "                            <font style=\"line-height: 22px; \" size=\"4\">\n" +
                "                                亲爱的 爬山虎平台用户</font>\n" +
                "                        </font>\n" +
                "                    </h2>\n" +
                "                    <p>您的任务执行完成了<br>  " ;

          String endHtml =      "                        <br>\n" +
                "                        当您在使用本网站时，遵守当地法律法规。<br>\n" +
                "                        如果您有什么疑问可以联系管理员，Email: cytern@foxmail.com</p>\n" +
                "                    <p align=\"right\">爬山虎平台</p>\n" +
                "                    <div style=\"width:700px;margin:0 auto;\">\n" +
                "                        <div style=\"padding:10px 10px 0;border-top:1px solid #ccc;color:#747474;margin-bottom:20px;line-height:1.3em;font-size:12px;\">\n" +
                "                            <p>此为系统邮件，请勿回复<br>\n" +
                "                                请保管好您的邮箱，避免账号被他人盗用\n" +
                "                            </p>\n" +
                "                            <p>©cytern</p>\n" +
                "                        </div>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "        </tbody>\n" +
                "    </table>\n" +
                "</div>\n";

        StringBuilder sb = new StringBuilder();

        String line;
        String line2 = " 执行任务名称：<b>" + maName + "</b><br>\n";
        sb.append(line2);
        if (codeMsg.equals("success")){
            line = " 执行结果：<b>" + "执行成功！" + "</b><br>\n";
        }else {
            line = " 执行结果：<b>" + "执行失败！" + "</b><br>\n"
                    + "失败原因：<b>" + failReason + "</b><br>\n";

        }
        sb.append(line);
        String nowString = headerHtml + sb.toString() + endHtml;
        sendHtmlEmail(email,nowString,"任务执行完毕");
    }


}
