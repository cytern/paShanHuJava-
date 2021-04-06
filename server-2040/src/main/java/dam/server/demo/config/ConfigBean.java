package dam.server.demo.config;

import dam.server.demo.utils.ExecCmd;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 配置类 外来也许加入配置文件
 */
@Configuration
@Slf4j
public class ConfigBean {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
    /**
     * 总地址
     */
//    private final String baseUrl = "http://62.234.29.109:2060";
    private final String baseUrl = "http://localhost:2060";
    /**
     * cpu核心参数
     */
    private final String cpuCoreId;

    /**
     * 构造方法内初始化cpu参数
     */
    public ConfigBean() {
        log.info("*****************加载系统环境数据*****************");
        ExecCmd execCmd = new ExecCmd("wmic csproduct get uuid");
        execCmd.run();
        this.cpuCoreId = execCmd.getComment().get(1).replaceAll("[ \t\n]*", "");
        log.info("*****************加载系统环境数据完毕*****************");
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
}
