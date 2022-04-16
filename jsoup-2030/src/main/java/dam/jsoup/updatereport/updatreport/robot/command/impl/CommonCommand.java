package dam.jsoup.updatereport.updatreport.robot.command.impl;

import dam.jsoup.updatereport.updatreport.robot.command.CommandReceiver;
import dam.jsoup.updatereport.updatreport.robot.pojo.CommandData;
import dam.jsoup.updatereport.updatreport.robot.service.QqAutoReplyService;
import dam.jsoup.updatereport.updatreport.robot.service.TencentApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CommonCommand implements CommandReceiver {
    private static final String QYUrl = "http://api.qingyunke.com/api.php";
    private static final String key = "free";
    private static final Integer appId = 0;
    private final TencentApiService tencentApiService;
    private final QqAutoReplyService qqAutoReplyService;

    public CommonCommand(TencentApiService tencentApiService, QqAutoReplyService qqAutoReplyService) {
        this.tencentApiService = tencentApiService;
        this.qqAutoReplyService = qqAutoReplyService;
    }

    @Override
    public CommandData getAndSendBack(CommandData commandData) {
        CommandData commandData1 = CommandData.newCopyCommandData(commandData);
        CommandData commandData2 = qqAutoReplyService.andBackCommandData(commandData1);
        if (commandData2 != null) {
            return commandData2;
        }
        String s = tencentApiService.newChatWithRobot(commandData.getMessage());
        try {
            commandData1.setCommand("发送语音");
        } catch (Exception e) {
            e.printStackTrace();
        }
        commandData1.setMessage(s);
        return commandData1;
    }
}
