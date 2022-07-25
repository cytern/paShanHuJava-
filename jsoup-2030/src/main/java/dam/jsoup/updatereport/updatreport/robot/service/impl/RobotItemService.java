package dam.jsoup.updatereport.updatreport.robot.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import dam.jsoup.updatereport.updatreport.robot.mapper.QqItemDao;
import dam.jsoup.updatereport.updatreport.robot.mapper.QqUserItemDao;
import dam.jsoup.updatereport.updatreport.robot.pojo.ApiResult;
import dam.jsoup.updatereport.updatreport.robot.service.CommonDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class RobotItemService implements CommonDataService {

    @Autowired
    private QqItemDao qqItemDao;

    @Autowired
    private QqUserItemDao qqUserItemDao;


    @Override
    public JSONObject resAndGetDataBack(JSONObject params) {
        String opType = params.getString("opType");
        //查询个人
        if (opType.equals("search")) {
            return searchOnesItemList(params);
        }else if (opType.equals("update")) {
            return updateOnesItemList(params);
        }
        return null;
    }


    private JSONObject searchOnesItemList (JSONObject params) {
        List<JSONObject> usersAllItem = qqUserItemDao.getUsersAllItem(params);
        JSONObject result = new JSONObject();
        result.put("itemList",usersAllItem);
        return ApiResult.success(result);
    }

    private JSONObject updateOnesItemList (JSONObject params) {
        ArrayList<JSONObject> insertList = new ArrayList<>();
        JSONArray itemList = params.getJSONArray("itemList");
        if (itemList != null && itemList.size()>0) {
            for (int i = 0; i < itemList.size(); i++) {
                JSONObject jsonObject = itemList.getJSONObject(i);
                jsonObject.put("robotCode",params.getString("robotCode"));
                jsonObject.put("qqId",params.getString("qqId"));
                jsonObject.put("delFlag",0);
                insertList.add(jsonObject);
            }
            int i = qqUserItemDao.insertOrUpdateQqUserItem(insertList);
        }
        return searchOnesItemList(params);
    }

    private JSONObject updateSysItemList (JSONObject params) {
       return null;
    }
}
