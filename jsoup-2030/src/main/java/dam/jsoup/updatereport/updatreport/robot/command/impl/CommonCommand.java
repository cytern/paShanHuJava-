package dam.jsoup.updatereport.updatreport.robot.command.impl;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import dam.jsoup.updatereport.updatreport.robot.command.CommandReceiver;
import dam.jsoup.updatereport.updatreport.robot.pojo.CommandData;
import dam.jsoup.updatereport.updatreport.robot.pojo.MessageData;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CommonCommand implements CommandReceiver {
    private static final String QYUrl = "http://api.qingyunke.com/api.php";
    private static final String key = "free";
    private static final Integer appId = 0;
    @Override
    public CommandData getAndSendBack(CommandData commandData) {
        CommandData commandData1 = CommandData.newCopyCommandData(commandData);
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("key",key);
        paramMap.put("appid",appId);
        paramMap.put("msg",commandData.getCommand());
        JSONObject body = JSONObject.parseObject(HttpRequest.get(QYUrl).form(paramMap).execute().body());
        String content = body.getString("content");
        if (content != null && !content.equals("")){
          //把换行修改掉
            content = content.replaceAll("\\{br}", "\n");
        }
        commandData1.setMessage(content);
        return commandData1;
    }
}
