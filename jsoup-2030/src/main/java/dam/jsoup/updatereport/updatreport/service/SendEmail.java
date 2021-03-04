package dam.jsoup.updatereport.updatreport.service;

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
}
