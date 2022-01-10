package dam.jsoup.updatereport.updatreport.robot.command;

import dam.jsoup.updatereport.updatreport.robot.command.impl.AgeBindCommand;
import dam.jsoup.updatereport.updatreport.robot.command.impl.AgeSearchCommand;
import dam.jsoup.updatereport.updatreport.robot.command.impl.CommonCommand;
import dam.jsoup.updatereport.updatreport.robot.pojo.CommandData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
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

    /**
     * 处理
     * @param commandData
     * @return
     */
    public CommandData resolveData(CommandData commandData) {
        log.info("远程处理 入参{}",commandData);
        CommandReceiver commandReceiver = null;
        try {
            commandReceiver = searchService(commandData.getCommand());
            return commandReceiver.getAndSendBack(commandData);
        } catch (Exception e) {
            log.error("远程处理 错误 异常原因 ",e);
            return commandData.backMessage(e.getMessage());
        }
    }
}
