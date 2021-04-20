package dam.jsoup.updatereport.updatreport.excutor;

import dam.jsoup.updatereport.updatreport.service.TimeTaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * 定时任务 生产者
 */
@Service
@Slf4j
public  class AllTimeService {

    private final TimeTaskService timeTaskService;

    public AllTimeService(TimeTaskService timeTaskService) {
        this.timeTaskService = timeTaskService;

    }
    @Async("taskPool")
    public void addTimeTask(){
        //自旋 从数据库中获取 待执行脚本
        log.info("初始化 开始检索定时任务 ");
        while (true) {
            try {
                Thread.sleep(90000);
                log.info("等待结束 开始检索任务  ");
                timeTaskService.setTaskService();
                Thread.sleep(90000);
            } catch (Exception e) {
              log.error("定时任务检查  失败 ",e);
            }
        }
    }
    @Async("taskPool")
    public void judgeExecutorLive() {
        log.info("初始化 开始检索定时任务 ");
        while (true) {
            try {
                Thread.sleep(90000);
                log.info("等待结束 开始检索任务  ");
                timeTaskService.setTaskService();
                Thread.sleep(90000);
            } catch (Exception e) {
                log.error("定时任务检查  失败 ",e);
            }
        }
    }
}
