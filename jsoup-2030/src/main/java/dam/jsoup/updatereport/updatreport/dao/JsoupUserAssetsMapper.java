package dam.jsoup.updatereport.updatreport.dao;

import dam.jsoup.updatereport.updatreport.pojo.JsoupUserAssets;
import dam.jsoup.updatereport.updatreport.pojo.JsoupUserAssetsExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface JsoupUserAssetsMapper {
    long countByExample(JsoupUserAssetsExample example);

    int deleteByExample(JsoupUserAssetsExample example);

    /**
     * delete by primary key
     *
     * @param userAssetsId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer userAssetsId);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(JsoupUserAssets record);

    int insertOrUpdate(JsoupUserAssets record);

    int insertOrUpdateSelective(JsoupUserAssets record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(JsoupUserAssets record);

    List<JsoupUserAssets> selectByExample(JsoupUserAssetsExample example);

    /**
     * select by primary key
     *
     * @param userAssetsId primary key
     * @return object by primary key
     */
    JsoupUserAssets selectByPrimaryKey(Integer userAssetsId);

    int updateByExampleSelective(@Param("record") JsoupUserAssets record, @Param("example") JsoupUserAssetsExample example);

    int updateByExample(@Param("record") JsoupUserAssets record, @Param("example") JsoupUserAssetsExample example);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(JsoupUserAssets record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(JsoupUserAssets record);

    int updateBatch(List<JsoupUserAssets> list);

    int batchInsert(@Param("list") List<JsoupUserAssets> list);
}