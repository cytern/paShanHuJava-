package dam.jsoup.updatereport.updatreport.robot.dto;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface QqUserDao {
    long countByExample(QqUserExample example);

    int deleteByExample(QqUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(QqUser record);

    int insertSelective(QqUser record);

    List<QqUser> selectByExample(QqUserExample example);

    QqUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") QqUser record, @Param("example") QqUserExample example);

    int updateByExample(@Param("record") QqUser record, @Param("example") QqUserExample example);

    int updateByPrimaryKeySelective(QqUser record);

    int updateByPrimaryKey(QqUser record);
}