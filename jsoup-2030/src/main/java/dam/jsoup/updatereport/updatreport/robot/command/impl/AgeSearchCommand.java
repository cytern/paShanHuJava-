package dam.jsoup.updatereport.updatreport.robot.command.impl;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import dam.jsoup.updatereport.updatreport.robot.api.AgeSearchApi;
import dam.jsoup.updatereport.updatreport.robot.command.CommandReceiver;
import dam.jsoup.updatereport.updatreport.robot.dto.*;
import dam.jsoup.updatereport.updatreport.robot.pojo.AgeSearchData;
import dam.jsoup.updatereport.updatreport.robot.pojo.CommandData;
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
    public CommandData getAndSendBack(CommandData commandData) {
        //第一步 语言识别
        String userName = "";
        String matchType = "1v1";
        QqAgeListExample example = new QqAgeListExample();
        CommandData backData = CommandData.newCopyCommandData(commandData);
        example.createCriteria().andQqIdEqualTo(commandData.getQqId()).andGroupIdEqualTo(commandData.getGroupId());
        List<QqAgeList> historySearchData = qqAgeListDao.selectByExample(example);
        QqAgeList defultAgeList = new QqAgeList();
        defultAgeList = backDefultAgeList(historySearchData);
        if (commandData.getMessage().equals("查分") || commandData.getMessage().equals(" 查分") || commandData.getMessage().equals("查分 ") || commandData.getMessage().equals(" 查分 ")) {
            if (historySearchData == null || historySearchData.size()<1|| historySearchData.get(0).getAgeName() == null) {
                //使用群名片进行沟通
                if (commandData.getOtherDataMap() == null || commandData.getOtherDataMap().getString("userNickName") == null || commandData.getOtherDataMap().getString("userNickName").equals("")) {
                    return backData.backMessage("快捷查询未能找到您账号绑定的游戏账号" + "\n" +
                            "请先绑定账号 例句:" +"\n" +
                            "@查分机器人 绑定 咩咩机器人 11");
                }else {
                    //默认查分类型是4v4
                    userName = commandData.getOtherDataMap().getString("userNickName");;
                    matchType = "4v4";
                }

            }else {
                userName = defultAgeList.getAgeName();
                matchType = defultAgeList.getType();
            }
        }else {
            String[] params = commandData.getMessage().split(" ");
            if (params.length > 3) {
                //非正常情况查分
                StringBuilder a = new StringBuilder(params[0]);
                for (int i = 1; i < params.length; i++) {
                    a.append(" ").append(params[i]);
                }
                userName = a.substring(a.indexOf("《") + 1, a.indexOf("》"));
            }else if (params.length == 2) {
                //应该和快捷查分一致
                if (historySearchData == null || historySearchData.size()<1|| historySearchData.get(0).getAgeName() == null) {
                    //使用群名片进行沟通
                    String userNickName = commandData.getOtherDataMap().getString("userNickName");
                    if (userNickName == null || userNickName.equals("")) {
                        return backData.backMessage("快捷查询未能找到您账号绑定的游戏账号" + "\n" +
                                "请先绑定账号 例句:" +"\n" +
                                "@查分机器人 绑定 咩咩机器人 11");
                    }else {
                        //默认查分类型是4v4
                        userName = userNickName;
                    }

                }else {
                    userName = defultAgeList.getAgeName();
                }
            }else {
               userName = params[1];
            }
            matchType = AgeBindCommand.backMatchType(params);
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
        example.createCriteria().andGroupIdEqualTo(commandData.getGroupId()).andTypeEqualTo(matchType);
        List<QqAgeList> groupAgeList = qqAgeListDao.selectByExample(example);
        if (jsonObject != null && jsonObject.get("count")!= null && jsonObject.getInteger("count") >0) {
            JSONArray items  = jsonObject.getJSONArray("items");
            StringBuilder result = new StringBuilder();
            if (items.size()>1) {
                result.append("id出现重名 数据可能并非准确 请自行判断").append("\n");
            }
            Integer time = 0;
            for (int i = 0; i < (Math.min(items.size(), 3)); i++) {
                Object obj = items.get(i);
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
                        .append("查询时间: ").append(DateUtil.today()).append("\n");
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
                        newAgeList.setQqId(commandData.getQqId());
                        newAgeList.setGroupId(commandData.getGroupId());
                        example.clear();
                        example.createCriteria().andQqIdEqualTo(commandData.getQqId())
                                .andGroupIdEqualTo(commandData.getGroupId())
                                .andTypeEqualTo(matchType);
                        qqAgeListDao.deleteByExample(example);
                       if (defultAgeList.getType().equals(matchType)) {
                           newAgeList.setDefult(1);
                       }
                        qqAgeListDao.insert(newAgeList);
                    }
                }
                time ++;
            }
            return  backData.backMessage(result.toString());
        }else {
            return backData.backMessage( "无法查询到该账号的战绩 查分失败 可能的原因如下\n" +
                    "未在该类型比赛进行十场以上" + "\n" +
                    "您的id输入错误或者识别错误 《"+ userName+ "》" +"\n" +
                    "类型输入错误或者识别错误 《" + matchType+" 》" + "\n" +
                    "又或者是您的参数使用方法不正确 请务必确认空格的数量是否正确以及参数是否正确 例句：\n" +
                    "@查分机器人 查分 咩咩机器人 11\n" +
                    "@查分机器人 查分 《我 超 勇 的》 11\n"+
                    "@查分机器人 查分");
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
