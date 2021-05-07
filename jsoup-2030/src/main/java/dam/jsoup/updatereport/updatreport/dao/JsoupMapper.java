package dam.jsoup.updatereport.updatreport.dao;

import dam.jsoup.updatereport.updatreport.pojo.JsoupPragram;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : dam
 * @description :
 * @create :2021-04-27 14:49:00
 */
@Mapper
@Repository
public interface JsoupMapper {


    List<JsoupPragram> getAllPragramBymaId(@Param("maId") Integer maId);

    List<JsoupPragram> getAllPragramByMhId(@Param("mhId")Integer mhId);
}
