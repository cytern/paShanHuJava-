package dam.jsoup.updatereport.updatreport.robot.mapper;

import dam.jsoup.updatereport.updatreport.robot.dto.QqKeyEdit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface QqKeyEditDao {
    int deleteByPrimaryKey(Integer id);

    int insert(QqKeyEdit record);

    int insertSelective(QqKeyEdit record);

    QqKeyEdit selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QqKeyEdit record);

    int updateByPrimaryKey(QqKeyEdit record);

    int save(QqKeyEdit record);

    QqKeyEdit selectKeyIdType (@Param("qqKey") QqKeyEdit qqKeyEdit);
}