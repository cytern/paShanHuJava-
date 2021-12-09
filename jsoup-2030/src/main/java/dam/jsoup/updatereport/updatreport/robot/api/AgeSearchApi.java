package dam.jsoup.updatereport.updatreport.robot.api;

import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import dam.jsoup.updatereport.updatreport.robot.pojo.AgeSearchData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AgeSearchApi {
    private static final String url = "https://api.ageofempires.com/api/ageiv/Leaderboard";

    public static JSONObject searchAgeRank(AgeSearchData ageSearchData) {
        log.info("查询帝国时代4 排位分 接口 参数 {}",JSONObject.toJSONString(ageSearchData));
        String body = HttpRequest.post(url)
                .header(Header.CONTENT_TYPE, "application/json")
                .body(JSONObject.toJSONString(ageSearchData))
                .execute()
                .body();
        log.info("查询帝国排位分 接口 返回值 {}",body);
        return JSON.parseObject(body);
    }
}
