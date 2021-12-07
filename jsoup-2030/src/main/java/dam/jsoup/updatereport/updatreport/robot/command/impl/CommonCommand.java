package dam.jsoup.updatereport.updatreport.robot.command.impl;

import dam.jsoup.updatereport.updatreport.robot.command.CommandReceiver;
import dam.jsoup.updatereport.updatreport.robot.pojo.MessageData;
import org.springframework.stereotype.Service;

@Service
public class CommonCommand implements CommandReceiver {
    @Override
    public String getAndSendBack(MessageData messageData) {
        return "欢迎使用指令系统 " + (messageData.getGroupMarkName() == null? (messageData.getQqMark() ==null ? messageData.getQqName() : messageData.getQqMark()): messageData.getGroupMarkName());
    }
}
