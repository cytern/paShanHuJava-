package dam.jsoup.updatereport.updatreport.robot.pojo;

import lombok.Data;

@Data
public class UserData {
    private Integer id;
    private Long qqId;
    private String qqMark;
    private String qqName;
    /**
     * 等级  用户区分权限
     */
    private Integer level;
    /**
     * 荣誉 称号
     */
    private String honor;
    /**
     * 点数 区分服务费用等
     */
    private Integer point;
}
