package dam.jsoup.updatereport.updatreport.dao;

import dam.jsoup.updatereport.updatreport.pojo.JsoupExcutor;
import dam.jsoup.updatereport.updatreport.pojo.JsoupExcutorExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface JsoupExcutorMapper {
    long countByExample(JsoupExcutorExample example);

    int deleteByExample(JsoupExcutorExample example);

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
    int insert(JsoupExcutor record);

    int insertOrUpdate(JsoupExcutor record);

    int insertOrUpdateSelective(JsoupExcutor record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(JsoupExcutor record);

    List<JsoupExcutor> selectByExample(JsoupExcutorExample example);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    JsoupExcutor selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") JsoupExcutor record, @Param("example") JsoupExcutorExample example);

    int updateByExample(@Param("record") JsoupExcutor record, @Param("example") JsoupExcutorExample example);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(JsoupExcutor record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(JsoupExcutor record);

    int updateBatch(List<JsoupExcutor> list);

    int batchInsert(@Param("list") List<JsoupExcutor> list);
}