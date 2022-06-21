package dam.jsoup.updatereport.updatreport.robot.controller;

import com.alibaba.fastjson.JSONObject;
import dam.jsoup.updatereport.updatreport.robot.service.CommonDataFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 外置数据服务
 */
@RestController
@Slf4j
@RequestMapping("robot/data")
public class FeignDataController {
    @Autowired
    private CommonDataFactory commonDataFactory;
    /**
     * 通用数据请求
     * @param requestParams 必包含businessCode 代表数据沟通类型
     * @return
     */
    @RequestMapping("common")
    public JSONObject commonDataRequest (@RequestBody JSONObject requestParams) {
       return commonDataFactory.resolveAndGetBackData(requestParams);
    }
}
