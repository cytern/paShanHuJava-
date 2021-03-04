package dam.jsoup.updatereport.updatreport.vo;

import lombok.Data;

@Data
public class ServiceVo {
    /**
     * 服务id
     */
    private String serviceId;
    /**
     * host
     */
    private String host;
    /**
     * 端口
     */
    private String port;
    /**
     * url
     */
    private String url;
}
