package dam.jsoup.updatereport.updatreport.dao;

import dam.jsoup.updatereport.updatreport.pojo.JsoupMissionAllHistory;
import dam.jsoup.updatereport.updatreport.pojo.JsoupMissionAllHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface JsoupMissionAllHistoryMapper {
    long countByExample(JsoupMissionAllHistoryExample example);

    int deleteByExample(JsoupMissionAllHistoryExample example);

    /**
     * delete by primary key
     *
     * @param missionAllHistoryId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer missionAllHistoryId);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(JsoupMissionAllHistory record);

    int insertOrUpdate(JsoupMissionAllHistory record);

    int insertOrUpdateSelective(JsoupMissionAllHistory record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(JsoupMissionAllHistory record);

    List<JsoupMissionAllHistory> selectByExample(JsoupMissionAllHistoryExample example);

    /**
     * select by primary key
     *
     * @param missionAllHistoryId primary key
     * @return object by primary key
     */
    JsoupMissionAllHistory selectByPrimaryKey(Integer missionAllHistoryId);

    int updateByExampleSelective(@Param("record") JsoupMissionAllHistory record, @Param("example") JsoupMissionAllHistoryExample example);

    int updateByExample(@Param("record") JsoupMissionAllHistory record, @Param("example") JsoupMissionAllHistoryExample example);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(JsoupMissionAllHistory record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(JsoupMissionAllHistory record);

    int updateBatch(List<JsoupMissionAllHistory> list);

    int batchInsert(@Param("list") List<JsoupMissionAllHistory> list);
}