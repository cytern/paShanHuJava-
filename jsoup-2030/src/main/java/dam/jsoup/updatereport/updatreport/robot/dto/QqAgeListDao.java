package dam.jsoup.updatereport.updatreport.robot.dto;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface QqAgeListDao {
    long countByExample(QqAgeListExample example);

    int deleteByExample(QqAgeListExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(QqAgeList record);

    int insertSelective(QqAgeList record);

    List<QqAgeList> selectByExample(QqAgeListExample example);

    QqAgeList selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") QqAgeList record, @Param("example") QqAgeListExample example);

    int updateByExample(@Param("record") QqAgeList record, @Param("example") QqAgeListExample example);

    int updateByPrimaryKeySelective(QqAgeList record);

    int updateByPrimaryKey(QqAgeList record);
}