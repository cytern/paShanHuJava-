package dam.jsoup.updatereport.updatreport.robot.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.alibaba.fastjson.JSONObject;
import dam.jsoup.updatereport.updatreport.robot.mapper.QqAutoReplyMapper;
import dam.jsoup.updatereport.updatreport.robot.pojo.CommandData;
import dam.jsoup.updatereport.updatreport.robot.pojo.Constant;
import dam.jsoup.updatereport.updatreport.robot.pojo.QqAutoReply;
import dam.jsoup.updatereport.updatreport.robot.service.QqAutoReplyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class QqAutoReplyServiceImpl implements QqAutoReplyService {

    private final QqAutoReplyMapper qqAutoReplyMapper;

    public QqAutoReplyServiceImpl(QqAutoReplyMapper qqAutoReplyMapper) {
        this.qqAutoReplyMapper = qqAutoReplyMapper;
    }

    /**
     * 处理并且返回自动聊天的值 如果为null 则未找到自动聊天
     *
     * @param commandData
     */
    @Override
    public CommandData andBackCommandData(CommandData commandData) {
        String allMessage = commandData.getMessage();
        log.info("获取到的 message {}",JSONObject.toJSONString(commandData));
        List<QqAutoReply> autoReply = getAutoReply(allMessage);
       log.info("获取到的回复列表 {}",autoReply );
        if (autoReply == null || autoReply.size()<1) {
            return null;
        }else {
            //筛选确定是否可回复
            List<QqAutoReply> collect = autoReply.stream().filter(t -> {
                if (t.getAskType() == 1) {
                    if (!allMessage.contains(t.getAskKey())) {
                        return false;
                    }
                }
                if (t.getAskType() == 2) {
                    if (!t.getAskKey().equals(allMessage)) {
                        return false;
                    }
                }
                if (t.getTargetType() != 0) {
                    if (t.getTargetType().equals(1)) {
                        if (!commandData.getGroupId().equals(t.getTargetKey())) {
                            return false;
                        }
                    } else if (t.getTargetType().equals(2)) {
                        if (!commandData.getQqId().equals(t.getTargetKey())) {
                            return false;
                        }
                    }
                }
                return true;
            }).collect(Collectors.toList());
            if (collect.size() <1) {
                return null;
            }
            int i = RandomUtil.randomInt(0, collect.size());
            QqAutoReply qqAutoReply = collect.get(i);
            commandData.setCommand(Constant.commands.autoSend);
            commandData.setOtherDataMap(JSONObject.parseObject(JSONObject.toJSONString(qqAutoReply)));
            return commandData;
        }
    }

    @Override
    public List<QqAutoReply> getAutoReply(String askKey) {
        return qqAutoReplyMapper.selectOneByParams(askKey);
    }
}
