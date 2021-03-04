package dam.jsoup.updatereport.updatreport.dao;

import dam.jsoup.updatereport.updatreport.pojo.TaskLock;
import dam.jsoup.updatereport.updatreport.pojo.TaskLockExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TaskLockMapper {
    long countByExample(TaskLockExample example);

    int deleteByExample(TaskLockExample example);

    /**
     * delete by primary key
     * @param lockKey primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(@Param("lockKey") String lockKey, @Param("region") String region);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(TaskLock record);

    int insertOrUpdate(TaskLock record);

    int insertOrUpdateSelective(TaskLock record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(TaskLock record);

    List<TaskLock> selectByExample(TaskLockExample example);

    /**
     * select by primary key
     * @param lockKey primary key
     * @return object by primary key
     */
    TaskLock selectByPrimaryKey(@Param("lockKey") String lockKey, @Param("region") String region);

    int updateByExampleSelective(@Param("record") TaskLock record, @Param("example") TaskLockExample example);

    int updateByExample(@Param("record") TaskLock record, @Param("example") TaskLockExample example);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(TaskLock record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(TaskLock record);

    int updateBatch(List<TaskLock> list);

    int batchInsert(@Param("list") List<TaskLock> list);
}