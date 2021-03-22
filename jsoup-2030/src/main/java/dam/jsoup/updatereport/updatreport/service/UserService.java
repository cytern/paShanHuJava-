package dam.jsoup.updatereport.updatreport.service;


import dam.jsoup.updatereport.updatreport.pojo.JsoupUser;
import dam.jsoup.updatereport.updatreport.vo.UserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

/**
 * 用户相关信息服务
 */
public interface UserService {

    /**
     * 获取用户信息
     * @param userVo 用户信息
     * @return 用户信息
     */
    UserVo getLoginData(UserVo userVo);

    /**
     * 登录
     * @param userVo 用户信息
     * @return 用户信息
     */
    Map login(UserVo userVo);

    /**
     * 注册
     * @param userVo 用户信息
     * @return 用户信息
     */
    Map registerUser(UserVo userVo);

    /**
     * 重设密码/忘记密码
     * @param userVo 用户信息
     * @return 用户信息
     */
    Map resetPassword(UserVo userVo);

    /**
     * 修改用户信息
     * @param userVo 用户信息
     * @return 用户信息
     */
    Map updateUser(UserVo userVo);



    UserVo tokenCheck(JsoupUser user);

    /**
     * 激活用户
     * @param token  token值
     * @return
     */
    Map awakeUser(String token);

    /**
     * 获取忘记密码验证码
     * @param userName 用户名
     * @return
     */
    Map forgetPassword(String userName);


    /**
     * 重设密码
     * @param userName 用户名
     * @param password 密码
     * @param code 验证码
     * @return
     */
    Map resetPassword(String userName,String password,String code);

    /**
     * 获取用户详细信息
     * @param userId 用户id
     * @return 用户信息
     */
    Map getUserInfo(Integer userId);
}
