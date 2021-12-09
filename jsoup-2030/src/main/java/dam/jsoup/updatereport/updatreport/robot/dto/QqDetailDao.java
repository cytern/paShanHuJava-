package dam.jsoup.updatereport.updatreport.robot.dto;


import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface QqDetailDao {
    JSONObject getAgeDataByQQIdAndType(@Param("qqId") String qqId,@Param("type")Integer type);

    JSONObject getAgeDataDefultQQ(@Param("qqId") String qqId);

    List<JSONObject> getAgeDataByQQId(String qqId);

    int addAgeDataQQ(QqAgeList qqAgeList);

    long countByExample(QqDetailExample example);

    int deleteByExample(QqDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(QqDetail record);

    int insertSelective(QqDetail record);

    List<QqDetail> selectByExample(QqDetailExample example);

    QqDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") QqDetail record, @Param("example") QqDetailExample example);

    int updateByExample(@Param("record") QqDetail record, @Param("example") QqDetailExample example);

    int updateByPrimaryKeySelective(QqDetail record);

    int updateByPrimaryKey(QqDetail record);


}