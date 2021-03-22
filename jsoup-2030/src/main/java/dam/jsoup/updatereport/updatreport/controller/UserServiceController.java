package dam.jsoup.updatereport.updatreport.controller;

import dam.jsoup.updatereport.updatreport.pojo.JsoupUser;
import dam.jsoup.updatereport.updatreport.service.UserService;
import dam.jsoup.updatereport.updatreport.util.MyResponse;
import dam.jsoup.updatereport.updatreport.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Objects;

@RestController
@Slf4j
public class UserServiceController {
    private final UserService userService;

    public UserServiceController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("everyone/login")
    @ResponseBody
    Map login (@RequestBody UserVo userVo) {

      return userService.login(userVo);
    }

    @PostMapping("everyone/getLoginData")
    @ResponseBody
    UserVo getLoginData(@RequestBody UserVo userVo) {
        return  userService.getLoginData(userVo);
    }

    @PostMapping("everyone/tokenCheck/{token}")
    @ResponseBody
    UserVo tokenCheck(@PathVariable("token") String token) {
        JsoupUser user = new JsoupUser();
        user.setUserToken(token);
        return  userService.tokenCheck(user);
    }
    @PostMapping("everyone/register")
    @ResponseBody
    Map registerOne (@RequestBody  UserVo userVo) {
        Map map = null;
        try {
            map = userService.registerUser(userVo);
        } catch (Exception e) {
            log.error("注册用户失败",e);
            map =  MyResponse.myResponseError("注册失败，系统内部异常");
        }
        return map;
    }

    /**
     * 忘记密码
     * @param userName 用户名
     * @return
     */
    @PostMapping("everyone/forgetPassword/{userName}")
    @ResponseBody
    Map forgetPassword (@PathVariable String userName) {
        log.info("用户 [{}],调用忘记密码接口",userName);
        try {
            Map map = userService.forgetPassword(userName);
            return map;
        } catch (Exception e) {
            log.error("忘记密码服务调用失败",e);
            return MyResponse.myResponseError("系统内部异常");}
    }

    @PostMapping("everyone/resetPassword")
    @ResponseBody
    Map resetUserPassword (@RequestBody JsoupUser user) {
        log.info("用户 [{}],调用重设密码接口",user.getUsername());
        try {
            Map map = userService.resetPassword(user.getUsername(),user.getPassword(),user.getUserToken());
            return map;
        } catch (Exception e) {
            log.error("调用重设密码服务调用失败",e);
            return MyResponse.myResponseError("系统内部异常");}
    }

    @PostMapping("customer/getUserInfo")
    Map getUserInfo () {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        Integer userId = Integer.valueOf(request.getHeader("userId"));
        log.info("用户 [{}],调用获取用户信息接口",userId);
        try {
            Map map = userService.getUserInfo(userId);
            return map;
        } catch (Exception e) {
            log.error("调用获取用户信息接口调用失败",e);
            return MyResponse.myResponseError("系统内部异常");}
    }



}
