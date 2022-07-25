package dam.jsoup.updatereport.updatreport.robot.mapper;

import com.alibaba.fastjson.JSONObject;
import dam.jsoup.updatereport.updatreport.robot.dto.QqUserItem;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
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

    int insertOrUpdateQqUserItem (@Param("itemList") List<JSONObject> itemList);

    int insertAllQqItem (@Param("list") List<JSONObject> itemList);
}