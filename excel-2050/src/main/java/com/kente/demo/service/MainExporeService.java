package com.kente.demo.service;

import com.kente.demo.pojo.Kentecom;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cytern
 */
@Service
public interface MainExporeService {
    /**
     * 操作数据
     */
    void operateData(String dir);

    /**
     * 将excel的数据初始化进对象中
     * @param line 一行
     * @param taskId 任务id
     * @return  kenteCom 对象
     */
    Kentecom initKenteCom (List<Object> line, Integer taskId);

    /**
     * 将对象数据 导出为 excel
     * @param sheetName 表名称
     * @param dir 路径
     * @param title 标题
     */
    void initExcel(String dir,String sheetName,String title);
    /**
     * 序列化
     * @param kentecomList 入参
     * @return  回复数组
     */
    List<List<Object>> getComData(List<Kentecom> kentecomList);

}
