package dam.jsoup.updatereport.updatreport.dao;

import dam.jsoup.updatereport.updatreport.pojo.Setting;
import dam.jsoup.updatereport.updatreport.pojo.SettingExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SettingMapper {
    long countByExample(SettingExample example);

    int deleteByExample(SettingExample example);

    /**
     * delete by primary key
     *
     * @param settingId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer settingId);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(Setting record);

    int insertOrUpdate(Setting record);

    int insertOrUpdateSelective(Setting record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(Setting record);

    List<Setting> selectByExample(SettingExample example);

    /**
     * select by primary key
     *
     * @param settingId primary key
     * @return object by primary key
     */
    Setting selectByPrimaryKey(Integer settingId);

    int updateByExampleSelective(@Param("record") Setting record, @Param("example") SettingExample example);

    int updateByExample(@Param("record") Setting record, @Param("example") SettingExample example);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Setting record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Setting record);

    int updateBatch(List<Setting> list);

    int batchInsert(@Param("list") List<Setting> list);

    int updateBatchSelective(List<Setting> list);
}