package dam.jsoup.updatereport.updatreport.dao;

import dam.jsoup.updatereport.updatreport.pojo.JsoupComment;
import dam.jsoup.updatereport.updatreport.pojo.JsoupCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface JsoupCommentMapper {
    long countByExample(JsoupCommentExample example);

    int deleteByExample(JsoupCommentExample example);

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
    int insert(JsoupComment record);

    int insertOrUpdate(JsoupComment record);

    int insertOrUpdateSelective(JsoupComment record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(JsoupComment record);

    List<JsoupComment> selectByExample(JsoupCommentExample example);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    JsoupComment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") JsoupComment record, @Param("example") JsoupCommentExample example);

    int updateByExample(@Param("record") JsoupComment record, @Param("example") JsoupCommentExample example);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(JsoupComment record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(JsoupComment record);

    int updateBatch(List<JsoupComment> list);

    int batchInsert(@Param("list") List<JsoupComment> list);
}