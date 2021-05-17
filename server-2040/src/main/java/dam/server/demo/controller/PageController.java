package dam.server.demo.controller;

import dam.server.demo.config.ConfigBean;
import dam.server.demo.pojo.Executor;
import dam.server.demo.pojo.JsoupSetting;
import dam.server.demo.service.RunJsoupService;
import dam.server.demo.utils.SettinglUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : dam
 * @description :
 * @create :2021-04-22 15:45:00
 */
@Controller
public class PageController {
    private final ThreadPoolTaskExecutor taskExecutor;
    private final RunJsoupService runJsoupService;

    public PageController(@Qualifier("taskExecutor") ThreadPoolTaskExecutor taskExecutor, RunJsoupService runJsoupService) {
        this.taskExecutor = taskExecutor;
        this.runJsoupService = runJsoupService;
    }

    @GetMapping("index")
    public String backIndex (Model model) {
        ConfigBean configBean = ConfigBean.getInstance();
        model.addAttribute("title","管理核心");
        model.addAttribute("config",configBean);
        model.addAttribute("liveNum",taskExecutor.getActiveCount());
        return "setting";
    }

    @GetMapping("getConfig")
    @ResponseBody
    public Map<String,Object> getConfig() {
        ConfigBean configBean = ConfigBean.getInstance();
        Map<String,Object> map = new HashMap<>();
        map.put("runStatus",taskExecutor.getActiveCount()==0?0:taskExecutor.getActiveCount()*20);
        map.put("serveStatus",configBean.getStatus()==null?0:configBean.getStatus()*20);
        map.put("jsoupSetting",configBean.getJsoupSetting());
        map.put("live",configBean.getLive());
        return map;
    }
    @PostMapping("setConfig")
    @ResponseBody
    public Map<String,Object> setConfig(@RequestBody ConfigBean configBean) {
        ConfigBean sysConfigBean = ConfigBean.getInstance();
        JsoupSetting jsoupSetting = configBean.getJsoupSetting();
        Executor executor = jsoupSetting.getExecutor();
        executor.setExecutorUrl(executor.getExecutorUrl()+ "\\" + "chromedriver.exe");
        jsoupSetting.setExecutor(executor);
        SettinglUtil settinglUtil = new SettinglUtil();
        settinglUtil.setSettingMap(jsoupSetting);
        sysConfigBean.setJsoupSetting(jsoupSetting);
        Map<String,Object> map = new HashMap<>();
        map.put("code","success");
        map.put("msg","修改成功");
        return map;
    }
}
