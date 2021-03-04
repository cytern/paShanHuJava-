package dam.jsoup.updatereport.updatreport.dao;

import dam.jsoup.updatereport.updatreport.pojo.JsoupActionOrder;
import dam.jsoup.updatereport.updatreport.pojo.JsoupActionOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface JsoupActionOrderMapper {
    long countByExample(JsoupActionOrderExample example);

    int deleteByExample(JsoupActionOrderExample example);

    /**
     * delete by primary key
     * @param actionOrderId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer actionOrderId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(JsoupActionOrder record);

    int insertOrUpdate(JsoupActionOrder record);

    int insertOrUpdateSelective(JsoupActionOrder record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(JsoupActionOrder record);

    List<JsoupActionOrder> selectByExample(JsoupActionOrderExample example);

    /**
     * select by primary key
     * @param actionOrderId primary key
     * @return object by primary key
     */
    JsoupActionOrder selectByPrimaryKey(Integer actionOrderId);

    int updateByExampleSelective(@Param("record") JsoupActionOrder record, @Param("example") JsoupActionOrderExample example);

    int updateByExample(@Param("record") JsoupActionOrder record, @Param("example") JsoupActionOrderExample example);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(JsoupActionOrder record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(JsoupActionOrder record);

    int updateBatch(List<JsoupActionOrder> list);

    int batchInsert(@Param("list") List<JsoupActionOrder> list);
}