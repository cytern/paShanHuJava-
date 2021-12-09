package dam.jsoup.updatereport.updatreport.robot.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
public class MessageData{
    private String message;
    private boolean isGroup;
    private String qqId;
    private String groupId;
    private String qqName;
    private String qqMark;
    private String groupMarkName;
}
