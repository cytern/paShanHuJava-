package dam.jsoup.updatereport.updatreport.service.impl;

import dam.jsoup.updatereport.updatreport.dao.JsoupComplaintMapper;
import dam.jsoup.updatereport.updatreport.dao.JsoupMissionAllHistoryMapper;
import dam.jsoup.updatereport.updatreport.dao.JsoupMissionAllMapper;
import dam.jsoup.updatereport.updatreport.pojo.JsoupComplaint;
import dam.jsoup.updatereport.updatreport.service.ComplaintService;
import dam.jsoup.updatereport.updatreport.service.SendEmail;
import dam.jsoup.updatereport.updatreport.util.MyResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;
@Slf4j
@Service
public class ComplaintServiceImpl implements ComplaintService {
    private final JsoupMissionAllMapper missionAllMapper;
    private final JsoupMissionAllHistoryMapper missionAllHistoryMapper;
    private final SendEmail sendEmail;
    private final JsoupComplaintMapper complaintMapper;

    public ComplaintServiceImpl(JsoupMissionAllMapper missionAllMapper, JsoupMissionAllHistoryMapper missionAllHistoryMapper, SendEmail sendEmail, JsoupComplaintMapper complaintMapper) {
        this.missionAllMapper = missionAllMapper;
        this.missionAllHistoryMapper = missionAllHistoryMapper;
        this.sendEmail = sendEmail;
        this.complaintMapper = complaintMapper;
    }

    /**
     * 发起投诉
     *
     * @param complaint
     * @return
     */
    @Override
    public Map addNewComplaintService(JsoupComplaint complaint) {
       complaintMapper.insertSelective(complaint);
       sendEmail.sendNoticeEmail(complaint.getSendUserId(),"您的举报已经被受理","您的举报已经受理，我们将尽快审核，并将结果通知与您。感谢您对平台环境的维护与支持！");
       return MyResponse.myResponseOk("举报成功");
    }

    /**
     * 获取投诉
     *
     * @param pageSize
     * @param index
     * @return
     */
    @Override
    public Map getAllComplaintService(Integer pageSize, Integer index) {
        return null;
    }

    /**
     * 处理投诉
     *
     * @param complaint
     * @return
     */
    @Override
    public Map dealComplaintService(JsoupComplaint complaint) {
        return null;
    }
}
