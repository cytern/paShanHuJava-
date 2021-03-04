package com.kente.demo.dao;

import com.kente.demo.pojo.Task;
import com.kente.demo.pojo.TaskExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TaskMapper {
    long countByExample(TaskExample example);

    int deleteByExample(TaskExample example);

    /**
     * delete by primary key
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(Task record);

    int insertOrUpdate(Task record);

    int insertOrUpdateSelective(Task record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Task record);

    List<Task> selectByExample(TaskExample example);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    Task selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Task record, @Param("example") TaskExample example);

    int updateByExample(@Param("record") Task record, @Param("example") TaskExample example);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Task record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Task record);

    int updateBatch(List<Task> list);

    int updateBatchSelective(List<Task> list);

    int batchInsert(@Param("list") List<Task> list);
}