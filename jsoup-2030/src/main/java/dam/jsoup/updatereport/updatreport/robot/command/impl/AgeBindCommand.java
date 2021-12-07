package dam.jsoup.updatereport.updatreport.robot.command.impl;

import dam.jsoup.updatereport.updatreport.robot.command.CommandReceiver;
import dam.jsoup.updatereport.updatreport.robot.pojo.MessageData;
import org.springframework.stereotype.Service;

@Service
public class AgeBindCommand implements CommandReceiver {
    @Override
    public String getAndSendBack(MessageData messageData) {
        return null;
    }
}
