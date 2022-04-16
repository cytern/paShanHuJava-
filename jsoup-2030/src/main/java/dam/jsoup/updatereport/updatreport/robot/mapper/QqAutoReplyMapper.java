package dam.jsoup.updatereport.updatreport.robot.mapper;


import dam.jsoup.updatereport.updatreport.robot.pojo.QqAutoReply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @author 24771
* @description 针对表【qq_auto_reply】的数据库操作Mapper
* @createDate 2022-04-16 11:26:21
* @Entity generate.domain.QqAutoReply
*/
@Mapper
@Repository
public interface QqAutoReplyMapper{
    /**
     * 查询一个rely
     */
    List<QqAutoReply> selectOneByParams (@Param("key") String key);
}




