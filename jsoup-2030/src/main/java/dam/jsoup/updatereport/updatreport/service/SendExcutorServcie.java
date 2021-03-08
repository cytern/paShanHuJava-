package dam.jsoup.updatereport.updatreport.service;

import java.util.Map;

/**
 * 脚本确认执行时 调用此服务 获得脚本数据 并且发送给执行器
 */
public interface SendExcutorServcie {
    /**
     * 发送服务
     * @return 服务执行情况 myResponse 对象
     */
    Map sendGoExcutor(Integer maId,Integer userId);

}
