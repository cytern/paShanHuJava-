package dam.jsoup.updatereport.updatreport.dao;

import dam.jsoup.updatereport.updatreport.pojo.JsoupMissionAllHistory;
import dam.jsoup.updatereport.updatreport.vo.CommentVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface HandMapper {
    /**
     * 获取一个待执行脚本 安装时间排序 最早的时间优先
     * @return
     */
    JsoupMissionAllHistory getOneWaitToDoTask ();

    /**
     * 获取脚本的评价列表
     * @param maId id
     * @param pre 上限
     * @param last 下限
     * @return 评价
     */
    List<CommentVo> getMaComment(@Param("maId") Integer maId,@Param("pre") Integer pre,@Param("last") Integer last);

    /**
     * 获取数据的评价列表
     * @param maId  id
     * @param pre 上限
     * @param last 下限
     * @return 评价
     */
    List<CommentVo> getMhComment(@Param("maId") Integer maId,@Param("pre") Integer pre,@Param("last") Integer last);

}
