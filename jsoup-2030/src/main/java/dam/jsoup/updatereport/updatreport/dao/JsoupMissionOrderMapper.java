package dam.jsoup.updatereport.updatreport.dao;

import dam.jsoup.updatereport.updatreport.pojo.JsoupMissionOrder;
import dam.jsoup.updatereport.updatreport.pojo.JsoupMissionOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface JsoupMissionOrderMapper {
    long countByExample(JsoupMissionOrderExample example);

    int deleteByExample(JsoupMissionOrderExample example);

    /**
     * delete by primary key
     *
     * @param missionOrderId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer missionOrderId);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(JsoupMissionOrder record);

    int insertOrUpdate(JsoupMissionOrder record);

    int insertOrUpdateSelective(JsoupMissionOrder record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(JsoupMissionOrder record);

    List<JsoupMissionOrder> selectByExample(JsoupMissionOrderExample example);

    /**
     * select by primary key
     *
     * @param missionOrderId primary key
     * @return object by primary key
     */
    JsoupMissionOrder selectByPrimaryKey(Integer missionOrderId);

    int updateByExampleSelective(@Param("record") JsoupMissionOrder record, @Param("example") JsoupMissionOrderExample example);

    int updateByExample(@Param("record") JsoupMissionOrder record, @Param("example") JsoupMissionOrderExample example);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(JsoupMissionOrder record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(JsoupMissionOrder record);

    int updateBatch(List<JsoupMissionOrder> list);

    int batchInsert(@Param("list") List<JsoupMissionOrder> list);

    int updateBatchSelective(List<JsoupMissionOrder> list);
}