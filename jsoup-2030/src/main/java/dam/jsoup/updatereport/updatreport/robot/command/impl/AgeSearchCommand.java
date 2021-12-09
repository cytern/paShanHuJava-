package dam.jsoup.updatereport.updatreport.robot.command.impl;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import dam.jsoup.updatereport.updatreport.robot.api.AgeSearchApi;
import dam.jsoup.updatereport.updatreport.robot.command.CommandReceiver;
import dam.jsoup.updatereport.updatreport.robot.dto.*;
import dam.jsoup.updatereport.updatreport.robot.pojo.AgeSearchData;
import dam.jsoup.updatereport.updatreport.robot.pojo.MessageData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgeSearchCommand implements CommandReceiver {
    private final QqRelGroupQqDao qqRelGroupQqDao;
    private final QqDetailDao qqDetailDao;
    private final QqAgeListDao qqAgeListDao;
    private final QqUserDao qqUserDao;

    public AgeSearchCommand(QqRelGroupQqDao qqRelGroupQqDao, QqDetailDao qqDetailDao, QqAgeListDao qqAgeListDao, QqUserDao qqUserDao) {
        this.qqRelGroupQqDao = qqRelGroupQqDao;
        this.qqDetailDao = qqDetailDao;
        this.qqAgeListDao = qqAgeListDao;
        this.qqUserDao = qqUserDao;
    }

    @Override
    public String getAndSendBack(MessageData messageData) {
        //第一步 语言识别
        String userName = "";
        String matchType = "1v1";
        QqAgeListExample example = new QqAgeListExample();
        example.createCriteria().andQqIdEqualTo(messageData.getQqId()).andGroupIdEqualTo(messageData.getGroupId());
        List<QqAgeList> historySearchData = qqAgeListDao.selectByExample(example);
        QqAgeList defultAgeList = new QqAgeList();
        defultAgeList = backDefultAgeList(historySearchData);
        if (messageData.getMessage().equals("查分") || messageData.getMessage().equals(" 查分") || messageData.getMessage().equals("查分 ") || messageData.getMessage().equals(" 查分 ")) {
            if (historySearchData == null || historySearchData.size()<1|| historySearchData.get(0).getAgeName() == null) {
                return "快捷查询未能找到您账号绑定的游戏账号 请使用  " + "\n" +
                        "@机器人 绑定 游戏名 游戏类型" +"\n" +
                        "进行绑定游戏账号 请注意 游戏类型为比赛类型 分别为 11 22 33 44 对应 1v1 2v2 等 并非帝国时代1234";
            }
            userName = defultAgeList.getAgeName();
            matchType = defultAgeList.getType();
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
        //查询群内 群友的全部成绩
        example.clear();
        example.createCriteria().andGroupIdEqualTo(messageData.getGroupId()).andTypeEqualTo(matchType);
        List<QqAgeList> groupAgeList = qqAgeListDao.selectByExample(example);
        if (jsonObject != null && jsonObject.get("count")!= null && jsonObject.getInteger("count") >0) {
            JSONArray items  = jsonObject.getJSONArray("items");
            StringBuilder result = new StringBuilder();
            if (items.size()>1) {
                result.append("id出现重名 数据可能并非准确 请自行判断").append("\n");
            }
            Integer time = 0;
            for (Object obj : items) {
                JSONObject item = JSONObject.parseObject(JSONObject.toJSONString(obj));
                String ageUserName = item.getString("userName");
                Integer allTimes = item.getInteger("wins") +  item.getInteger("losses");
                Integer elo = item.getInteger("elo");
                String winPercent = item.getString("winPercent");
                Integer rank = item.getInteger("rank");
                result.append("游戏名: ").append(ageUserName).append("\n")
                        .append("游戏类型: ").append(matchType).append("\n")
                        .append("天梯分: ").append(elo).append("\n")
                        .append("总胜率: ").append(winPercent).append("\n")
                        .append("总场次: ").append(allTimes).append("\n")
                        .append("全球名次: ").append(rank).append("\n")
                        .append("查询时间: ").append(DateUtil.now()).append("\n");
                if (historySearchData == null || historySearchData.size()<1 ) {
                    result.append("群内排名: ").append("绑定账号后显示群内排名 ").append("\n");
                }else {
                    result.append("群内排名: ").append(getTimes(groupAgeList,elo)).append("\n");
                }
                result.append("本机鉴定: ").append(addConstantFuckData(elo,getTimes(groupAgeList,elo))).append("\n");
                if (time == 0) {
                   //判断是否需要保存
                    if (historySearchData != null && historySearchData.size()>0 && historySearchData.get(0).getAgeName().equals(ageUserName)) {
                        QqAgeList newAgeList = new QqAgeList();
                        newAgeList.setAgeName(ageUserName);
                        newAgeList.setCreateTime(new Date());
                        newAgeList.setWinRate(winPercent);
                        newAgeList.setRank(rank);
                        newAgeList.setElo(elo);
                        newAgeList.setType(matchType);
                        newAgeList.setMatchTimes(allTimes);
                        newAgeList.setQqId(messageData.getQqId());
                        newAgeList.setGroupId(messageData.getGroupId());
                        example.clear();
                        example.createCriteria().andQqIdEqualTo(messageData.getQqId())
                                .andGroupIdEqualTo(messageData.getGroupId())
                                .andTypeEqualTo(matchType);
                        int i = qqAgeListDao.deleteByExample(example);
                       if (defultAgeList.getType().equals(matchType)) {
                           newAgeList.setDefult(1);
                       }
                        qqAgeListDao.insert(newAgeList);
                    }
                }
                time ++;
            }
            return result.toString();
        }else {
            return "暂时未能查询到您的战绩" + "\n" +
                    "正确的查询格式为" + "\n" +
                    "查分 id 比赛类型" + "\n" +
                    "查分 《id》 比赛类型 (id中含有空格)" + "\n " +
                    "同类型比赛十次以上方可查询成绩" ;
        }

    }

    private Integer getTimes(List<QqAgeList> groupList,Integer elo) {
        QqAgeList qqAgeList = new QqAgeList();
        qqAgeList.setType("查询专用");
        qqAgeList.setElo(elo);
        ArrayList<QqAgeList> copyList = new ArrayList<>(groupList);
        copyList.add(qqAgeList);
        List<QqAgeList> sortedList = copyList.stream().sorted(Comparator.comparingInt(QqAgeList::getElo).reversed()).collect(Collectors.toList());
        for (int i = 0; i < sortedList.size(); i++) {
            if (sortedList.get(i).getType().equals("查询专用")) {
                return i;
            }
        }
        return 999999;
    }

    public static QqAgeList backDefultAgeList(List<QqAgeList> historyList) {
        try {
            for (QqAgeList qqAgeList : historyList) {
                if (qqAgeList == null || qqAgeList.getDefult() == null) {
                    continue;
                }
                if (qqAgeList.getDefult().equals(1)){
                    return qqAgeList;
                }
            }
            return historyList.get(0);
        } catch (Exception e) {
            return new QqAgeList();
        }
    }

    /**
     * 添加操蛋的评价
     */
    private static String addConstantFuckData(Integer elo,Integer times) {
        String backString  = "";
        if (elo <800) {
            backString = backString + "粗大的";
        }else if (elo < 1000) {
            backString = backString + "粗的";
        }else if (elo < 1100) {
            backString = backString + "适宜的";
        }else if (elo< 1200) {
            backString = backString + "粗中有细的";
        }else if (elo < 1300) {
            backString = backString + "细小的";
        }else if (elo < 1400) {
            backString = backString + "可爱的";
        }else if (elo <1500) {
            backString = backString + "小可爱的";
        }else {
            backString = backString + "神仙";
        }
        if (times < 2){
            backString = backString  + "鱼塘霸主 ";
        }else if (times <4 ) {
            backString = backString + "鱼塘三叉戟 ";
        }else if (times < 10){
            backString = backString + "鱼 ";
        }else {
            backString = backString + "钓鱼佬 ";
        }
        return backString;
    }
}
