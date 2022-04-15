package dam.jsoup.updatereport.updatreport.robot.service;

public interface UserInfoService {

    boolean canSendVoiceMessage(String gourpId,String qqId);

    boolean isInCheckBalkList(String userName,String qqId);
}
