package dam.jsoup.updatereport.updatreport.dao;

import dam.jsoup.updatereport.updatreport.pojo.JsoupAction;
import dam.jsoup.updatereport.updatreport.pojo.JsoupActionExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface JsoupActionMapper {
    long countByExample(JsoupActionExample example);

    int deleteByExample(JsoupActionExample example);

    /**
     * delete by primary key
     *
     * @param actionId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer actionId);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(JsoupAction record);

    int insertOrUpdate(JsoupAction record);

    int insertOrUpdateSelective(JsoupAction record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(JsoupAction record);

    List<JsoupAction> selectByExample(JsoupActionExample example);

    /**
     * select by primary key
     *
     * @param actionId primary key
     * @return object by primary key
     */
    JsoupAction selectByPrimaryKey(Integer actionId);

    int updateByExampleSelective(@Param("record") JsoupAction record, @Param("example") JsoupActionExample example);

    int updateByExample(@Param("record") JsoupAction record, @Param("example") JsoupActionExample example);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(JsoupAction record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(JsoupAction record);

    int updateBatch(List<JsoupAction> list);

    int batchInsert(@Param("list") List<JsoupAction> list);

    int updateBatchSelective(List<JsoupAction> list);

    int deleteByMissionId(Integer missionId);
}