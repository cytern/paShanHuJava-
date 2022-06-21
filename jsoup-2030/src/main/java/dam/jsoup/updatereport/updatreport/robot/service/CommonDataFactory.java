package dam.jsoup.updatereport.updatreport.robot.service;

import com.alibaba.fastjson.JSONObject;
import dam.jsoup.updatereport.updatreport.robot.service.impl.IDispositionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CommonDataFactory {
    @Autowired
    private IDispositionService dispositionService;

    public JSONObject resolveAndGetBackData(JSONObject params) {
        Integer businessCode = params.getInteger("businessCode");
        if (businessCode == 1) {
            return dispositionService.resAndGetDataBack(params);
        }else {
            return null;
        }
    }
}
