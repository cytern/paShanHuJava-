package dam.jsoup.updatereport.updatreport.excutor;

import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * 执行器 读取待执行任务 发送待执行任务情况
 */
@Component
@AllArgsConstructor
public class TimedTaskExcutor implements ApplicationListener<ContextRefreshedEvent> {
    private final AllTimeService allTimeService;
    private final HeartHitCheckService checkService;
    private final QqSenderTaskService qqSenderTaskService;
    //开启线程池
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        //这里要做两件事 第一件是 开启定时任务注入线程池
        //第二件事 开启检测存活执行器线程池
//        allTimeService.addTimeTask();
//        checkService.judgeExecutorLive();
        qqSenderTaskService.jundgeQqTimerTask();
    }
}
