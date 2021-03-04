package dam.jsoup.updatereport.updatreport.dao;

import dam.jsoup.updatereport.updatreport.pojo.JsoupUser;
import dam.jsoup.updatereport.updatreport.pojo.JsoupUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface JsoupUserMapper {
    long countByExample(JsoupUserExample example);

    int deleteByExample(JsoupUserExample example);

    /**
     * delete by primary key
     *
     * @param userId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(@Param("userId") Integer userId, @Param("username") String username);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(JsoupUser record);

    int insertOrUpdate(JsoupUser record);

    int insertOrUpdateSelective(JsoupUser record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(JsoupUser record);

    List<JsoupUser> selectByExample(JsoupUserExample example);

    /**
     * select by primary key
     *
     * @param userId primary key
     * @return object by primary key
     */
    JsoupUser selectByPrimaryKey(@Param("userId") Integer userId, @Param("username") String username);

    int updateByExampleSelective(@Param("record") JsoupUser record, @Param("example") JsoupUserExample example);

    int updateByExample(@Param("record") JsoupUser record, @Param("example") JsoupUserExample example);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(JsoupUser record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(JsoupUser record);

    int updateBatch(List<JsoupUser> list);

    int batchInsert(@Param("list") List<JsoupUser> list);

    /**
     * delete by primary key
     *
     * @param userId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer userId);

    /**
     * select by primary key
     *
     * @param userId primary key
     * @return object by primary key
     */
    JsoupUser selectByPrimaryKey(Integer userId);
}