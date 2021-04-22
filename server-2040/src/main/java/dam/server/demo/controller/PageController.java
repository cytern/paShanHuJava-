package dam.server.demo.controller;

import dam.server.demo.config.ConfigBean;
import dam.server.demo.service.RunJsoupService;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : dam
 * @description :
 * @create :2021-04-22 15:45:00
 */
@Controller
@AllArgsConstructor
public class PageController {

    private final ConfigBean configBean;
    private final ThreadPoolTaskExecutor taskExecutor;
    private final RunJsoupService runJsoupService;

    @GetMapping("index")
    public String backIndex (Model model) {
        model.addAttribute("title","管理核心");
        model.addAttribute("config",configBean);
        model.addAttribute("liveNum",taskExecutor.getActiveCount());
        return "setting";
    }

    @GetMapping("getConfig")
    @ResponseBody
    public Map<String,Object> getConfig() {
        Map<String,Object> map = new HashMap<>();
        map.put("runStatus",taskExecutor.getActiveCount()==0?0:taskExecutor.getActiveCount()*20);
        map.put("serveStatus",configBean.getStatus()==null?0:configBean.getStatus()*20);
       map.put("workStatus",configBean.getPoolSize()==null?0:configBean.getPoolSize()*20);
       map.put("live",configBean.getLive());
       return map;
    }
}
