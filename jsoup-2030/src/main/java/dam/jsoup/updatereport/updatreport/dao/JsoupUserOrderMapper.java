package dam.jsoup.updatereport.updatreport.dao;

import dam.jsoup.updatereport.updatreport.pojo.JsoupUserOrder;
import dam.jsoup.updatereport.updatreport.pojo.JsoupUserOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface JsoupUserOrderMapper {
    long countByExample(JsoupUserOrderExample example);

    int deleteByExample(JsoupUserOrderExample example);

    /**
     * delete by primary key
     *
     * @param orderId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer orderId);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(JsoupUserOrder record);

    int insertOrUpdate(JsoupUserOrder record);

    int insertOrUpdateSelective(JsoupUserOrder record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(JsoupUserOrder record);

    List<JsoupUserOrder> selectByExample(JsoupUserOrderExample example);

    /**
     * select by primary key
     *
     * @param orderId primary key
     * @return object by primary key
     */
    JsoupUserOrder selectByPrimaryKey(Integer orderId);

    int updateByExampleSelective(@Param("record") JsoupUserOrder record, @Param("example") JsoupUserOrderExample example);

    int updateByExample(@Param("record") JsoupUserOrder record, @Param("example") JsoupUserOrderExample example);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(JsoupUserOrder record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(JsoupUserOrder record);

    int updateBatch(List<JsoupUserOrder> list);

    int batchInsert(@Param("list") List<JsoupUserOrder> list);
}