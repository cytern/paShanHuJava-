package dam.jsoup.updatereport.updatreport.robot.service.impl;

import com.alibaba.fastjson.JSONObject;
import dam.jsoup.updatereport.updatreport.robot.dto.QqUser;
import dam.jsoup.updatereport.updatreport.robot.dto.QqUserDao;
import dam.jsoup.updatereport.updatreport.robot.pojo.ApiResult;
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
        String opType = params.getString("opType");
        if (opType.equals("search")) {
            return getOnesDis(qqId,rotCode);
        }else if (opType.equals("update")) {
            return updateOnesDis(qqId,rotCode,params);
        }
        QqUser qqUser = qqUserDao.selectByQqId(qqId,rotCode);
        JSONObject result = new JSONObject();
        result.putAll(JSONObject.parseObject(JSONObject.toJSONString(qqUser)));
        return result;
    }

    private JSONObject getOnesDis(String qqId,String rotCode) {
        QqUser qqUser = qqUserDao.selectByQqId(qqId, rotCode);
        if (qqUser == null) {
            //如果不存在用户 就要创建用户
           qqUser = new QqUser();
           qqUser.setQqId(Long.valueOf(qqId));
           qqUser.setLevel(0);
           qqUser.setPoint(0);
           qqUser.setQqName(rotCode);
           qqUserDao.insert(qqUser);
        }
        JSONObject result = new JSONObject();
        result.putAll(JSONObject.parseObject(JSONObject.toJSONString(qqUser)));
        return result;
    }

    private JSONObject updateOnesDis(String qqId,String rotCode,JSONObject params) {
        Integer num = params.getInteger("num");
        QqUser qqUser = qqUserDao.selectByQqId(qqId, rotCode);
        if (qqUser == null) {
            //如果不存在用户 就要创建用户
            qqUser = new QqUser();
            qqUser.setQqId(Long.valueOf(qqId));
            qqUser.setLevel(0);
            qqUser.setPoint(0);
            qqUser.setQqName(rotCode);
            qqUserDao.insert(qqUser);
        }
        qqUser.setLevel(qqUser.getLevel() + num);
        qqUserDao.updateByPrimaryKey(qqUser);
        return ApiResult.success();
    }
}
