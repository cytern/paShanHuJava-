package dam.jsoup.updatereport.updatreport.dao;

import dam.jsoup.updatereport.updatreport.pojo.JsoupPragram;
import dam.jsoup.updatereport.updatreport.pojo.JsoupPragramExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface JsoupPragramMapper {
    long countByExample(JsoupPragramExample example);

    int deleteByExample(JsoupPragramExample example);

    /**
     * delete by primary key
     *
     * @param pragramId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer pragramId);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(JsoupPragram record);

    int insertOrUpdate(JsoupPragram record);

    int insertOrUpdateSelective(JsoupPragram record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(JsoupPragram record);

    List<JsoupPragram> selectByExample(JsoupPragramExample example);

    /**
     * select by primary key
     *
     * @param pragramId primary key
     * @return object by primary key
     */
    JsoupPragram selectByPrimaryKey(Integer pragramId);

    int updateByExampleSelective(@Param("record") JsoupPragram record, @Param("example") JsoupPragramExample example);

    int updateByExample(@Param("record") JsoupPragram record, @Param("example") JsoupPragramExample example);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(JsoupPragram record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(JsoupPragram record);

    int updateBatch(List<JsoupPragram> list);

    int batchInsert(@Param("list") List<JsoupPragram> list);

    int updateBatchSelective(List<JsoupPragram> list);
}