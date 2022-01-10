package dam.jsoup.updatereport.updatreport.robot.command.impl;

import dam.jsoup.updatereport.updatreport.robot.command.CommandReceiver;
import dam.jsoup.updatereport.updatreport.robot.pojo.CommandData;
import dam.jsoup.updatereport.updatreport.robot.pojo.MessageData;
import org.springframework.stereotype.Service;

@Service
public class CommonCommand implements CommandReceiver {
    @Override
    public CommandData getAndSendBack(CommandData commandData) {
        CommandData commandData1 = CommandData.newCopyCommandData(commandData);
        return commandData1.backMessage("咩咩?");
    }
}
