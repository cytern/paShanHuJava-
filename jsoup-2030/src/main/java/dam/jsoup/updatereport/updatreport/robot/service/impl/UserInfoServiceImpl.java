package dam.jsoup.updatereport.updatreport.robot.service.impl;

import com.alibaba.fastjson.JSONObject;
import dam.jsoup.updatereport.updatreport.robot.dto.QqAgeListDao;
import dam.jsoup.updatereport.updatreport.robot.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserInfoServiceImpl implements UserInfoService {
    private final QqAgeListDao qqAgeListDao;

    public UserInfoServiceImpl(QqAgeListDao qqAgeListDao) {
        this.qqAgeListDao = qqAgeListDao;
    }

    @Override
    public boolean canSendVoiceMessage(String groupId,String qqId) {
        return false;
    }

    @Override
    public boolean isInCheckBalkList(String userName,String qqid) {
        List<JSONObject> blackList = qqAgeListDao.findBlackList();
        if (blackList != null) {
            List<JSONObject> ageName = blackList.stream().filter(t -> {
                return (userName.equals(t.getString("ageName")) || qqid.equals(t.getString("qqId")));
            }).collect(Collectors.toList());
            return ageName.size() > 0;
        }
        return false;
    }
}
