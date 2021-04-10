package dam.jsoup.updatereport.updatreport.dao;

import dam.jsoup.updatereport.updatreport.pojo.OrderJsoupMa;
import dam.jsoup.updatereport.updatreport.pojo.OrderJsoupMaExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderJsoupMaMapper {
    long countByExample(OrderJsoupMaExample example);

    int deleteByExample(OrderJsoupMaExample example);

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
    int insert(OrderJsoupMa record);

    int insertOrUpdate(OrderJsoupMa record);

    int insertOrUpdateSelective(OrderJsoupMa record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(OrderJsoupMa record);

    List<OrderJsoupMa> selectByExample(OrderJsoupMaExample example);

    /**
     * select by primary key
     *
     * @param orderId primary key
     * @return object by primary key
     */
    OrderJsoupMa selectByPrimaryKey(Integer orderId);

    int updateByExampleSelective(@Param("record") OrderJsoupMa record, @Param("example") OrderJsoupMaExample example);

    int updateByExample(@Param("record") OrderJsoupMa record, @Param("example") OrderJsoupMaExample example);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(OrderJsoupMa record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(OrderJsoupMa record);

    int updateBatch(List<OrderJsoupMa> list);

    int batchInsert(@Param("list") List<OrderJsoupMa> list);
}