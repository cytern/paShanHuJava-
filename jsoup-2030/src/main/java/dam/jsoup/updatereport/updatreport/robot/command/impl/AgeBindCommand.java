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
import dam.jsoup.updatereport.updatreport.robot.pojo.MessageData;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AgeBindCommand implements CommandReceiver {
    private final QqAgeListDao qqAgeListDao;

    public AgeBindCommand(QqAgeListDao qqAgeListDao) {
        this.qqAgeListDao = qqAgeListDao;
    }

    @Override
    public String getAndSendBack(MessageData messageData) {
        String message = messageData.getMessage();
        String[] params = message.split(" ");
        if (!params[0].equals("绑定") || params.length<3) {
            return "正确的绑定命令应该为" +
                    "@机器人 绑定 游戏名 游戏类型" +"\n" +
                    "如果您的账号是带有空格的类型 请使用书名号包裹您的id" + "\n" +
                    "进行绑定游戏账号 请注意 游戏类型为比赛类型 分别为 11 22 33 44 对应 1v1 2v2 等 并非帝国时代1234" +
                    "请确保手动@机器人而非复制其他人的@";
        }
        String ageUserName = "";
        if (params.length>3) {
            //带空格的方法 需要加书名号
            ageUserName = message.substring(message.indexOf("《") + 1, message.indexOf("》"));
        }else {
            ageUserName = params[1];
        }
        String matchType = backMatchType(params);
        QqAgeListExample example = new QqAgeListExample();
       example.createCriteria().andAgeNameEqualTo(ageUserName).andGroupIdEqualTo(messageData.getGroupId());
        List<QqAgeList> lists = qqAgeListDao.selectByExample(example);
        QqAgeList defultAgeList = AgeSearchCommand.backDefultAgeList(lists);
        if (lists != null && lists.size()>0) {
            if (lists.get(0).getQqId().equals(messageData.getQqId())){
                if (defultAgeList.getType().equals(matchType)) {
                    return "您已经绑定成功啦 输入查询试试吧";
                }else {
                    defultAgeList.setDefult(0);
                    qqAgeListDao.updateByPrimaryKey(defultAgeList);
                }
            }else {
                return "本机觉得你们两肯定有一个人是内鬼 绑定的游戏名已经被另一位群友绑定啦 现在绑定者qq： "  + lists.get(0).getQqId();
            }
        }

            QqAgeList qqAgeList = new QqAgeList();
            AgeSearchData ageSearchData = new AgeSearchData();
            ageSearchData.setMatchType("unranked");
            ageSearchData.setPage(1);
            ageSearchData.setRegion("7");
            ageSearchData.setVersus("players");
            ageSearchData.setCount(100);
            ageSearchData.setTeamSize(matchType);
            ageSearchData.setSearchPlayer(ageUserName);
            JSONObject jsonObject = AgeSearchApi.searchAgeRank(ageSearchData);
            if (jsonObject != null && jsonObject.get("count")!= null && jsonObject.getInteger("count") >0) {
                JSONArray items  = jsonObject.getJSONArray("items");
                for (Object obj : items) {
                    JSONObject item = JSONObject.parseObject(JSONObject.toJSONString(obj));
                    Integer allTimes = item.getInteger("wins") +  item.getInteger("losses");
                    Integer elo = item.getInteger("elo");
                    String winPercent = item.getString("winPercent");
                    Integer rank = item.getInteger("rank");
                    //判断是否需要保存
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
                    newAgeList.setDefult(1);
                    example.clear();
                    example.createCriteria().andQqIdEqualTo(messageData.getQqId())
                            .andGroupIdEqualTo(messageData.getGroupId())
                            .andTypeEqualTo(matchType);
                    int i = qqAgeListDao.deleteByExample(example);
                    qqAgeListDao.insert(newAgeList);
                    return "绑定成功！";
                }
        }else {
                return "无法查询到该账号的战绩 绑定失败 可能的原因如下" +
                        "您的id输入错误或者识别错误 《"+ ageUserName+ "》" +"\n" +
                        "您未在该类型中打满十场比赛 《" + matchType+" 》" + "\n" +
                        "又或者是您的参数使用方法不正确 请务必确认空格的数量是否正确以及参数是否正确";
            }
            return "绑定失败 未知的原因";



}
public static String backMatchType (String[] params) {
      String rawType =  params[params.length-1];
    switch (rawType) {
        case "22":
            return "2v2";
        case "33":
            return "3v3";
        case "44":
            return "4v4";
        default:
            return "1v1";
    }
}

}

