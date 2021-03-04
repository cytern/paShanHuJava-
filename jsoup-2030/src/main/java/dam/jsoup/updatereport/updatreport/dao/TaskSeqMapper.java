package dam.jsoup.updatereport.updatreport.dao;

import dam.jsoup.updatereport.updatreport.pojo.TaskSeq;
import dam.jsoup.updatereport.updatreport.pojo.TaskSeqExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TaskSeqMapper {
    long countByExample(TaskSeqExample example);

    int deleteByExample(TaskSeqExample example);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(TaskSeq record);

    int insertOrUpdate(TaskSeq record);

    int insertOrUpdateSelective(TaskSeq record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(TaskSeq record);

    List<TaskSeq> selectByExample(TaskSeqExample example);

    int updateByExampleSelective(@Param("record") TaskSeq record, @Param("example") TaskSeqExample example);

    int updateByExample(@Param("record") TaskSeq record, @Param("example") TaskSeqExample example);

    int batchInsert(@Param("list") List<TaskSeq> list);
}