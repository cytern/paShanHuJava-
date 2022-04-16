package dam.jsoup.updatereport.updatreport.robot.service;

import dam.jsoup.updatereport.updatreport.robot.pojo.CommandData;
import dam.jsoup.updatereport.updatreport.robot.pojo.QqAutoReply;

import java.util.List;

public interface QqAutoReplyService {
    /**
     * 处理并且返回自动聊天的值 如果为null 则未找到自动聊天
     */
    CommandData andBackCommandData(CommandData commandData);

    List<QqAutoReply> getAutoReply(String askKey);
}
