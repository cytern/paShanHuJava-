package dam.jsoup.updatereport.updatreport.robot.command;

import dam.jsoup.updatereport.updatreport.robot.command.impl.AgeBindCommand;
import dam.jsoup.updatereport.updatreport.robot.command.impl.AgeSearchCommand;
import dam.jsoup.updatereport.updatreport.robot.command.impl.CommonCommand;
import org.springframework.stereotype.Service;

@Service
public class CommandReceiverFactory {
    private final AgeSearchCommand ageSearchCommand;
    private final CommonCommand commonCommand;
    private final AgeBindCommand ageBindCommand;

    public CommandReceiverFactory(AgeSearchCommand ageSearchCommand, CommonCommand command, CommonCommand commonCommand, AgeBindCommand ageBindCommand) {
        this.ageSearchCommand = ageSearchCommand;
        this.commonCommand = commonCommand;
        this.ageBindCommand = ageBindCommand;
    }
    public CommandReceiver searchService(String command){
        if (command.contains("查分")) {
            return ageSearchCommand;
        }else if (command.contains("绑定")) {
            return ageBindCommand;
        }
        else {
            return commonCommand;
        }
    }
}
