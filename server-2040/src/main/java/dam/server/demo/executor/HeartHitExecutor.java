package dam.server.demo.executor;


import dam.server.demo.service.RunJsoupService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
@AllArgsConstructor
public class HeartHitExecutor {
    private final ThreadPoolTaskExecutor taskExecutor;
    private final RunJsoupService runJsoupService;


    public void heartHitSend ()  {
        try {
            while (true) {
                //五分钟时间
                Thread.sleep(5*60*1000);

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
