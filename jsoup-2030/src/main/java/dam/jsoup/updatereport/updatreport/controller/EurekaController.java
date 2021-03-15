package dam.jsoup.updatereport.updatreport.controller;

import dam.jsoup.updatereport.updatreport.util.MyResponse;
import dam.jsoup.updatereport.updatreport.vo.ServiceVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Scope
@RestController
@Slf4j
public class EurekaController {
    private final DiscoveryClient discoveryClient;

    public EurekaController(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    @GetMapping("system/discovery")
    @ResponseBody
    public Map<String,Object> getServices() {
        log.info("获取微服务存活列表");

        List<String> services = discoveryClient.getServices();
        Map<String,Object> map = MyResponse.myResponseOk("获取成功");
        map.put("services",services);
        List<Map> servicesMap = new ArrayList<>();
        for (String service : services) {
                Map map1 = new HashMap();
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            List<ServiceVo> serviceVos = new ArrayList<>();
            for (ServiceInstance instance : instances) {
                   ServiceVo serviceVo = new ServiceVo();
                   serviceVo.setHost(instance.getHost());
                   serviceVo.setPort(String.valueOf(instance.getPort()));
                   serviceVo.setUrl(instance.getUri().toString());
                   serviceVo.setServiceId(instance.getServiceId());
                   serviceVos.add(serviceVo);
            }
            map.put("instances",instances);
            map.put("service",service);
            map.put("serviceVos",serviceVos);
            servicesMap.add(map1);
        }
        log.info("获取微服务存活列表成功  返回值=[{}]",servicesMap.toString());
        return map;
    }

}
