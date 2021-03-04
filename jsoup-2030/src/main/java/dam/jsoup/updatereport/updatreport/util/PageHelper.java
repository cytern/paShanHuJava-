package dam.jsoup.updatereport.updatreport.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 分页类 代码分页
 */
public class PageHelper {
    public static Map page (List list, Integer pageSize, Integer index,String mapName) {
        Map<String,Object> map = MyResponse.myResponseOk("查询成功");
        if (list == null || list.size() < 1){
            map.put("pageNum",0);
            map.put(mapName,new ArrayList<>());
            return map;
        }else {
            map.put("pageNum", list.size());
            map.put(mapName,list.subList((index-1)*pageSize, Math.min(index * pageSize, list.size())));
            return map;
        }
    }
}
