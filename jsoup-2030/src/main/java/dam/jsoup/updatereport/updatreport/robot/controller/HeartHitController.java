package dam.jsoup.updatereport.updatreport.robot.controller;

import dam.jsoup.updatereport.updatreport.robot.pojo.CommandData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("robot")
public class HeartHitController {

    /**
     * 心跳包维持
     */
    @RequestMapping("heartHit")
    public CommandData heartHitController(CommandData commandData) {
        //注册并且更新心跳状态
        return null;
    }


}
