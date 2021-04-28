package dam.jsoup.updatereport.updatreport.dao;

import dam.jsoup.updatereport.updatreport.pojo.JsoupArticle;
import dam.jsoup.updatereport.updatreport.pojo.JsoupArticleExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface JsoupArticleMapper {
    long countByExample(JsoupArticleExample example);

    int deleteByExample(JsoupArticleExample example);

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
    int insert(JsoupArticle record);

    int insertOrUpdate(JsoupArticle record);

    int insertOrUpdateSelective(JsoupArticle record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(JsoupArticle record);

    List<JsoupArticle> selectByExample(JsoupArticleExample example);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    JsoupArticle selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") JsoupArticle record, @Param("example") JsoupArticleExample example);

    int updateByExample(@Param("record") JsoupArticle record, @Param("example") JsoupArticleExample example);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(JsoupArticle record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(JsoupArticle record);

    int updateBatch(List<JsoupArticle> list);

    int batchInsert(@Param("list") List<JsoupArticle> list);
}