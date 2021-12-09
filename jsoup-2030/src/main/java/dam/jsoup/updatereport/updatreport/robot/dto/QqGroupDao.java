package dam.jsoup.updatereport.updatreport.robot.dto;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface QqGroupDao {
    long countByExample(QqGroupExample example);

    int deleteByExample(QqGroupExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(QqGroup record);

    int insertSelective(QqGroup record);

    List<QqGroup> selectByExample(QqGroupExample example);

    QqGroup selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") QqGroup record, @Param("example") QqGroupExample example);

    int updateByExample(@Param("record") QqGroup record, @Param("example") QqGroupExample example);

    int updateByPrimaryKeySelective(QqGroup record);

    int updateByPrimaryKey(QqGroup record);
}