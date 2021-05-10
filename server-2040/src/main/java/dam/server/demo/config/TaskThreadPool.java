package dam.server.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class TaskThreadPool {


    @Bean("taskExecutor")
    public ThreadPoolTaskExecutor taskExecutor() {
        ConfigBean config = ConfigBean.getInstance();
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //核心线程池大小
        executor.setCorePoolSize(config.getJsoupSetting().getPool().getCorePoolSize());
        //最大线程数
        executor.setMaxPoolSize(config.getJsoupSetting().getPool().getMaxPoolSize());
        //队列容量
        executor.setQueueCapacity(config.getJsoupSetting().getPool().getQueueCapacity());
        //活跃时间
        executor.setKeepAliveSeconds(config.getJsoupSetting().getPool().getKeepAliveSeconds());
        //线程名字前缀
        executor.setThreadNamePrefix("JsoupExecutePool-");

        // setRejectedExecutionHandler：当pool已经达到max size的时候，如何处理新任务
        // CallerRunsPolicy：不在新线程中执行任务，而是由调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 等待所有任务结束后再关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.initialize();
        return executor;
    }

}
