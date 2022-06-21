package dam.jsoup.updatereport.updatreport.robot.service.impl;

import com.alibaba.fastjson.JSONObject;
import dam.jsoup.updatereport.updatreport.robot.dto.QqUser;
import dam.jsoup.updatereport.updatreport.robot.dto.QqUserDao;
import dam.jsoup.updatereport.updatreport.robot.service.CommonDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class IDispositionService implements CommonDataService {
    @Autowired
    private QqUserDao qqUserDao;
    @Override
    public JSONObject resAndGetDataBack(JSONObject params) {
        String qqId = params.getString("qqId");
        String rotCode = params.getString("rotCode");
        QqUser qqUser = qqUserDao.selectByQqId(qqId,rotCode);
        JSONObject result = new JSONObject();
        result.putAll(JSONObject.parseObject(JSONObject.toJSONString(qqUser)));
        return result;
    }
}
