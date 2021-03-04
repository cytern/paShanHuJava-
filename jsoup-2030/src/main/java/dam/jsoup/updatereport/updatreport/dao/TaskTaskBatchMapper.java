package dam.jsoup.updatereport.updatreport.dao;

import dam.jsoup.updatereport.updatreport.pojo.TaskTaskBatch;
import dam.jsoup.updatereport.updatreport.pojo.TaskTaskBatchExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TaskTaskBatchMapper {
    long countByExample(TaskTaskBatchExample example);

    int deleteByExample(TaskTaskBatchExample example);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(TaskTaskBatch record);

    int insertOrUpdate(TaskTaskBatch record);

    int insertOrUpdateSelective(TaskTaskBatch record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(TaskTaskBatch record);

    List<TaskTaskBatch> selectByExample(TaskTaskBatchExample example);

    int updateByExampleSelective(@Param("record") TaskTaskBatch record, @Param("example") TaskTaskBatchExample example);

    int updateByExample(@Param("record") TaskTaskBatch record, @Param("example") TaskTaskBatchExample example);

    int batchInsert(@Param("list") List<TaskTaskBatch> list);
}