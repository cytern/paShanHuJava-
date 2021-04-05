package dam.jsoup.updatereport.updatreport.excutor;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * 执行器 读取待执行任务 发送待执行任务情况
 */
@Component
public class TimedTaskExcutor implements ApplicationListener<ContextRefreshedEvent> {
    private final TimeTaskAdder timeTaskAdder;

    public TimedTaskExcutor(TimeTaskAdder timeTaskAdder) {
        this.timeTaskAdder = timeTaskAdder;
    }

    //开启线程池
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
           timeTaskAdder.run();
    }
}
