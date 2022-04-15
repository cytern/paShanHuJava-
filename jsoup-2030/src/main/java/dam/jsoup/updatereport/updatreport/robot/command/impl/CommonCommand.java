package dam.jsoup.updatereport.updatreport.robot.command.impl;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSONObject;
import dam.jsoup.updatereport.updatreport.robot.command.CommandReceiver;
import dam.jsoup.updatereport.updatreport.robot.pojo.CommandData;
import dam.jsoup.updatereport.updatreport.robot.service.TencentApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@Slf4j
public class CommonCommand implements CommandReceiver {
    private static final String QYUrl = "http://api.qingyunke.com/api.php";
    private static final String key = "free";
    private static final Integer appId = 0;
    private final TencentApiService tencentApiService;

    public CommonCommand(TencentApiService tencentApiService) {
        this.tencentApiService = tencentApiService;
    }

    @Override
    public CommandData getAndSendBack(CommandData commandData) {
        CommandData commandData1 = CommandData.newCopyCommandData(commandData);
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
