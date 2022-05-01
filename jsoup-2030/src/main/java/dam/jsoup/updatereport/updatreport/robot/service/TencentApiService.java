package dam.jsoup.updatereport.updatreport.robot.service;

public interface TencentApiService {
    /**
     * 与闲聊机器人闲聊
     * @param message
     * @return
     */
    String newChatWithRobot(String message);

    /**
     * 返回转化之后的语音消息下载地址
     * @param message
     * @return
     */
    String getChatFile(String message);

    /**
     * 获取对话的情绪
     * @param message
     * @return
     */
    Integer getMessageEmotion(String message);
}
