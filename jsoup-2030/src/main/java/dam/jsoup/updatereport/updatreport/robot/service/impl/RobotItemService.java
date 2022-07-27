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
    private QqUserItemDao qqUserItemDao;


    @Override
    public JSONObject resAndGetDataBack(JSONObject params) {
        String opType = params.getString("opType");
        //查询个人
        if (opType.equals("search")) {
            return searchOnesItemList(params);
        }else if (opType.equals("update")) {
            return updateOnesItemList(params);
        }else if (opType.equals("reflush")) {
            return updateSysItemList(params);
        }
        return ApiResult.fail("无效的操作类型");
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
        String robotCode = params.getString("robotCode");
        //删除现在有的机器码的物品
        int i = qqUserItemDao.deleteQqItemByRobotCode(robotCode);
        JSONArray itemList = params.getJSONArray("itemList");
        ArrayList<JSONObject> waitAddJson = new ArrayList<>();
        if (itemList!= null && itemList.size()>0) {
            for (int j = 0; j < itemList.size(); j++) {
                JSONObject jsonObject = itemList.getJSONObject(j);
                jsonObject.put("robotCode",params.getString("robotCode"));
                jsonObject.put("qqId",params.getString("qqId"));
                if (jsonObject.getJSONObject("itemPop") == null || jsonObject.getJSONObject("itemPop").isEmpty()) {
                    jsonObject.put("itemPop",null);
                }
                jsonObject.put("delFlag",0);
                waitAddJson.add(jsonObject);
            }
        }
        qqUserItemDao.insertAllItem(waitAddJson);
        return ApiResult.success();
    }
}
