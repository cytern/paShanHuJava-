package dam.jsoup.updatereport.updatreport.service;

import dam.jsoup.updatereport.updatreport.vo.MissionAllData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * 网络调用请求
 */
@FeignClient("excutor")
public interface HttpExcutorService {
    /**
     * 执行一个missionAll数据的全部脚本
     * @param missionAllData missionAllData
     * @return
     */
    @PostMapping("system/sendJsoup")
    Map excutorJavaSoup( MissionAllData missionAllData);
}
