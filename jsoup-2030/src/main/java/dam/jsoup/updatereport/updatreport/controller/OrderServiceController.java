package dam.jsoup.updatereport.updatreport.controller;

import dam.jsoup.updatereport.updatreport.pojo.JsoupMissionAllHistory;
import dam.jsoup.updatereport.updatreport.service.JsoupActionService;
import dam.jsoup.updatereport.updatreport.service.JsoupMissionService;
import dam.jsoup.updatereport.updatreport.util.MyResponse;
import dam.jsoup.updatereport.updatreport.util.PageHelper;
import dam.jsoup.updatereport.updatreport.vo.MissionAllData;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.*;


/**
 * 用户 与 脚本连接处 服务
 */
@RestController
@Slf4j
public class OrderServiceController {
  private final JsoupActionService actionService;
  private final JsoupMissionService missionService;
    public OrderServiceController(JsoupActionService actionService, JsoupMissionService missionService) {
        this.actionService = actionService;
        this.missionService = missionService;
    }

    /**
     * 获取个人的mission 列表
     * @return 需要登录 在网关处进行鉴权并且赋值
     */
    @GetMapping("customer/getMyOrders/{pageSize}/{index}")
    @ResponseBody
    Map  getMyMissions(@PathVariable("index")Integer index,@PathVariable("pageSize") Integer pageSize) {
        log.info("************ 获取个人可使用脚本列表***************");
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
       Integer userId = Integer.valueOf(request.getHeader("userId"));
        Map map = new HashMap();
        List<MissionAllData> list = new ArrayList<>();
        try {
            list = missionService.getOnesOrder(userId);
            map = PageHelper.page(list,pageSize,index,"missionData");
        } catch (Exception e) {
           log.error("获取个人可使用脚本列表 错误 ",e);
           map = MyResponse.myResponseError("获取信息失败");
        }
        return map;
    }

    /**
     * 获取全部执行过历史
     * @return 历史情况
     */
    @GetMapping("customer/getMyMissionHistory/{pageSize}/{index}")
    @ResponseBody
    Map getMyMissionsHistory (@PathVariable("index")Integer index,@PathVariable("pageSize") Integer pageSize) {
        log.info("************ 获取个人已执行过脚本历史列表***************");
        //获取userId
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        Integer userId = Integer.valueOf(request.getHeader("userId"));
        Map map = new HashMap();
        List<JsoupMissionAllHistory> list = new ArrayList<>();
        try {
            list = missionService.getMissionAllHistory(userId);
            map = PageHelper.page(list,pageSize,index,"missionHistory");
        } catch (Exception e) {
            log.error("************ 获取个人已执行过脚本历史 失败***************",e);
            map = MyResponse.myResponseError("获取信息失败");
        }
        return map;
    }

    /**
     * 获取一个脚本的全部信息
     * @param missionAllId 总id
     * @return 一个脚本的全部信息
     */
    @GetMapping("customer/getScript/{missionAllId}")
    @ResponseBody
    Map getOneScript(@PathVariable("missionAllId")Integer missionAllId) {
        log.info("************ 获取一个脚本的信息***************");
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        Integer userId = Integer.valueOf(request.getHeader("userId"));
        Map map = new HashMap();
        MissionAllData missionAllData = new MissionAllData();
        try {
            missionAllData = missionService.getMissionAllData(missionAllId, userId);
            map = MyResponse.myResponseOk("获取成功");
            map.put("missionData",missionAllData);
        } catch (Exception e) {
            log.error("************ 获取一个脚本的信息 失败***************",e);
            map = MyResponse.myResponseError("获取信息失败");
        }
        return map;
    }

    @PostMapping("customer/saveMyScript")
    @ResponseBody
    Map saveMyScript(@RequestBody MissionAllData missionAllData){
        log.info("************ 保存脚本信息***************");
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        Integer userId = Integer.valueOf(request.getHeader("userId"));
        Map map = new HashMap();
        try {
            Integer maId = missionService.saveMissionAll(missionAllData,userId);
            map = MyResponse.myResponseOk("保存成功");
            map.put("maId",maId);
        } catch (Exception e) {
            log.error("************ 保存脚本信息 失败***************",e);
            map = MyResponse.myResponseError("保存失败");
        }
        return map;
    }
}
