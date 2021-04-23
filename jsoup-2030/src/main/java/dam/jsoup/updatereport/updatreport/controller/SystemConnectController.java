package dam.jsoup.updatereport.updatreport.controller;

import dam.jsoup.updatereport.updatreport.service.ConnectSoupSystemService;
import dam.jsoup.updatereport.updatreport.util.MyResponse;
import dam.jsoup.updatereport.updatreport.vo.HttpMissionDataVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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
    public HttpMissionDataVo getOneTask(@RequestParam("code")String code,@RequestParam("token") String token){
        log.info("  执行器  编码 code =[{}]  发送请求 期望获取待执行脚本 ",code);
        HttpMissionDataVo oneWaitService = soupSystemService.getOneWaitService(code,token);
        return oneWaitService;
    }
    @PostMapping("system/sentTaskResult")
    public void storeTask(@RequestBody HttpMissionDataVo httpMissionDataVo) {
        log.info(" 执行器  返回执行成功数据  vo=[{}]",httpMissionDataVo);
        soupSystemService.storeBackData(httpMissionDataVo);
    }

    @PostMapping("system/heartHit/{code}/{token}")
    public Map heartHit(@PathVariable String code, @PathVariable String token) {
        Map map = new HashMap();
        try {
             map = soupSystemService.heartHit(code, token);
        } catch (Exception e) {
            log.error("心跳失败",e);
           return MyResponse.myResponseError(e.toString());
        }
        return map;
    }
}
