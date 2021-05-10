package dam.jsoup.updatereport.updatreport.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author : dam
 * @description :
 * @create :2021-05-10 14:54:00
 */
@RestController
@RequestMapping("manager")
public class ManagerController {

    @GetMapping("getAllExecutors")
    public Map<String, Object> getAllExecutor() {
        return null;
    }

}
