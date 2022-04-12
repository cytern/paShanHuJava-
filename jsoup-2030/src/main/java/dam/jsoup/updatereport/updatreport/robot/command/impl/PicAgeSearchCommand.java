package dam.jsoup.updatereport.updatreport.robot.command.impl;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import dam.jsoup.updatereport.updatreport.robot.api.AgeSearchApi;
import dam.jsoup.updatereport.updatreport.robot.command.CommandReceiver;
import dam.jsoup.updatereport.updatreport.robot.dto.QqAgeList;
import dam.jsoup.updatereport.updatreport.robot.dto.QqAgeListDao;
import dam.jsoup.updatereport.updatreport.robot.dto.QqAgeListExample;
import dam.jsoup.updatereport.updatreport.robot.pojo.AgeSearchData;
import dam.jsoup.updatereport.updatreport.robot.pojo.CommandData;
import dam.jsoup.updatereport.updatreport.robot.pojo.Constant;
import dam.jsoup.updatereport.updatreport.util.RedisUtil;
import dam.jsoup.updatereport.updatreport.util.Toolkit;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class PicAgeSearchCommand implements CommandReceiver {
    private final RedisUtil redisUtil;
    private final QqAgeListDao qqAgeListDao;

    public PicAgeSearchCommand(RedisUtil redisUtil, QqAgeListDao qqAgeListDao) {
        this.redisUtil = redisUtil;

        this.qqAgeListDao = qqAgeListDao;
    }

    @Override
    public CommandData getAndSendBack(CommandData commandData) {
        //411 之后版本的服务端不进行语言文字解析
        JSONObject params = commandData.getOtherDataMap();
        CommandData backCommand = CommandData.newCopyCommandData(commandData);
        String userName = "";
        if (Toolkit.isValid(params.getString("userName"))) {
            //查分的时候携带了用户名
            userName = params.getString("userName");
        }else {
            //看看是否有历史查询数据
            QqAgeListExample qqAgeListExample = new QqAgeListExample();
            QqAgeListExample.Criteria criteria = qqAgeListExample.createCriteria();
            criteria.andQqIdEqualTo(commandData.getQqId()).andGroupIdEqualTo(commandData.getGroupId());
            List<QqAgeList> qqAgeLists = qqAgeListDao.selectByExample(qqAgeListExample);
            if (qqAgeLists != null && qqAgeLists.size()>0) {
                userName = qqAgeLists.get(0).getAgeName();
            }else {
                backCommand.clearOtherDataMap();
                return backCommand;
            }

        }
        JSONObject jsonObject = new JSONObject();
        List<JSONObject> userAllAgeData = getUserAllAgeData(userName);
        jsonObject.put("data",userAllAgeData);
        backCommand.setOtherDataMap(jsonObject);
        return backCommand;
    }

    public List<JSONObject> getUserAllAgeData (String userName) {
        ArrayList<JSONObject> finalData = new ArrayList<>();
        String hotDataKey = Constant.redisKey.hotData + userName;
        String cachedDataKet = Constant.redisKey.cachedData + userName;
        if (redisUtil.hasKey(hotDataKey)) {
            //直接拿缓存的数据 存最近七次查分的数据 hotData 存在2小时
            List<String> strings = redisUtil.lRange(cachedDataKet, 0, -1);
            for (String string : strings) {
                JSONObject jsonObject = JSONObject.parseObject(string);
                finalData.add(jsonObject);
            }
            return finalData;
        }
        AgeSearchData ageSearchData = new AgeSearchData();
        ageSearchData.setSearchPlayer(userName);
        ageSearchData.setVersus("players");
        ageSearchData.setCount(1);
        JSONArray totalDatas = new JSONArray();
        for (int i = 0; i < 2; i++) {
            JSONArray resultList = new JSONArray();
            if (i==0) {
                ageSearchData.setMatchType("unranked");
            }else {
                ageSearchData.setMatchType("ranked");
            }
            for (int j = 0; j < 4; j++) {
                if (j == 0) {
                    ageSearchData.setTeamSize("1v1");
                }else if (j==1) {
                    ageSearchData.setTeamSize("2v2");
                }else if (j==2) {
                    ageSearchData.setTeamSize("3v3");
                }else if (j==3){
                    ageSearchData.setTeamSize("4v4");
                }
                JSONObject result = AgeSearchApi.searchAgeRank(ageSearchData);
                JSONArray items = result.getJSONArray("items");
                if (items == null) {
                    break;
                }
                JSONObject singleItem = items.getJSONObject(0);
                singleItem.put("updateTime", DateUtil.now());
                singleItem.put("timeSize",ageSearchData.getTeamSize());
                resultList.add(singleItem);
            }
            JSONObject finalOneTimeData = new JSONObject();
            finalOneTimeData.put("dataList",resultList);
            finalOneTimeData.put("updateTime",DateUtil.now());
            finalOneTimeData.put("matchType",ageSearchData.getMatchType());
            totalDatas.add(finalOneTimeData);
        }
        JSONObject oneTimesData = new JSONObject();
        oneTimesData.put("matchType",totalDatas);
        oneTimesData.put("updateTime",DateUtil.now());
        //移出上一次的值
        redisUtil.lRightPop(cachedDataKet);
        redisUtil.lRightPush(cachedDataKet,oneTimesData.toJSONString());
        redisUtil.set(hotDataKey,"1");
        redisUtil.expire(hotDataKey,2, TimeUnit.HOURS);
        return Collections.singletonList(oneTimesData);
    }
}
