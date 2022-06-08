package dam.jsoup.updatereport.updatreport.robot.command;

import dam.jsoup.updatereport.updatreport.robot.command.impl.*;
import dam.jsoup.updatereport.updatreport.robot.pojo.CommandData;
import dam.jsoup.updatereport.updatreport.robot.pojo.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CommandReceiverFactory {
    private final AgeSearchCommand ageSearchCommand;
    private final CommonCommand commonCommand;
    private final AgeBindCommand ageBindCommand;
    private final PicAgeSearchCommand picAgeSearchCommand;
    private final RobotEmotionCommand robotEmotionCommand;

    public CommandReceiverFactory(AgeSearchCommand ageSearchCommand, CommonCommand command, CommonCommand commonCommand, AgeBindCommand ageBindCommand, PicAgeSearchCommand picAgeSearchCommand, RobotEmotionCommand robotEmotionCommand) {
        this.ageSearchCommand = ageSearchCommand;
        this.commonCommand = commonCommand;
        this.ageBindCommand = ageBindCommand;
        this.picAgeSearchCommand = picAgeSearchCommand;
        this.robotEmotionCommand = robotEmotionCommand;
    }
    public CommandReceiver searchService(String command){
        if (command.equals("查分")) {
            return ageSearchCommand;
        }else if (command.equals("绑定")) {
            return ageBindCommand;
        }else if (command.equals(Constant.commands.picSearch)) {
            return picAgeSearchCommand;
        } else if (command.equals(Constant.commands.robotEmotion)) {
            return robotEmotionCommand;
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
            return commandData.backMessage("输入的指令有误~咩咩？ \n" + e.getMessage());
        }
    }
}
