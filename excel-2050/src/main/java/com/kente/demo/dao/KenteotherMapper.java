package com.kente.demo.dao;

import com.kente.demo.pojo.Kenteother;
import com.kente.demo.pojo.KenteotherExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface KenteotherMapper {
    long countByExample(KenteotherExample example);

    int deleteByExample(KenteotherExample example);

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
    int insert(Kenteother record);

    int insertOrUpdate(Kenteother record);

    int insertOrUpdateSelective(Kenteother record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(Kenteother record);

    List<Kenteother> selectByExample(KenteotherExample example);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    Kenteother selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Kenteother record, @Param("example") KenteotherExample example);

    int updateByExample(@Param("record") Kenteother record, @Param("example") KenteotherExample example);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Kenteother record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Kenteother record);

    int updateBatch(List<Kenteother> list);

    int updateBatchSelective(List<Kenteother> list);

    int batchInsert(@Param("list") List<Kenteother> list);
}