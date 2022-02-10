package dam.jsoup.updatereport.updatreport;


import dam.jsoup.updatereport.updatreport.config.TaskThreadPoolConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
@EnableAsync
@EnableTransactionManagement
@EnableConfigurationProperties({TaskThreadPoolConfig.class} )
@EnableScheduling
public class UpdatreportApplication {

    public static void main(String[] args) {
        SpringApplication.run(UpdatreportApplication.class, args);
    }

}
