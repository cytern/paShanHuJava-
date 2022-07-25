package dam.jsoup.updatereport.updatreport.robot.mapper;

import dam.jsoup.updatereport.updatreport.robot.dto.QqItem;
import org.springframework.stereotype.Repository;

@Repository
public interface QqItemDao {
    int deleteByPrimaryKey(Integer id);

    int insert(QqItem record);

    int insertSelective(QqItem record);

    QqItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QqItem record);

    int updateByPrimaryKey(QqItem record);
}