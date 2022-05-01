package dam.jsoup.updatereport.updatreport.robot.command.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import dam.jsoup.updatereport.updatreport.robot.command.CommandReceiver;
import dam.jsoup.updatereport.updatreport.robot.dto.QqGroup;
import dam.jsoup.updatereport.updatreport.robot.dto.QqRoleImg;
import dam.jsoup.updatereport.updatreport.robot.mapper.QqRoleImgMapper;
import dam.jsoup.updatereport.updatreport.robot.pojo.CommandData;
import dam.jsoup.updatereport.updatreport.robot.pojo.Constant;
import dam.jsoup.updatereport.updatreport.robot.service.QqAutoReplyService;
import dam.jsoup.updatereport.updatreport.robot.service.TencentApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@Slf4j
public class CommonCommand implements CommandReceiver {
    private final TencentApiService tencentApiService;
    private final QqAutoReplyService qqAutoReplyService;
    private final QqRoleImgMapper roleImgMapper;

    public CommonCommand(TencentApiService tencentApiService, QqAutoReplyService qqAutoReplyService, QqRoleImgMapper roleImgMapper) {
        this.tencentApiService = tencentApiService;
        this.qqAutoReplyService = qqAutoReplyService;
        this.roleImgMapper = roleImgMapper;
    }

    @Override
    public CommandData getAndSendBack(CommandData commandData) {
        CommandData commandData1 = CommandData.newCopyCommandData(commandData);
        CommandData commandData2 = qqAutoReplyService.andBackCommandData(commandData1);
        if (commandData2 != null) {
            return commandData2;
        }
        String s = tencentApiService.newChatWithRobot(commandData.getMessage());
        Integer messageEmotion = tencentApiService.getMessageEmotion(s);
        String roleName = "lovely";
        QqGroup groupRole = roleImgMapper.getGroupRole(commandData.getGroupId());
        if (groupRole != null) {
            roleName = groupRole.getGroupName();
        }
        List<QqRoleImg> allRoleImage = roleImgMapper.getAllRoleImage(roleName);
        QqRoleImg rightImg = null;
        for (QqRoleImg qqRoleImg : allRoleImage) {
            if (qqRoleImg.getEmotion().equals(messageEmotion)) {
                rightImg = qqRoleImg;
                break;
            }
            if (qqRoleImg.getEmotion() > messageEmotion) {
                if ((qqRoleImg.getEmotion() - messageEmotion) > (messageEmotion - rightImg.getEmotion())) {
                    break;
                }else {
                    rightImg = qqRoleImg;
                    break;
                }
            }
            rightImg = qqRoleImg;
        }
        commandData1.setOtherDataMap(JSON.parseObject(JSONObject.toJSONString(rightImg)));
        commandData1.setCommand(Constant.commands.robotPic);
        commandData1.setMessage(s);
        return commandData1;
    }
}
