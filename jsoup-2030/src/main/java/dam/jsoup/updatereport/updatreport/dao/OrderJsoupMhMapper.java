package dam.jsoup.updatereport.updatreport.dao;

import dam.jsoup.updatereport.updatreport.pojo.OrderJsoupMh;
import dam.jsoup.updatereport.updatreport.pojo.OrderJsoupMhExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderJsoupMhMapper {
    long countByExample(OrderJsoupMhExample example);

    int deleteByExample(OrderJsoupMhExample example);

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
    int insert(OrderJsoupMh record);

    int insertOrUpdate(OrderJsoupMh record);

    int insertOrUpdateSelective(OrderJsoupMh record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(OrderJsoupMh record);

    List<OrderJsoupMh> selectByExample(OrderJsoupMhExample example);

    /**
     * select by primary key
     *
     * @param orderId primary key
     * @return object by primary key
     */
    OrderJsoupMh selectByPrimaryKey(Integer orderId);

    int updateByExampleSelective(@Param("record") OrderJsoupMh record, @Param("example") OrderJsoupMhExample example);

    int updateByExample(@Param("record") OrderJsoupMh record, @Param("example") OrderJsoupMhExample example);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(OrderJsoupMh record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(OrderJsoupMh record);

    int updateBatch(List<OrderJsoupMh> list);

    int batchInsert(@Param("list") List<OrderJsoupMh> list);
}