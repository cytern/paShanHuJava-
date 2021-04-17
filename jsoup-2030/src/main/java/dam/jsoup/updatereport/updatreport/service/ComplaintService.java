package dam.jsoup.updatereport.updatreport.service;

import dam.jsoup.updatereport.updatreport.pojo.JsoupComplaint;

import java.util.Map;

/**
 * 投诉服务
 */
public interface ComplaintService {
    /**
     * 发起投诉
     * @param complaint
     * @return
     */
    Map addNewComplaintService (JsoupComplaint complaint);

    /**
     * 获取投诉
     * @param pageSize
     * @param index
     * @return
     */
    Map getAllComplaintService (Integer pageSize,Integer index);

    /**
     * 处理投诉
     * @param complaint
     * @return
     */
    Map dealComplaintService (JsoupComplaint complaint);


}
