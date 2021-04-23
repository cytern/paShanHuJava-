package dam.server.demo.controller;

import dam.server.demo.config.ConfigBean;
import dam.server.demo.pojo.JsoupSetting;
import dam.server.demo.service.RunJsoupService;
import dam.server.demo.utils.SettinglUtil;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
        map.put("taskExecutor",taskExecutor);
        map.put("configBean",configBean);
       return map;
    }
    @GetMapping("setConfig")
    @ResponseBody
    public Map<String,Object> setConfig(@RequestBody ConfigBean configBean) {
        JsoupSetting jsoupSetting = configBean.getJsoupSetting();
        SettinglUtil settinglUtil = new SettinglUtil();
        settinglUtil.setSettingMap(jsoupSetting);
        this.configBean.setJsoupSetting(jsoupSetting);
        Map<String,Object> map = new HashMap<>();
        map.put("code","success");
        map.put("msg","修改成功");
        return map;
    }
}
