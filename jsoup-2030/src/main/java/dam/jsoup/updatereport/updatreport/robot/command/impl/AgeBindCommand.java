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
import dam.jsoup.updatereport.updatreport.robot.pojo.MessageData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Slf4j
@Service
public class AgeBindCommand implements CommandReceiver {
    private final QqAgeListDao qqAgeListDao;

    public AgeBindCommand(QqAgeListDao qqAgeListDao) {
        this.qqAgeListDao = qqAgeListDao;
    }

    @Override
    public CommandData getAndSendBack(CommandData commandData) {
        CommandData returnCommandData = CommandData.newCopyCommandData(commandData);
        String message = commandData.getMessage();
        String[] params = message.split(" ");
        //到这里的肯定都是绑定的命令
        String ageUserName = "";
        if (params.length>3) {
            //带空格的方法 需要加书名号
            ageUserName = message.substring(message.indexOf("《") + 1, message.indexOf("》"));
        }else {
            ageUserName = params[1];
        }
        String matchType = null;
        try {
            matchType = backMatchType(params);
        } catch (Exception e) {
            return returnCommandData.backMessage(e.getMessage());
        }
        QqAgeListExample example = new QqAgeListExample();
       example.createCriteria().andAgeNameEqualTo(ageUserName).andGroupIdEqualTo(commandData.getGroupId());
        List<QqAgeList> lists = qqAgeListDao.selectByExample(example);
        QqAgeList defultAgeList = AgeSearchCommand.backDefultAgeList(lists);
        if (lists != null && lists.size()>0) {
            if (lists.get(0).getQqId().equals(commandData.getQqId())){
                if (defultAgeList.getType().equals(matchType)) {
                    return returnCommandData.backMessage("咩咩？...已经有一个完全相同的的绑定信息啦  输入\n@查分机器人 查分 \n快捷查询吧~");
                }else {
                    defultAgeList.setDefult(0);
                    qqAgeListDao.updateByPrimaryKey(defultAgeList);
                }
            }else {
                return returnCommandData.backMessage("咩？内鬼! 绑定的游戏名已经被另一位群友绑定啦 现在绑定者qq： "  + lists.get(0).getQqId());
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
                    newAgeList.setQqId(commandData.getQqId());
                    newAgeList.setGroupId(commandData.getGroupId());
                    newAgeList.setDefult(1);
                    example.clear();
                    example.createCriteria().andQqIdEqualTo(commandData.getQqId())
                            .andGroupIdEqualTo(commandData.getGroupId())
                            .andTypeEqualTo(matchType);
                    int i = qqAgeListDao.deleteByExample(example);
                    qqAgeListDao.insert(newAgeList);
                    return returnCommandData.backMessage("绑定成功~");
                }
        }else {
                return returnCommandData.backMessage( "无法查询到该账号的战绩 绑定失败 可能的原因如下" +
                        "您的id输入错误或者识别错误 《"+ ageUserName+ "》" +"\n" +
                        "您未在该类型中打满十场比赛 《" + matchType+" 》" + "\n" +
                        "又或者是您的参数使用方法不正确 请务必确认空格的数量是否正确以及参数是否正确 例句：\n" +
                        "@查分机器人 绑定 咩咩机器人 11\n" +
                        "@查分机器人 绑定 咩咩机器人 11\n"+
                        "@查分机器人 绑定 《我 超 勇 的》 11\n");
            }
            return returnCommandData.backMessage("绑定失败~未知的原因");



}
public static String backMatchType (String[] params) {
      String rawType =  params[params.length-1];
      if (rawType.contains("帝国时代4")) {
          throw new RuntimeException("正确示例:\n" +
                  "@查分机器人 绑定 守好你的塔 11\n" +
                  "@查分机器人 查分 什么小蛋挞 11");
      }
    switch (rawType) {
        case "22":
            return "2v2";
        case "33":
            return "3v3";
        case "44":
            return "4v4";
        case "1v1":
        case "2v2":
        case "3v3":
        case "4v4":
            return rawType;
        default:
            return "1v1";

    }
}

}

