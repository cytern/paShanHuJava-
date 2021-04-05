package dam.jsoup.updatereport.updatreport.service;

import dam.jsoup.updatereport.updatreport.pojo.JsoupMissionAllHistory;
import dam.jsoup.updatereport.updatreport.vo.MissionAllData;

import java.util.List;
import java.util.Map;

/**
 * 服务端交互服务  脚本执行
 */
public interface ConnectSoupSystemService {
    /**
     * 获取待执行服务
     * @return
     */
    JsoupMissionAllHistory getOneWaitService();
    /**
     * 接受执行完毕数据
     */
    void storeBackData(List result, MissionAllData missionAllData);

}
