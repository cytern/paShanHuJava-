package dam.server.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserServiceController {
    private final RestTemplate restTemplate;

    public UserServiceController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    private static final String REST_URL = "http://localhost:2030";
        @RequestMapping("server/everyone/getService")
    public Map getServices () {
        return restTemplate.getForObject(REST_URL+"/jsoup/discovery",Map.class);
    }

}
