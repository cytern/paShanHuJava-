package dam.jsoup.updatereport.updatreport.service.impl;

import dam.jsoup.updatereport.updatreport.service.HttpExcutorService;
import dam.jsoup.updatereport.updatreport.service.JsoupMissionService;
import dam.jsoup.updatereport.updatreport.service.SendExcutorServcie;
import dam.jsoup.updatereport.updatreport.vo.MissionAllData;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class SendExcutorServiceImpl implements SendExcutorServcie {
    private final JsoupMissionService jsoupMissionService;
    private final HttpExcutorService httpExcutorService;


    public SendExcutorServiceImpl(JsoupMissionService jsoupMissionService, HttpExcutorService httpExcutorService) {
        this.jsoupMissionService = jsoupMissionService;
        this.httpExcutorService = httpExcutorService;
    }

    /**
     * 发送服务
     *
     * @param maId
     * @return 服务执行情况 myResponse 对象
     */
    @Override
    public Map sendGoExcutor(Integer maId,Integer userId) {
        //异常应该统一抛出给最上层补货 而非此处
        MissionAllData missionAllData = jsoupMissionService.getMissionAllData(maId,userId);
        Map map = httpExcutorService.excutorJavaSoup(missionAllData);
        System.out.println(map);
        return map;

    }
}
