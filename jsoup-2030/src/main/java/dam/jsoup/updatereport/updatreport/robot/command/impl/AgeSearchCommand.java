package dam.jsoup.updatereport.updatreport.robot.command.impl;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import dam.jsoup.updatereport.updatreport.robot.api.AgeSearchApi;
import dam.jsoup.updatereport.updatreport.robot.command.CommandReceiver;
import dam.jsoup.updatereport.updatreport.robot.dto.*;
import dam.jsoup.updatereport.updatreport.robot.pojo.AgeSearchData;
import dam.jsoup.updatereport.updatreport.robot.pojo.MessageData;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class AgeSearchCommand implements CommandReceiver {
    private final QqRelGroupQqDao qqRelGroupQqDao;
    private final QqDetailDao qqDetailDao;
    private final QqAgeListDao qqAgeListDao;

    public AgeSearchCommand(QqRelGroupQqDao qqRelGroupQqDao, QqDetailDao qqDetailDao, QqAgeListDao qqAgeListDao) {
        this.qqRelGroupQqDao = qqRelGroupQqDao;
        this.qqDetailDao = qqDetailDao;
        this.qqAgeListDao = qqAgeListDao;
    }

    @Override
    public String getAndSendBack(MessageData messageData) {
        //第一步 语言识别
        String userName = "";
        String matchType = "1v1";
        QqAgeListExample example = new QqAgeListExample();
        if (messageData.getMessage().equals("查分")) {
            JSONObject jsonObject = qqDetailDao.getAgeDataDefultQQ(messageData.getQqId());
            if (jsonObject == null || jsonObject.getString("ageName") == null) {
                return "未能查询到您的绑定账号 请重新确认";
            }
            userName = jsonObject.getString("ageName");
            matchType = jsonObject.getString("type");
        }else {
            String[] params = messageData.getMessage().split(" ");
            if (params.length!= 3) {
                //非正常情况查分
                StringBuilder a = new StringBuilder(params[0]);
                for (int i = 1; i < params.length; i++) {
                    a.append(" ").append(params[i]);
                }
                String substring = a.substring(a.indexOf("《") + 1, a.indexOf("》"));
                userName = substring;
                String type = params[params.length-1];
                if (type.contains("11")) {
                    matchType = "1v1";
                }else if (type.contains("22")) {
                    matchType = "2v2";
                }
                else if (type.contains("33")) {
                    matchType = "3v3";
                }
                else if (type.contains("44")) {
                    matchType = "4v4";
                }
            }else {
               userName = params[1];
                if (params[2].contains("11")) {
                    matchType = "1v1";
                }else if (params[2].contains("22")) {
                    matchType = "2v2";
                }
                else if (params[2].contains("33")) {
                    matchType = "3v3";
                }
                else if (params[2].contains("44")) {
                    matchType = "4v4";
                }
            }
        }
        AgeSearchData ageSearchData = new AgeSearchData();
        ageSearchData.setMatchType("unranked");
        ageSearchData.setPage(1);
        ageSearchData.setRegion("7");
        ageSearchData.setVersus("players");
        ageSearchData.setCount(100);
        ageSearchData.setTeamSize(matchType);
        ageSearchData.setSearchPlayer(userName);
        JSONObject jsonObject = AgeSearchApi.searchAgeRank(ageSearchData);
        if (jsonObject != null && jsonObject.get("count")!= null && jsonObject.getInteger("count") >0) {
            JSONArray items  = jsonObject.getJSONArray("items");
            StringBuilder result = new StringBuilder();
            if (items.size()>1) {
                result.append("id出现重名 仅展示 暂且不支持排序功能").append("\n");
                for (Object obj : items) {
                    JSONObject item = JSONObject.parseObject(JSONObject.toJSONString(obj));
                    String ageUserName = item.getString("userName");
                    Integer allTimes = item.getInteger("wins") +  item.getInteger("losses");
                    Integer elo = item.getInteger("elo");
                    String winPercent = item.getString("winPercent");
                    Integer rank = item.getInteger("rank");
                    result.append("游戏名: ").append(ageUserName).append("\n")
                            .append("游戏类型: ").append(matchType).append("\n")
                            .append("群内排名: ").append("未绑定账号不支持排名").append("\n")
                            .append("天梯分: ").append(elo).append("\n")
                            .append("总胜率: ").append(winPercent).append("\n")
                            .append("总场次: ").append(allTimes).append("\n")
                            .append("全球名次: ").append(rank).append("\n")
                            .append("查询时间: ").append(DateUtil.now()).append("\n").append("\n");

                }
            }else {
                JSONObject item =items.getJSONObject(0);
                String ageUserName = item.getString("userName");
                Integer allTimes = item.getInteger("wins") +  item.getInteger("losses");
                Integer elo = item.getInteger("elo");
                String winPercent = item.getString("winPercent");
                Integer rank = item.getInteger("rank");
                QqAgeList qqAgeList =null;
                //看看数据库有没有这个人的id 在这个群里 有就要更新
                example.clear();
                example.createCriteria().andAgeNameEqualTo(ageUserName)
                        .andGroupIdEqualTo(messageData.getGroupId());
                List<QqAgeList> qqAgeLists = qqAgeListDao.selectByExample(example);
                if (qqAgeLists == null ) {
                     //没有 那就直接返回
                    result.append("游戏名: ").append(ageUserName).append("\n")
                            .append("游戏类型: ").append(matchType).append("\n")
                            .append("群内排名: ").append("未绑定账号不支持排名").append("\n")
                            .append("天梯分: ").append(elo).append("\n")
                            .append("总胜率: ").append(winPercent).append("\n")
                            .append("总场次: ").append(allTimes).append("\n")
                            .append("全球名次: ").append(rank).append("\n")
                            .append("查询时间: ").append(DateUtil.now());
                }else {
                    //说明是绑定账号 帮他更新或者插入~
                    for (QqAgeList ageList : qqAgeLists) {
                        if (ageList.getType().equals(matchType)){
                            qqAgeList = ageList;

                        }
                    }
                    //如果 不是空 就更新 是空 就插入
                    if (qqAgeList == null) {
                        qqAgeList = new QqAgeList();
                        qqAgeList.setQqId(qqAgeLists.get(0).getQqId());
                        qqAgeList.setCreateTime(new Date());
                    }
                    qqAgeList.setElo(elo);
                    qqAgeList.setRank(rank);
                    qqAgeList.setType(matchType);
                    qqAgeList.setMatchTimes(allTimes);
                    qqAgeList.setWinRate(winPercent);
                    qqAgeList.setAgeName(ageUserName);
                }


            }
            for (Object obj : items) {
                JSONObject item = JSONObject.parseObject(JSONObject.toJSONString(obj));
                Integer allTimes = item.getInteger("wins") + item.getInteger("losses");
                String abs = "全球排名: " + item.getInteger("rank") + "\n" +
                        "积分: " + item.getInteger("elo") + "\n" +
                        "胜率: " + item.getBigDecimal("winPercent") + "\n" +
                        "总场次: " + allTimes + "\n" +
                        "id: " + item.getString("userName") ;
                result.append(abs);
            }
            return result.toString();
        }else {
            return "暂时未能查询到您的战绩" + "\n" +
                    "正确的查询格式为" + "\n" +
                    "查分 id 比赛类型" + "\n" +
                    "查分 《id》 比赛类型 （适用于id中含有空格的类型）";
        }

    }
}
