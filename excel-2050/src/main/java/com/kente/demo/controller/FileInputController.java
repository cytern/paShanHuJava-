package com.kente.demo.controller;

import com.kente.demo.pojo.FileDataVo;
import com.kente.demo.service.FileExcutorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 文件管理控制器
 */
@RestController
public class FileInputController {
    private final FileExcutorService fileExcutorService;

    public FileInputController(FileExcutorService fileExcutorService) {
        this.fileExcutorService = fileExcutorService;
    }

    /**
     * 生成文件
     * @param fileDataVo 文件实体类
     * @return 生成的文件名
     */
     @PostMapping("system/fileInput")
    String inputFile(@RequestBody FileDataVo fileDataVo){
         String s = fileExcutorService.fileInput(fileDataVo.getResult(), fileDataVo.getDir(), fileDataVo.getFileName());
         return s;
     }




}
