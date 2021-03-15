package dam.server.demo.service;

import dam.server.demo.vo.MissionAllData;

import java.util.List;
import java.util.Map;

/**
 * 脚本执行器服务
 */
public interface ExcutorService {
    /**
     * 执行脚本
     * @param missionAllData 一个mission的全部内容
     * @return myResponse保证的map集合 包含执行结果以及成功与否
     */
    List doExcutor(MissionAllData missionAllData) throws InterruptedException;
}
