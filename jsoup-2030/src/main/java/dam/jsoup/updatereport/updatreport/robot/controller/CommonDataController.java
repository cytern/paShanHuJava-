package dam.jsoup.updatereport.updatreport.robot.controller;

import com.alibaba.fastjson.JSONObject;
import dam.jsoup.updatereport.updatreport.robot.service.CommonDataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("openData")
public class CommonDataController {
    @Autowired
    private CommonDataFactory commonDataFactory;

    @RequestMapping("commonBusiness")
    public JSONObject commonData(@RequestBody JSONObject params) {
        return commonDataFactory.resolveAndGetBackData(params);
    }
}
