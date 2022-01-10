package dam.jsoup.updatereport.updatreport.robot.command;

import dam.jsoup.updatereport.updatreport.robot.pojo.CommandData;
import dam.jsoup.updatereport.updatreport.robot.pojo.MessageData;

public interface CommandReceiver {
    CommandData getAndSendBack(CommandData commandData);
}
