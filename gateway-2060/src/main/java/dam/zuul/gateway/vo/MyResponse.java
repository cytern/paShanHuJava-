package dam.zuul.gateway.vo;

import java.util.HashMap;
import java.util.Map;

public class MyResponse {
    public static Map<String, Object> myResponseOk(Map<String, Object> map) {
        map.put("code","success");
        return map;
    }

    public static Map<String, Object> myResponseError(Map<String, Object> map) {
        map.put("code","error");
        return map;
    }
    public static Map<String, Object> myResponseOk(Map<String, Object> map, String msg) {
        map.put("code","success");
        map.put("msg",msg);
        return map;
    }

    public static Map<String, Object> myResponseError(Map<String, Object> map, String msg) {
        map.put("code","error");
        map.put("msg",msg);
        return map;
    }
    public static Map<String, Object> myResponseOk( String msg) {
        Map map = new HashMap();
        map.put("code","success");
        map.put("msg",msg);
        return map;
    }

    public static Map<String, Object> myResponseError( String msg) {
        Map map = new HashMap();
        map.put("code","error");
        map.put("msg",msg);
        return map;
    }

}
