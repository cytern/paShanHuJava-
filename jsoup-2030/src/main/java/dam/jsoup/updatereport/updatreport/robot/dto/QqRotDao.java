package dam.jsoup.updatereport.updatreport.robot.dto;


import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QqRotDao {
    long countByExample(QqRotExample example);

    int deleteByExample(QqRotExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(QqRot record);

    int insertSelective(QqRot record);

    List<QqRot> selectByExample(QqRotExample example);

    QqRot selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") QqRot record, @Param("example") QqRotExample example);

    int updateByExample(@Param("record") QqRot record, @Param("example") QqRotExample example);

    int updateByPrimaryKeySelective(QqRot record);

    int updateByPrimaryKey(QqRot record);
}