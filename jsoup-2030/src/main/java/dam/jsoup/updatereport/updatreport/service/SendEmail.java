package dam.jsoup.updatereport.updatreport.service;

import dam.jsoup.updatereport.updatreport.vo.UserVo;

/**
 * @author dam
 * @version 1.0
 * @date 2020/12/22 18:29
 */
public interface SendEmail {
    /**
     *
     * @param email string email地址
     * @param msg  email 内容
     * @param title 标题
     */
    void sendEmail(String email,String msg,String title);

    /**
     *
     * @param email email地址
     * @param msg 内容
     * @param title 标题
     */
    void sendHtmlEmail(String email,String msg,String title);

    /**
     * 发送注册完成的链接
     * @param email
     * @param link
     * @param userVo
     */
    void sendLinkEmail(String email, String link, UserVo userVo);

    /**
     * 发送验证码于邮箱中
     * @param email 邮箱
     * @param code 验证码
     */
    void sendCodeEmail(String email, String code);
}
