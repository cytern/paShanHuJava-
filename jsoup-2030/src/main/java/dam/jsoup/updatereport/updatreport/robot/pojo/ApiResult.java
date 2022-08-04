package dam.jsoup.updatereport.updatreport.robot.pojo;

import com.alibaba.fastjson.JSONObject;
import io.swagger.models.auth.In;
import lombok.Data;

@Data
public class ApiResult {
    private Integer code;
    private String message;
    private JSONObject data;

    public static JSONObject success(JSONObject data) {
        ApiResult apiResult = new ApiResult();
        apiResult.setCode(200);
        apiResult.setMessage("成功");
        apiResult.setData(data);
        return JSONObject.parseObject(JSONObject.toJSONString(apiResult));
    }
    public static JSONObject success(String msg) {
        ApiResult apiResult = new ApiResult();
        apiResult.setCode(200);
        apiResult.setMessage(msg);
        return JSONObject.parseObject(JSONObject.toJSONString(apiResult));
    }
    public static JSONObject success() {
        ApiResult apiResult = new ApiResult();
        apiResult.setCode(200);
        apiResult.setMessage("成功");
        return JSONObject.parseObject(JSONObject.toJSONString(apiResult));
    }

    public static JSONObject fail(String msg) {
        ApiResult apiResult = new ApiResult();
        apiResult.setCode(400);
        apiResult.setMessage(msg);
        return JSONObject.parseObject(JSONObject.toJSONString(apiResult));
    }


    public static JSONObject fail(String msg,Integer code) {
        ApiResult apiResult = new ApiResult();
        apiResult.setCode(code);
        apiResult.setMessage(msg);
        return JSONObject.parseObject(JSONObject.toJSONString(apiResult));
    }




}
