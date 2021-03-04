package dam.jsoup.updatereport.updatreport.dao;

import dam.jsoup.updatereport.updatreport.pojo.JsoupUserDetail;
import dam.jsoup.updatereport.updatreport.pojo.JsoupUserDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface JsoupUserDetailMapper {
    long countByExample(JsoupUserDetailExample example);

    int deleteByExample(JsoupUserDetailExample example);

    /**
     * delete by primary key
     *
     * @param userDetailId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer userDetailId);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(JsoupUserDetail record);

    int insertOrUpdate(JsoupUserDetail record);

    int insertOrUpdateSelective(JsoupUserDetail record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(JsoupUserDetail record);

    List<JsoupUserDetail> selectByExample(JsoupUserDetailExample example);

    /**
     * select by primary key
     *
     * @param userDetailId primary key
     * @return object by primary key
     */
    JsoupUserDetail selectByPrimaryKey(Integer userDetailId);

    int updateByExampleSelective(@Param("record") JsoupUserDetail record, @Param("example") JsoupUserDetailExample example);

    int updateByExample(@Param("record") JsoupUserDetail record, @Param("example") JsoupUserDetailExample example);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(JsoupUserDetail record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(JsoupUserDetail record);

    int updateBatch(List<JsoupUserDetail> list);

    int batchInsert(@Param("list") List<JsoupUserDetail> list);
}