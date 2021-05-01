package dam.jsoup.updatereport.updatreport.util;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 分页类 代码分页
 */
@Data
public class PageHelper {
    private int start;
    private int end;
    private int index;
    private int pageSize;

    public PageHelper(int index, int pageSize) {
        this.start = (index-1)*pageSize;
        this.end = index*pageSize;
        this.index = index;
        this.pageSize = pageSize;
    }

    /**
     * 分页工具
     * @param list
     * @param pageSize
     * @param index
     * @param mapName
     * @return
     */
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
