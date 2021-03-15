package dam.server.demo.controller;

import dam.server.demo.service.ExcutorService;
import dam.server.demo.vo.MissionAllData;
import dam.server.demo.vo.MyResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 执行器服务
 */
@RestController
@Slf4j
public class JsoupExcutorController {

    private final ExcutorService excutorService;

    public JsoupExcutorController(ExcutorService excutorService) {
        this.excutorService = excutorService;
    }


    /**
     * 接受执行服务
     * @param missionAllData 总任务参数
     * @return 执行完毕的结果集
     */
    @PostMapping("system/sendJsoup")
    @ResponseBody
    Map excutorJavaSoup(@RequestBody MissionAllData missionAllData){
        Map map = new HashMap();
        log.info("开始执行任务");
        try {
            List result = excutorService.doExcutor(missionAllData);
            map = MyResponse.myResponseOk("执行成功");
            map.put("result",result);
        } catch (Exception e) {
            log.error("有问题啊 你写的脚本 :   ******",e);
            map = MyResponse.myResponseError(e.getMessage());
        }
        return map;
    }
}
