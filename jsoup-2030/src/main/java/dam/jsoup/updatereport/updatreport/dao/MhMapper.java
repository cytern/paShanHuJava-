package dam.jsoup.updatereport.updatreport.dao;

import dam.jsoup.updatereport.updatreport.pojo.JsoupMissionAllHistory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MhMapper {
    /**
     * 获取一个待执行脚本 安装时间排序 最早的时间优先
     * @return
     */
    JsoupMissionAllHistory getOneWaitToDoTask ();
}
