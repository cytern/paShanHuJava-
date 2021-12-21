package dam.jsoup.updatereport.updatreport.robot.dto;


import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QqTimeTaskDao {
    long countByExample(QqTimeTaskExample example);

    int deleteByExample(QqTimeTaskExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(QqTimeTask record);

    int insertSelective(QqTimeTask record);

    List<QqTimeTask> selectByExample(QqTimeTaskExample example);

    QqTimeTask selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") QqTimeTask record, @Param("example") QqTimeTaskExample example);

    int updateByExample(@Param("record") QqTimeTask record, @Param("example") QqTimeTaskExample example);

    int updateByPrimaryKeySelective(QqTimeTask record);

    int updateByPrimaryKey(QqTimeTask record);
}