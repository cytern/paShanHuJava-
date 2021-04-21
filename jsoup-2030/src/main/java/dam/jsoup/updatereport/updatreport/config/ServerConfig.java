package dam.jsoup.updatereport.updatreport.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class ServerConfig {
    @Value("${dam.serverIp}")
   private String baseIp;
     @Value("${dam.checkDateTime}")
    private Integer checkDateT;

}
