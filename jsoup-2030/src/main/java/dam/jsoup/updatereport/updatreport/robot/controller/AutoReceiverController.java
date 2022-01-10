package dam.jsoup.updatereport.updatreport.robot.controller;

import com.alibaba.fastjson.JSONObject;
import dam.jsoup.updatereport.updatreport.robot.command.CommandReceiver;
import dam.jsoup.updatereport.updatreport.robot.command.CommandReceiverFactory;
import dam.jsoup.updatereport.updatreport.robot.pojo.CommandData;
import dam.jsoup.updatereport.updatreport.robot.pojo.Constant;
import dam.jsoup.updatereport.updatreport.robot.pojo.MessageData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
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

//    @RequestMapping("command")
//    public String receiverCommandService(@RequestBody MessageData messageData){
//        CommandReceiver commandReceiver = commandReceiverFactory.searchService(getCommand(messageData.getMessage()));
//        String andSendBack = null;
//        try {
//            andSendBack = commandReceiver.getAndSendBack(messageData);
//        } catch (Exception e) {
//            log.error("执行出错",e);
//            andSendBack = "输入指令有误 无法正确解析您的命令";
//        }
//        log.info("来源数据 {} ,返回数据 {}",messageData,andSendBack);
//        return andSendBack;
//    }

    @RequestMapping("command")
    public CommandData receiverCommandService(@RequestBody CommandData commandData) {
        log.info("远程请求答应参数 {}", JSONObject.toJSONString(commandData));
        CommandReceiver commandReceiver = commandReceiverFactory.searchService(commandData.getCommand());
        CommandData andSendBack = commandReceiver.getAndSendBack(commandData);
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

    private void initCommandData(CommandData commandData) {
        //初始化commandData的数据
        String command = commandData.getCommand();
        if (command.contains(Constant.commands.search)) {
            String[] args = commandData.getMessage().split(" ");
            if (args.length<3) {
                //快捷查分的
                commandData.getOtherDataMap().put("searchType","快捷查分");
                try {
                    commandData.getOtherDataMap().put("matchType",args.length<2?"11":args[1]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else {
                //非快捷查分
                commandData.getOtherDataMap().put("searchType","全量查分");
                commandData.getOtherDataMap().put("ageName",args);
            }
        }
    }


}
