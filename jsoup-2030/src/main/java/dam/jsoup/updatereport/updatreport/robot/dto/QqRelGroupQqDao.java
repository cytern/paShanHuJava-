package dam.jsoup.updatereport.updatreport.robot.dto;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface QqRelGroupQqDao {
    long countByExample(QqRelGroupQqExample example);

    int deleteByExample(QqRelGroupQqExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(QqRelGroupQq record);

    int insertSelective(QqRelGroupQq record);

    List<QqRelGroupQq> selectByExample(QqRelGroupQqExample example);

    QqRelGroupQq selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") QqRelGroupQq record, @Param("example") QqRelGroupQqExample example);

    int updateByExample(@Param("record") QqRelGroupQq record, @Param("example") QqRelGroupQqExample example);

    int updateByPrimaryKeySelective(QqRelGroupQq record);

    int updateByPrimaryKey(QqRelGroupQq record);
}