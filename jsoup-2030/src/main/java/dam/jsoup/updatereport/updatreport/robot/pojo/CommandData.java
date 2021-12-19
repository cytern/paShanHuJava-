package dam.jsoup.updatereport.updatreport.robot.pojo;

import lombok.Data;

@Data
public class CommandData {

    private String qqId;

    private String groupId;
    /**
     * 1是个人
     * 2是群组
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

}
