package dam.server.demo.config;

import dam.server.demo.executor.HeartHitExecutor;
import dam.server.demo.service.RunJsoupService;
import dam.server.demo.utils.OpenWebUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * 任务启动后 发送心跳包
 */
@Component
@AllArgsConstructor
public class RunSoupPool implements ApplicationListener<ContextRefreshedEvent> {
    /**
       spring 服务启动后 循环判断线程池是否空余  max ：2  如果空余则执行新的网络请求 拿到执行数据
     */
     private final HeartHitExecutor heartHitExecutor;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
          heartHitExecutor.heartHitSend();
         OpenWebUtil openWebUtil = new OpenWebUtil();
         openWebUtil.openWeb();
    }
}
