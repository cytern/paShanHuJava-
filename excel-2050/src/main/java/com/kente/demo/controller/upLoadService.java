package com.kente.demo.controller;

import cn.hutool.core.util.IdUtil;
import com.kente.demo.service.MainExporeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@Slf4j
@RestController
public class upLoadService {
    private final MainExporeService mainExporeService;
    /**
     * 设置存取读取url 路径
     */
    private final String excelUrl = "C:\\Users\\24771\\Desktop\\数\\标书\\test\\";

    public upLoadService(MainExporeService mainExporeService) {
        this.mainExporeService = mainExporeService;
    }


    @GetMapping("excel/test")
    String testUrl(){
        return "hello Word";
    }
    @GetMapping("")
    String testAll() {
        return "success";
    }
    @PostMapping(value = "excel/upload")
    public String uploading(@RequestParam("file") MultipartFile
                                         file) {
        File targetFile = new File(excelUrl);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        String uuid = IdUtil.simpleUUID();
        String name = file.getOriginalFilename();
        String[] dot =name.split("\\.");
        String finalName = null;
        try {
            finalName = excelUrl + uuid + "." + dot[dot.length -1 ];
        } catch (Exception e) {
            log.error("文件上传失败!");
            return "error";
        }

        try (FileOutputStream out = new FileOutputStream(finalName)){
            out.write(file.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            log.error("文件上传失败!");
            return "error";
        }
        log.info("文件上传成功!");
        try {
            log.info("开始除理文件");
            mainExporeService.operateData(finalName);
        } catch (Exception e) {
           log.error("除理文件失败",e);
        }
        return finalName;
    }


    @RequestMapping("excel/download")
    public void downLoad(HttpServletResponse response ,@RequestParam("fileName")String fileName) throws UnsupportedEncodingException {
        File file = new File(fileName);
        if(file.exists()){
            response.setContentType("application/octet-stream");
            response.setHeader("content-type", "application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(fileName,"utf8"));
            byte[] buffer = new byte[1024];
            //输出流
            OutputStream os = null;
            try(FileInputStream fis= new FileInputStream(file);
                BufferedInputStream bis = new BufferedInputStream(fis);) {
                os = response.getOutputStream();
                int i = bis.read(buffer);
                while(i != -1){
                    os.write(buffer);
                    i = bis.read(buffer);
                }
            } catch (Exception e) {
                log.error("下载文件失败");
            }
        }
    }





}
