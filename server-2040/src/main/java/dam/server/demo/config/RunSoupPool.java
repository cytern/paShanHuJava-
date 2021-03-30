package dam.server.demo.config;

import dam.server.demo.service.RunJsoupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class RunSoupPool implements ApplicationListener<ContextRefreshedEvent> {
    /**
       spring 服务启动后 循环判断线程池是否空余  max ：2  如果空余则执行新的网络请求 拿到执行数据
     */
     @Autowired
     private RunJsoupService runJsoupService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
            runJsoupService.run();
            runJsoupService.run();
    }
}
