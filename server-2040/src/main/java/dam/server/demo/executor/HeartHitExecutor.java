package dam.server.demo.executor;


import dam.server.demo.config.ConfigBean;
import dam.server.demo.service.RunJsoupService;
import dam.server.demo.utils.HttpUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
@AllArgsConstructor
public class HeartHitExecutor {
    private final ThreadPoolTaskExecutor taskExecutor;
    private final RunJsoupService runJsoupService;

    @Async
    public void heartHitSend ()  {
        ConfigBean configBean = ConfigBean.getInstance();
        try {
            do {
                log.info("******** 开始发送心跳包 *********");
                Map<String, Object> map = null;
                //发送心跳包
                if (configBean.getJsoupSetting().getExecutor().getExecutorUrl() == null || configBean.getJsoupSetting().getExecutor().getExecutorUrl().equals("")) {
                    Thread.sleep(10 * 1000);
                    continue;
                }
                try {
                    map = HttpUtils.sendHeartHit(configBean.getHeartPag(), configBean.getCpuCoreId(), configBean.getJsoupSetting().getExecutor().getToken());
                    log.info("********* 心跳返回结果  *********** =[{}]", map);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (map != null) {
                    if ("success".equals(map.get("code"))) {
                        Integer status = (Integer) map.get("status");
                        for (int i = 0; i < status; i++) {
                            if (taskExecutor.getActiveCount() > 6) {
                                break;
                            } else {
                                runJsoupService.run();
                            }
                        }
                        configBean.setStatus(status);
                        configBean.setLive(1);
                    }
                } else {
                    configBean.setLive(0);
                }
                //五分钟时间 休眠
                Thread.sleep(2 * 60 * 1000);
            } while (true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
