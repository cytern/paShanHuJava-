package com.kente.demo.dao;

import com.kente.demo.pojo.Kentecom;
import com.kente.demo.pojo.KentecomExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface KentecomMapper {
    long countByExample(KentecomExample example);

    int deleteByExample(KentecomExample example);

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
    int insert(Kentecom record);

    int insertOrUpdate(Kentecom record);

    int insertOrUpdateSelective(Kentecom record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(Kentecom record);

    List<Kentecom> selectByExample(KentecomExample example);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    Kentecom selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Kentecom record, @Param("example") KentecomExample example);

    int updateByExample(@Param("record") Kentecom record, @Param("example") KentecomExample example);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Kentecom record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Kentecom record);

    int updateBatch(List<Kentecom> list);

    int updateBatchSelective(List<Kentecom> list);

    int batchInsert(@Param("list") List<Kentecom> list);
}