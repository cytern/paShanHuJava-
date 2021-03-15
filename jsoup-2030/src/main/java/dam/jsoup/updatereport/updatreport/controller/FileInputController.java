package dam.jsoup.updatereport.updatreport.controller;


import dam.jsoup.updatereport.updatreport.dao.JsoupMissionAllHistoryMapper;
import dam.jsoup.updatereport.updatreport.pojo.JsoupMissionAllHistory;
import dam.jsoup.updatereport.updatreport.pojo.JsoupMissionAllHistoryExample;
import dam.jsoup.updatereport.updatreport.service.FileExcutorService;
import dam.jsoup.updatereport.updatreport.service.SendEmail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


/**
 * 文件管理控制器
 */
@RestController
@Slf4j
public class FileInputController {
    private final FileExcutorService fileExcutorService;
    private final JsoupMissionAllHistoryMapper historyMapper;
    private final String dir = "E:\\projects\\excelData\\";
    private final SendEmail sendEmail;

    public FileInputController(FileExcutorService fileExcutorService, JsoupMissionAllHistoryMapper historyMapper, SendEmail sendEmail) {
        this.fileExcutorService = fileExcutorService;

        this.historyMapper = historyMapper;
        this.sendEmail = sendEmail;
    }

    /**
     * 生成文件
     * @param historyId 文件实体类
     * @return 生成的文件名
     */
     @RequestMapping("other/downloadFile/{historyId}")
     @ResponseBody
    public void downloadFile(HttpServletResponse response,@PathVariable Integer historyId){
         //获得missionAllH
         JsoupMissionAllHistory jsoupMissionAllHistory = historyMapper.selectByPrimaryKey(historyId);
         //获得fileName
         String filename = dir + jsoupMissionAllHistory.getMissionResultUrl();
         File file = new File(filename);
         if(file.exists()){ //判断文件父目录是否存在
             response.setContentType("application/vnd.ms-excel;charset=UTF-8");
             response.setCharacterEncoding("UTF-8");
             // response.setContentType("application/force-download");
             try {
                 response.setHeader("Content-Disposition", "attachment;fileName=" +   java.net.URLEncoder.encode( jsoupMissionAllHistory.getMissionResultUrl(),"UTF-8"));
             } catch (UnsupportedEncodingException e) {
                log.error("文件发送失败");
             }
             byte[] buffer = new byte[1024];
             FileInputStream fis = null; //文件输入流
             BufferedInputStream bis = null;

             OutputStream os = null; //输出流
             try {
                 os = response.getOutputStream();
                 fis = new FileInputStream(file);
                 bis = new BufferedInputStream(fis);
                 int i = bis.read(buffer);
                 while(i != -1){
                     os.write(buffer);
                     i = bis.read(buffer);
                 }

             } catch (Exception e) {
                 // TODO Auto-generated catch block
                 e.printStackTrace();
             }
             System.out.println("----------file download---" + filename);
             try {
                 bis.close();
                 fis.close();
             } catch (IOException e) {
                 // TODO Auto-generated catch block
                 e.printStackTrace();
             }
         }
     }

    /**
     * 此方法选择发送执行
     */
    @GetMapping("customer/sentJsoupRun/{orderId}")
     @ResponseBody
     public void runJavaSoup(@PathVariable Integer orderId){
        log.info("************ 发送执行消息***************");
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        Integer userId = Integer.valueOf(request.getHeader("userId"));
        Map map = new HashMap();
        JsoupMissionAllHistory jsoupMissionAllHistory = historyMapper.selectByPrimaryKey(orderId);
        if (jsoupMissionAllHistory == null) {
            return;
        }else {
            jsoupMissionAllHistory.setMissionState("1");
            historyMapper.updateByPrimaryKeySelective(jsoupMissionAllHistory);
        }

    }







}
