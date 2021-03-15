package com.kente.demo.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.kente.demo.service.FileExcutorService;
import org.springframework.stereotype.Service;
import sun.plugin.util.UIUtil;

import java.io.File;
import java.util.List;
import java.util.Map;

@Service
public class FileExcutorServiceImpl implements FileExcutorService {
    /**
     * 生成文件
     *
     * @param result
     * @param dir
     * @return 返回文件的生成名
     */
    @Override
    public String fileInput(List<Map<String,String>> result, String dir, String fileName) {
        //判断是否含有文件 如果有则删除
        fileName = fileName + IdUtil.fastSimpleUUID()+  ".xlsx";
        String fileS = dir + "\\" +fileName ;
        File file = new File(fileS);
        if (file.exists()) {
            boolean delete = file.delete();
        }
        //通过工具类创建writer
        ExcelWriter writer = ExcelUtil.getWriter(fileS);
        writer.passCurrentRow();

        writer.merge(result.size() - 1, "结果集");
//一次性写出内容，强制输出标题

        writer.write(result, true);
//关闭writer，释放内存
        writer.close();
          //生成文件完成
        return fileName;
    }
}
