package dam.jsoup.updatereport.updatreport.robot.service;

import com.alibaba.fastjson.JSONObject;
import dam.jsoup.updatereport.updatreport.robot.pojo.Constant;
import dam.jsoup.updatereport.updatreport.robot.service.impl.QQUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CommonDataFactory {
    @Autowired
    private QQUserService dispositionService;

    public JSONObject resolveAndGetBackData(JSONObject params) {
        Integer businessCode = params.getInteger("businessCode");
        if (businessCode.equals(Constant.businessCode.onesDisposition)) {
            return dispositionService.resAndGetDataBack(params);
        }else {
            return null;
        }
    }
}
