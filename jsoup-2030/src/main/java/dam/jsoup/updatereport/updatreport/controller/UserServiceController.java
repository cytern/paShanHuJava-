package dam.jsoup.updatereport.updatreport.controller;

import dam.jsoup.updatereport.updatreport.pojo.JsoupUser;
import dam.jsoup.updatereport.updatreport.service.UserService;
import dam.jsoup.updatereport.updatreport.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
       return userService.registerUser(userVo);
    }
}
