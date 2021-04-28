package dam.jsoup.updatereport.updatreport.dao;

import dam.jsoup.updatereport.updatreport.pojo.JsoupUpDown;
import dam.jsoup.updatereport.updatreport.pojo.JsoupUpDownExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface JsoupUpDownMapper {
    long countByExample(JsoupUpDownExample example);

    int deleteByExample(JsoupUpDownExample example);

    /**
     * delete by primary key
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(JsoupUpDown record);

    int insertOrUpdate(JsoupUpDown record);

    int insertOrUpdateSelective(JsoupUpDown record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(JsoupUpDown record);

    List<JsoupUpDown> selectByExample(JsoupUpDownExample example);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    JsoupUpDown selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") JsoupUpDown record, @Param("example") JsoupUpDownExample example);

    int updateByExample(@Param("record") JsoupUpDown record, @Param("example") JsoupUpDownExample example);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(JsoupUpDown record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(JsoupUpDown record);

    int updateBatch(List<JsoupUpDown> list);

    int batchInsert(@Param("list") List<JsoupUpDown> list);
}