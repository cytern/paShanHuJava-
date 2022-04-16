package dam.jsoup.updatereport.updatreport.robot.pojo;

import com.alibaba.fastjson.JSONObject;
import dam.jsoup.updatereport.updatreport.util.readJson.JsonUtil;
import lombok.Data;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;

@Data
public class CommandData {

    private String qqId;

    private String groupId;
    /**
     * 1是个人
     * 2是群组
     * 3 群组私聊
     */
    private Integer type;
    /**
     * 命令
     */
    private String command;
    /**
     * 发送的消息内容
     */
    private String message;

    private JSONObject otherDataMap;

    public static CommandData newCopyCommandData(CommandData commandData){
        CommandData backData = new CommandData();
        backData.setQqId(commandData.getQqId());
        backData.setGroupId(commandData.getGroupId());
        backData.setType(commandData.getType());
        backData.setMessage(commandData.getMessage());
        backData.setCommand("发送");
        return backData;
    }

    public CommandData backMessage(String message) {
        this.message = message;
        return this;
    }
    public void clearOtherDataMap () {
        this.otherDataMap = new JSONObject();
    }

}
