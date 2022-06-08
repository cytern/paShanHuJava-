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

import java.util.List;

/**
 * 机器人情绪模块组件
 */
@Service
@Slf4j
public class RobotEmotionCommand implements CommandReceiver {
    private final TencentApiService tencentApiService;
    private final QqAutoReplyService qqAutoReplyService;
    private final QqRoleImgMapper roleImgMapper;

    public RobotEmotionCommand(TencentApiService tencentApiService, QqAutoReplyService qqAutoReplyService, QqRoleImgMapper roleImgMapper) {
        this.tencentApiService = tencentApiService;
        this.qqAutoReplyService = qqAutoReplyService;
        this.roleImgMapper = roleImgMapper;
    }

    /**
     * 给一句话做情绪处理
     * @param commandData
     * @return
     */
    @Override
    public CommandData getAndSendBack(CommandData commandData) {
        Integer messageEmotion = tencentApiService.getMessageEmotion(commandData.getMessage());
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
        commandData.setOtherDataMap(JSON.parseObject(JSONObject.toJSONString(rightImg)));
        commandData.setCommand(Constant.commands.robotPic);
        return commandData;
    }
}
