package dam.jsoup.updatereport.updatreport.dao;

import dam.jsoup.updatereport.updatreport.pojo.TaskExecution;
import dam.jsoup.updatereport.updatreport.pojo.TaskExecutionExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TaskExecutionMapper {
    long countByExample(TaskExecutionExample example);

    int deleteByExample(TaskExecutionExample example);

    /**
     * delete by primary key
     * @param taskExecutionId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long taskExecutionId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(TaskExecution record);

    int insertOrUpdate(TaskExecution record);

    int insertOrUpdateSelective(TaskExecution record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(TaskExecution record);

    List<TaskExecution> selectByExample(TaskExecutionExample example);

    /**
     * select by primary key
     * @param taskExecutionId primary key
     * @return object by primary key
     */
    TaskExecution selectByPrimaryKey(Long taskExecutionId);

    int updateByExampleSelective(@Param("record") TaskExecution record, @Param("example") TaskExecutionExample example);

    int updateByExample(@Param("record") TaskExecution record, @Param("example") TaskExecutionExample example);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(TaskExecution record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(TaskExecution record);

    int updateBatch(List<TaskExecution> list);

    int batchInsert(@Param("list") List<TaskExecution> list);
}