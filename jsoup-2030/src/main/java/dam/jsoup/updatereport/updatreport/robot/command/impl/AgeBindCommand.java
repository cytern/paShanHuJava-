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
            return "正确的命令应该为  绑定 游戏名 游戏类型";
        }
        String ageUserName = "";
        if (params.length>3) {
            //带空格的方法 需要加书名号
            ageUserName = message.substring(message.indexOf("《") + 1, message.indexOf("》"));
        }else {
            ageUserName = params[1];
        }
        QqAgeListExample example = new QqAgeListExample();
       example.createCriteria().andAgeNameEqualTo(ageUserName).andGroupIdEqualTo(messageData.getGroupId());
        List<QqAgeList> lists = qqAgeListDao.selectByExample(example);
        if (lists != null) {
            if (lists.get(0).getQqId().equals(messageData.getQqId())){
                return "已经绑定成功啦 输入 查询 试试吧";
            }else {
                return "本机觉得你们两肯定有一个人是内鬼 绑定的游戏名已经被另一位群友绑定啦 现在绑定者qq： "  + lists.get(0).getQqId();
            }
        }else {
            QqAgeList qqAgeList = new QqAgeList();
            AgeSearchData ageSearchData = new AgeSearchData();
            ageSearchData.setMatchType("unranked");
            ageSearchData.setPage(1);
            ageSearchData.setRegion("7");
            ageSearchData.setVersus("players");
            ageSearchData.setCount(100);
            ageSearchData.setTeamSize(params[params.length-1]);
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
                    newAgeList.setType(params[params.length-1]);
                    newAgeList.setMatchTimes(allTimes);
                    newAgeList.setQqId(messageData.getQqId());
                    newAgeList.setGroupId(messageData.getGroupId());
                    newAgeList.setDefult(1);
                    example.clear();
                    example.createCriteria().andQqIdEqualTo(messageData.getQqId())
                            .andGroupIdEqualTo(messageData.getGroupId())
                            .andDefultEqualTo(1);
                    int i = qqAgeListDao.deleteByExample(example);
                    qqAgeListDao.insert(newAgeList);
                    return "绑定的账号";
                }
        }else {
                return "无效的账号";
            }
            return "失败";
    }
}}
