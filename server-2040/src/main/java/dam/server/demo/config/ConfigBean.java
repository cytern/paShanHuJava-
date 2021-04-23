package dam.server.demo.config;

import dam.server.demo.pojo.JsoupSetting;
import dam.server.demo.utils.ExecCmd;
import dam.server.demo.utils.SettinglUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 配置类 外来也许加入配置文件
 */
@Configuration
@Slf4j
public class ConfigBean {

    /**
     * 总地址
     */
    private final String baseUrl = "http://62.234.29.109:2060";
    /**
     * cpu核心参数
     */
    private final String cpuCoreId;
//    private final String baseUrl = "http://localhost:2060";
    /**
     *
     */
    private Integer live;
    /**
     * 运行状况
     */
    private Integer status;
    private JsoupSetting jsoupSetting;

    /**
     * 构造方法内初始化cpu参数
     */
    public ConfigBean() {
        log.info("*****************加载系统环境数据*****************");
        ExecCmd execCmd = new ExecCmd("wmic csproduct get uuid");
        SettinglUtil settinglUtil = new SettinglUtil();
        execCmd.run();
        this.cpuCoreId = execCmd.getComment().get(1).replaceAll("[ \t\n]*", "");
        JsoupSetting settingMap = settinglUtil.getSettingMap();
        this.jsoupSetting = settingMap;
        log.info("*****************加载系统环境数据完毕*****************加载参数=[{}]",jsoupSetting);
    }

    public JsoupSetting getJsoupSetting() {
        return jsoupSetting;
    }

    public void setJsoupSetting(JsoupSetting jsoupSetting) {
        this.jsoupSetting = jsoupSetting;
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getLive() {
        return live;
    }

    public void setLive(Integer live) {
        this.live = live;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getCpuCoreId() {
        return cpuCoreId;
    }

    public String getGetTask() {
        /**
         * 获取任务数据的信息
         */
        return baseUrl + "/server/system/getOneTask";
    }

    public String getReturnTask() {
        /**
         * 返回任务数据的信息
         */
        return baseUrl + "/server/system/sentTaskResult";
    }

    /**
     * 心跳包地址
     */
    public String getHeartPag() {
        return baseUrl + "/server/system/heartHit";
    }
}
