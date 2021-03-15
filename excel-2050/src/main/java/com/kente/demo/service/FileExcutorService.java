package com.kente.demo.service;

import java.util.List;
import java.util.Map;

/**
 * 文件生成下载服务
 */
public interface FileExcutorService {
    /**
     * 生成文件
     * @return 返回文件的生成名
     */
     String fileInput(List<Map<String,String>> result, String dir, String fileName);
}
