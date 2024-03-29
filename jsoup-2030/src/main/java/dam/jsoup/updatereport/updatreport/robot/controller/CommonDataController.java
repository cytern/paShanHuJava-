package dam.jsoup.updatereport.updatreport.robot.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IORuntimeException;
import cn.hutool.core.io.IoUtil;
import com.alibaba.fastjson.JSONObject;
import dam.jsoup.updatereport.updatreport.robot.dto.QqKeyEdit;
import dam.jsoup.updatereport.updatreport.robot.mapper.QqKeyEditDao;
import dam.jsoup.updatereport.updatreport.robot.pojo.ApiResult;
import dam.jsoup.updatereport.updatreport.robot.service.CommonDataFactory;
import dam.jsoup.updatereport.updatreport.util.Toolkit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
@RequestMapping("openData")
public class CommonDataController {
    @Autowired
    private CommonDataFactory commonDataFactory;
    @Autowired
    private QqKeyEditDao qqKeyEditDao;

    @RequestMapping("commonBusiness")
    public JSONObject commonData(@RequestBody JSONObject params) {
        return commonDataFactory.resolveAndGetBackData(params);
    }

    @RequestMapping("/addJsonFile")
    public JSONObject commonReadFile(@RequestParam(name = "file",value = "file",required = false) MultipartFile[] files,@RequestParam String qqId,@RequestParam Integer type) throws IOException {
           if (files.length > 1) {
               return ApiResult.fail("过多的文件");
           }
        for (MultipartFile file : files) {
            try {
                StringBuilder stringBuilder = new StringBuilder();
                InputStream inputStream = file.getInputStream();
                String read = IoUtil.read(inputStream, StandardCharsets.UTF_8);
                JSONObject jsonObj = JSONObject.parseObject(read);
                String activeCode = jsonObj.getString("activeCode");
                if (Toolkit.isInvalid(activeCode)) {
                    return ApiResult.fail("文件非法 请确定是否有填写 生效模组编码 （activeCode）");
                }
                QqKeyEdit qqKeyEdit = new QqKeyEdit();
                qqKeyEdit.setJson(jsonObj.toJSONString());
                qqKeyEdit.setQqId(qqId);
                qqKeyEdit.setResCode(activeCode);
                qqKeyEdit.setType(String.valueOf(type));
                qqKeyEditDao.save(qqKeyEdit);
                return ApiResult.success(JSONObject.parseObject(JSONObject.toJSONString(qqKeyEdit)));
            } catch (IORuntimeException e) {
                return ApiResult.fail("上传的json文件有误" + e.getMessage());
            }
        }
        return ApiResult.fail("空文件");
    }

    @RequestMapping("updateJsonFile")
    public JSONObject updateJsonFile (@RequestBody JSONObject robotFile) {
        String qqId = robotFile.getString("qqId");
        String type = robotFile.getString("type");
        String activeCode = robotFile.getString("resCode");
        if (Toolkit.isInvalid(qqId) || Toolkit.isInvalid(type) || Toolkit.isInvalid(activeCode)) {
            return ApiResult.fail("缺少必填参数");
        }
        QqKeyEdit qqKeyEdit = JSONObject.parseObject(robotFile.toJSONString(), QqKeyEdit.class);
        qqKeyEdit.setJson(robotFile.toJSONString());
        qqKeyEditDao.save(qqKeyEdit);
        return ApiResult.success(JSONObject.parseObject(JSONObject.toJSONString(qqKeyEdit)));
    }

    @RequestMapping("newJsonFile")
    public JSONObject newJsonFile (@RequestParam String qqId,@RequestParam String type,@RequestParam String activeCode ) {
        JSONObject json = new JSONObject();
       if (type.equals("1")) {
           json  = JSONObject.parseObject("{\"activeCode\":\"\",\n" +
                   "    \"assets\":[\n" +
                   "    ],\n" +
                   "    \"voice\":{\n" +
                   "        \"volume\": \"4F\",\n" +
                   "        \"speed\":\"-0.7F\",\n" +
                   "        \"voiceType\":\"101016L\",\n" +
                   "        \"primaryLanguage\":\"1L\"\n" +
                   "     }, \"robotCommand\": []}");
       }else if (type.equals("2")) {
           json  = JSONObject.parseObject("{\"activeCode\":\"\",\n" +
                   "   \"assets\":[],\"data\": {\n" +
                   "      \"items\" : []}}");
       }else {
           return ApiResult.fail("无效的入参");
       }
        QqKeyEdit qqKeyEdit = new QqKeyEdit();
        json.put("activeCode",activeCode);
        qqKeyEdit.setResCode(activeCode);
        qqKeyEdit.setJson(json.toJSONString());
        qqKeyEdit.setType(type);
        qqKeyEdit.setQqId(qqId);
        qqKeyEditDao.save(qqKeyEdit);
        return ApiResult.success(JSONObject.parseObject(JSONObject.toJSONString(qqKeyEdit)));
    }

    @RequestMapping("downLoadNewFile")
    public void downLoadNewFile (HttpServletResponse response,@RequestParam String qqId, @RequestParam String type, @RequestParam String activeCode ) {
        QqKeyEdit qqKeyEdit = new QqKeyEdit();
        qqKeyEdit.setResCode(activeCode);
        qqKeyEdit.setType(type);
        qqKeyEdit.setQqId(qqId);
        QqKeyEdit qqKeyEdit1 = qqKeyEditDao.selectKeyIdType(qqKeyEdit);
        if (qqKeyEdit1 == null) {
            return;
        }

        response.setContentType("application/octet-stream;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-type", "application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=" + "main.json");
        try {
            OutputStream os = response.getOutputStream();
            os.write(JSONObject.toJSONString(qqKeyEdit1).getBytes(StandardCharsets.UTF_8));
            os.flush();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

}
