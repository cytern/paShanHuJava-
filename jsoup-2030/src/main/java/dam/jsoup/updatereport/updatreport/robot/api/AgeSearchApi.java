package dam.jsoup.updatereport.updatreport.robot.api;

import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import dam.jsoup.updatereport.updatreport.robot.pojo.AgeSearchData;
import org.springframework.stereotype.Service;

@Service
public class AgeSearchApi {
    private static final String url = "https://api.ageofempires.com/api/ageiv/Leaderboard";

    public static JSONObject searchAgeRank(AgeSearchData ageSearchData) {
        String body = HttpRequest.post(url)
                .header(Header.CONTENT_TYPE, "application/json")
                .body(JSONObject.toJSONString(ageSearchData))
                .execute()
                .body();
        return JSON.parseObject(body);
    }
}
