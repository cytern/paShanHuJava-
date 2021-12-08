package dam.jsoup.updatereport.updatreport.robot.controller;

import dam.jsoup.updatereport.updatreport.robot.command.CommandReceiver;
import dam.jsoup.updatereport.updatreport.robot.command.CommandReceiverFactory;
import dam.jsoup.updatereport.updatreport.robot.pojo.MessageData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
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
        CommandReceiver commandReceiver = commandReceiverFactory.searchService(getCommand(messageData.getMessage()));
        String andSendBack = commandReceiver.getAndSendBack(messageData);
        log.info("来源数据 {} ,返回数据 {}",messageData,andSendBack);
        return andSendBack;
    }

    @RequestMapping("chat")
    public String receiveChatService() {
        return null;
    }

    public String getCommand(String message) {
        String[] params = message.split(" ");
        return params[0];
    }
}
