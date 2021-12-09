package dam.jsoup.updatereport.updatreport.robot.command;

import dam.jsoup.updatereport.updatreport.robot.pojo.MessageData;

public interface CommandReceiver {
    String getAndSendBack(MessageData messageData);
}
