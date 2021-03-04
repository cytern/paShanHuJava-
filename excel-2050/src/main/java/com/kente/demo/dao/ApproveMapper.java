package com.kente.demo.dao;

import com.kente.demo.pojo.Approve;
import com.kente.demo.pojo.ApproveExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ApproveMapper {
    long countByExample(ApproveExample example);

    int deleteByExample(ApproveExample example);

    /**
     * delete by primary key
     *
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(Approve record);

    int insertOrUpdate(Approve record);

    int insertOrUpdateSelective(Approve record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(Approve record);

    List<Approve> selectByExample(ApproveExample example);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    Approve selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Approve record, @Param("example") ApproveExample example);

    int updateByExample(@Param("record") Approve record, @Param("example") ApproveExample example);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Approve record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Approve record);

    int updateBatch(List<Approve> list);

    int updateBatchSelective(List<Approve> list);

    int batchInsert(@Param("list") List<Approve> list);
}