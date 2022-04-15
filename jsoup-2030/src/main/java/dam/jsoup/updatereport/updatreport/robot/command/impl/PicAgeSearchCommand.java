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
import dam.jsoup.updatereport.updatreport.robot.service.UserInfoService;
import dam.jsoup.updatereport.updatreport.util.RedisUtil;
import dam.jsoup.updatereport.updatreport.util.Toolkit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class PicAgeSearchCommand implements CommandReceiver {
    private final RedisUtil redisUtil;
    private final QqAgeListDao qqAgeListDao;
    private final UserInfoService userInfoService;

    public PicAgeSearchCommand(RedisUtil redisUtil, QqAgeListDao qqAgeListDao, UserInfoService userInfoService) {
        this.redisUtil = redisUtil;

        this.qqAgeListDao = qqAgeListDao;
        this.userInfoService = userInfoService;
    }

    @Override
    public CommandData getAndSendBack(CommandData commandData) {
        //411 之后版本的服务端不进行语言文字解析
        log.info("图片查分接口开始  入参{}",JSONObject.toJSONString(commandData));
        JSONObject params = commandData.getOtherDataMap();
        CommandData backCommand = CommandData.newCopyCommandData(commandData);
        backCommand.setCommand(Constant.commands.ageSearchPicCreate);
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
                backCommand.setMessage("未查询到绑定游戏名 请先绑定账户");
                backCommand.setCommand(Constant.commands.send);
                return backCommand;
            }

        }
        if (userInfoService.isInCheckBalkList(userName,commandData.getQqId())){
            backCommand.clearOtherDataMap();
            backCommand.setMessage("哪里来的挂狗or上挂车的狗 有空去检查一下自己加户口本的页数还剩多少 检查完了想想自己这么打游戏对得起自己加里人么");
            backCommand.setCommand(Constant.commands.send);
            return backCommand;
        }
        JSONObject jsonObject = new JSONObject();
        List<JSONObject> userAllAgeData = getUserAllAgeData(userName);
        jsonObject.put("data",userAllAgeData);
        jsonObject.put("userName",userName);
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
        ageSearchData.setPage(1);
        ageSearchData.setRegion("7");
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
                JSONArray items = null;
                if (result != null) {
                    items = result.getJSONArray("items");
                }
                if (items == null) {
                    continue;
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
        oneTimesData.put("totalData",totalDatas);
        oneTimesData.put("updateTime",DateUtil.now());
        //移出上一次的值
        redisUtil.lRightPop(cachedDataKet);
        redisUtil.lRightPush(cachedDataKet,oneTimesData.toJSONString());
        redisUtil.set(hotDataKey,"1");
        redisUtil.expire(hotDataKey,2, TimeUnit.HOURS);
        return Collections.singletonList(oneTimesData);
    }
}
