package dam.server.demo;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import dam.server.demo.config.TaskThreadPoolConfig;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class,
        MybatisAutoConfiguration.class,
        DruidDataSourceAutoConfigure.class

})
//重写脚本执行器 使用线程池 维持两个脚本的执行 如果执行完毕 则发送网络请求 试图获得新的任务 间隔为30s
//@EnableEurekaClient
//@EnableFeignClients

@EnableAsync
@EnableConfigurationProperties({TaskThreadPoolConfig.class} )
public class JavaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaServerApplication.class, args);
    }

}
