package dam.jsoup.updatereport.updatreport.dao;

import dam.jsoup.updatereport.updatreport.pojo.JsoupMissionAll;
import dam.jsoup.updatereport.updatreport.pojo.JsoupMissionAllExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface JsoupMissionAllMapper {
    long countByExample(JsoupMissionAllExample example);

    int deleteByExample(JsoupMissionAllExample example);

    /**
     * delete by primary key
     *
     * @param maId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer maId);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(JsoupMissionAll record);

    int insertOrUpdate(JsoupMissionAll record);

    int insertOrUpdateSelective(JsoupMissionAll record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(JsoupMissionAll record);

    List<JsoupMissionAll> selectByExample(JsoupMissionAllExample example);

    /**
     * select by primary key
     *
     * @param maId primary key
     * @return object by primary key
     */
    JsoupMissionAll selectByPrimaryKey(Integer maId);

    int updateByExampleSelective(@Param("record") JsoupMissionAll record, @Param("example") JsoupMissionAllExample example);

    int updateByExample(@Param("record") JsoupMissionAll record, @Param("example") JsoupMissionAllExample example);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(JsoupMissionAll record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(JsoupMissionAll record);

    int updateBatch(List<JsoupMissionAll> list);

    int batchInsert(@Param("list") List<JsoupMissionAll> list);

    int updateBatchSelective(List<JsoupMissionAll> list);
}