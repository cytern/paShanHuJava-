package dam.server.demo.utils;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import dam.server.demo.pojo.ResultVO;
import dam.server.demo.vo.HttpMissionDataVo;
import dam.server.demo.vo.MissionAllData;
import org.springframework.http.*;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpUtils {
    public static HttpMissionDataVo getDataApi(String url, MultiValueMap<String, String> params) throws Exception {
        RestTemplate client = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        HttpMethod method = HttpMethod.POST;
        // 以表单的方式提交
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        //将请求头部和参数合成一个请求
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, headers);
        //执行HTTP请求，将返回的结构使用ResultVO类格式化
        ResponseEntity<String> response = client.exchange(url, method, requestEntity, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        HttpMissionDataVo missionAllData = null;
        String strBody;
        if(response.getStatusCodeValue()==200){    //判断返回的状态码
            strBody=response.getBody();
        }else {
            throw new Exception("网络请求失败 状态码异常");
        }
        try {
           missionAllData = objectMapper.readValue(strBody,HttpMissionDataVo.class);
        }catch (Exception e
        ){
            e.printStackTrace();
            throw new Exception(e);
        }
        if (missionAllData == null){
            throw new Exception("无效的数据");
        }


        return missionAllData;
    }



    public static boolean sendDataApi(String url, HttpMissionDataVo httpMissionDataVo) {
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(httpMissionDataVo);
        RestTemplate client = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        HttpMethod method = HttpMethod.POST;
        // 以表单的方式提交
        headers.setContentType(MediaType.APPLICATION_JSON);
        //将请求头部和参数合成一个请求
        HttpEntity requestEntity = new HttpEntity<>(jsonObject, headers);
        //执行HTTP请求，将返回的结构使用ResultVO类格式化
        ResponseEntity<String> response = client.exchange(url, method, requestEntity, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        String strBody;
        if(response.getStatusCodeValue()==200){    //判断返回的状态码
           return true;
        }else {
          return false;
        }
    }
}
