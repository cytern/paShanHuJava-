package dam.jsoup.updatereport.updatreport.service.impl;

import dam.jsoup.updatereport.updatreport.dao.JsoupUserDetailMapper;
import dam.jsoup.updatereport.updatreport.dao.JsoupUserMapper;
import dam.jsoup.updatereport.updatreport.pojo.JsoupUserDetail;
import dam.jsoup.updatereport.updatreport.pojo.JsoupUserDetailExample;
import dam.jsoup.updatereport.updatreport.service.HttpExcutorService;
import dam.jsoup.updatereport.updatreport.service.JsoupMissionService;
import dam.jsoup.updatereport.updatreport.service.SendEmail;
import dam.jsoup.updatereport.updatreport.service.SendExcutorServcie;
import dam.jsoup.updatereport.updatreport.vo.MissionAllData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
@Slf4j
public class SendExcutorServiceImpl implements SendExcutorServcie {
    private final JsoupMissionService jsoupMissionService;
    private final HttpExcutorService httpExcutorService;
    private final SendEmail sendEmail;
    private final JsoupUserMapper userMapper;
    private final JsoupUserDetailMapper detailMapper;


    public SendExcutorServiceImpl(JsoupMissionService jsoupMissionService, HttpExcutorService httpExcutorService, SendEmail sendEmail, JsoupUserMapper userMapper, JsoupUserDetailMapper detailMapper) {
        this.jsoupMissionService = jsoupMissionService;
        this.httpExcutorService = httpExcutorService;
        this.sendEmail = sendEmail;
        this.userMapper = userMapper;
        this.detailMapper = detailMapper;
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
        if (map.get("code").equals("error")){
            log.info("脚本执行错误");
        }
        JsoupUserDetailExample detailExample = new JsoupUserDetailExample();
        detailExample.createCriteria().andUserIdEqualTo(userId);
        List<JsoupUserDetail> jsoupUserDetails = detailMapper.selectByExample(detailExample);
        sendEmail.sendResEmail(jsoupUserDetails.get(0).getUserEmail(),(String) map.get("code"),missionAllData.getJsoupMissionAll().getMaName(),(String) map.get("msg"));
        return map;
    }
}
