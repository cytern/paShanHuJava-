package dam.jsoup.updatereport.updatreport.dao;

import dam.jsoup.updatereport.updatreport.pojo.TaskExecutionParams;
import dam.jsoup.updatereport.updatreport.pojo.TaskExecutionParamsExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TaskExecutionParamsMapper {
    long countByExample(TaskExecutionParamsExample example);

    int deleteByExample(TaskExecutionParamsExample example);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(TaskExecutionParams record);

    int insertOrUpdate(TaskExecutionParams record);

    int insertOrUpdateSelective(TaskExecutionParams record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(TaskExecutionParams record);

    List<TaskExecutionParams> selectByExample(TaskExecutionParamsExample example);

    int updateByExampleSelective(@Param("record") TaskExecutionParams record, @Param("example") TaskExecutionParamsExample example);

    int updateByExample(@Param("record") TaskExecutionParams record, @Param("example") TaskExecutionParamsExample example);

    int batchInsert(@Param("list") List<TaskExecutionParams> list);
}