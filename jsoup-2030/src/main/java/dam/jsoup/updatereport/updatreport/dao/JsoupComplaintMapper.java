package dam.jsoup.updatereport.updatreport.dao;

import dam.jsoup.updatereport.updatreport.pojo.JsoupComplaint;
import dam.jsoup.updatereport.updatreport.pojo.JsoupComplaintExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface JsoupComplaintMapper {
    long countByExample(JsoupComplaintExample example);

    int deleteByExample(JsoupComplaintExample example);

    /**
     * delete by primary key
     *
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(JsoupComplaint record);

    int insertOrUpdate(JsoupComplaint record);

    int insertOrUpdateSelective(JsoupComplaint record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(JsoupComplaint record);

    List<JsoupComplaint> selectByExample(JsoupComplaintExample example);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    JsoupComplaint selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") JsoupComplaint record, @Param("example") JsoupComplaintExample example);

    int updateByExample(@Param("record") JsoupComplaint record, @Param("example") JsoupComplaintExample example);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(JsoupComplaint record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(JsoupComplaint record);

    int updateBatch(List<JsoupComplaint> list);

    int batchInsert(@Param("list") List<JsoupComplaint> list);
}