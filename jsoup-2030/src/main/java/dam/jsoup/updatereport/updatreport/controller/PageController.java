package dam.jsoup.updatereport.updatreport.controller;

import dam.jsoup.updatereport.updatreport.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

/**
 * 页面服务分发控制器
 */
@Slf4j
@Controller
public class PageController {
    private final UserService userService;

    public PageController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("everyone/wakeUser/{token}")
    String awakeUser(@PathVariable String token){
        Map map = userService.awakeUser(token);
        if (map.get("code").equals("success")){
            return "success";
        }else {
            return "error";
        }
    }
}
