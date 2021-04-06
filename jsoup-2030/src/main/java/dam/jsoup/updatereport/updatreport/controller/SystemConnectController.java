package dam.jsoup.updatereport.updatreport.controller;

import dam.jsoup.updatereport.updatreport.service.ConnectSoupSystemService;
import dam.jsoup.updatereport.updatreport.service.JsoupMissionService;
import dam.jsoup.updatereport.updatreport.vo.HttpMissionDataVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class SystemConnectController {
    private final ConnectSoupSystemService soupSystemService;


    public SystemConnectController(ConnectSoupSystemService soupSystemService) {
        this.soupSystemService = soupSystemService;

    }

    /**
     * 获取服务
     * @param code
     * @return
     */
    @PostMapping("system/getOneTask")
    @ResponseBody
    public HttpMissionDataVo getOneTask(@RequestParam("code")String code){
        log.info("  执行器  编码 code =[{}]  发送请求 期望获取待执行脚本 ",code);
        HttpMissionDataVo oneWaitService = soupSystemService.getOneWaitService();
        return oneWaitService;
    }
    @PostMapping("system/sentTaskResult")
    public void storeTask(@RequestBody HttpMissionDataVo httpMissionDataVo) {
        log.info(" 执行器  返回执行成功数据  vo=[{}]",httpMissionDataVo);
        soupSystemService.storeBackData(httpMissionDataVo);
    }
}
