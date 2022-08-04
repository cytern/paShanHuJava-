package dam.jsoup.updatereport.updatreport.robot.mapper;

import com.alibaba.fastjson.JSONObject;
import dam.jsoup.updatereport.updatreport.robot.dto.QqUserItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface QqUserItemDao {
    int deleteByPrimaryKey(Integer id);

    int insert(QqUserItem record);

    int insertSelective(QqUserItem record);

    QqUserItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QqUserItem record);

    int updateByPrimaryKey(QqUserItem record);

    /**
     * 获取用户的全部物品
     */
    List<JSONObject> getUsersAllItem(@Param("params") JSONObject params);

    int insertOrUpdateQqUserItem (@Param("list") List<JSONObject> list);

    int insertAllQqItem (@Param("list") List<JSONObject> list);

    int deleteQqItemByRobotCode(@Param("robotCode")  String robotCode);


    int insertAllItem(@Param("list")  List<JSONObject> list);

    JSONObject selectByNameRobotCodeAnd(@Param("params")JSONObject params);
}