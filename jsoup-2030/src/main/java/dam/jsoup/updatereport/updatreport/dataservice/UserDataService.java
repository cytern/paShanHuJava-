package dam.jsoup.updatereport.updatreport.dataservice;


import dam.jsoup.updatereport.updatreport.pojo.JsoupUser;
import dam.jsoup.updatereport.updatreport.vo.UserVo;

import java.util.Map;

/**
 * dao层数据 用户服务
 */
public interface UserDataService {
    /**
     * 登录验证
     * @param userName 用户名
     * @param password 密码
     * @return 是否正确
     */
    Map login(String userName, String password);

    /**
     * 发送邮件
     * @param userName 用户名
     * @return 是否成功
     */
    Boolean sendEmail(String userName);



}
