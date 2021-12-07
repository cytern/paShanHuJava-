package dam.jsoup.updatereport.updatreport.robot.controller;

import dam.jsoup.updatereport.updatreport.robot.command.CommandReceiverFactory;
import dam.jsoup.updatereport.updatreport.robot.pojo.MessageData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("robot")
@Slf4j
public class AutoReceiverController {
private final CommandReceiverFactory commandReceiverFactory;


    public AutoReceiverController(CommandReceiverFactory commandReceiverFactory) {
        this.commandReceiverFactory = commandReceiverFactory;
    }

    @RequestMapping("command")
    public String receiverCommandService(MessageData messageData){
        return null;
    }

    public String receiverTimerService() {
        return null;
    }
}
