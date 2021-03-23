package dam.jsoup.updatereport.updatreport.controller;

import dam.jsoup.updatereport.updatreport.pojo.JsoupMissionAll;
import dam.jsoup.updatereport.updatreport.pojo.JsoupMissionAllHistory;
import dam.jsoup.updatereport.updatreport.service.JsoupActionService;
import dam.jsoup.updatereport.updatreport.service.JsoupMissionService;
import dam.jsoup.updatereport.updatreport.service.RunJavaSoup;
import dam.jsoup.updatereport.updatreport.util.MyResponse;
import dam.jsoup.updatereport.updatreport.util.PageHelper;
import dam.jsoup.updatereport.updatreport.vo.MissionAllData;
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
  private final RunJavaSoup runJavaSoup;

    public OrderServiceController(JsoupActionService actionService, JsoupMissionService missionService, RunJavaSoup runJavaSoup) {
        this.actionService = actionService;
        this.missionService = missionService;
        this.runJavaSoup = runJavaSoup;
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

    /**
     * 以后将使用rabbitMq 进行消息队列 但目前使用直接发布任务
     * 这一步接受 maid 添加一个序号为1的hisorder
     * @return
     */
      @PostMapping("customer/runJavaSoup/{maId}")
      @ResponseBody
      Map runJavaSoup(@PathVariable Integer maId){
         //执行
          log.info("************ 执行脚本***************");
          HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
          Integer userId = Integer.valueOf(request.getHeader("userId"));
          Map map = new HashMap();
          try {
              runJavaSoup.sendJavaSoup(maId,userId);
              map = MyResponse.myResponseOk("发送成功");
          }catch (Exception e){
              map = MyResponse.myResponseError(e.getMessage());
              log.error("方法执行错误 执行脚本 ",e);
          }
           return map;
      }

      @PostMapping("customer/setMissionAllState")
      Map setMissionAllState(@RequestBody JsoupMissionAll jsoupMissionAll){
          log.info("************ 设置任务状态***************");
          HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
          Integer userId = Integer.valueOf(request.getHeader("userId"));
          Map map = null;
          try {
              map = missionService.setMissionAllState(jsoupMissionAll, userId);
          } catch (Exception e) {
              map = MyResponse.myResponseError(e.getMessage());
              log.error("设置任务状态错误 执行脚本 ",e);
          }
          return map;
      }

    /**
     * 获取全部的可购总任务
     * @param pageSize  页码容量
     * @param index 页码
     * @return
     */
      @GetMapping("customer/getSalesMa/{pageSize}/{index}")
      Map getSalesMa(@PathVariable Integer pageSize,@PathVariable Integer index) {
          log.info("**************获取能够买的脚本列表****************");
          Map map = new HashMap();
          List<JsoupMissionAll> list = new ArrayList<>();
          try {
              list = missionService.getSalesMa();
              map = PageHelper.page(list,pageSize,index,"maList");
          } catch (Exception e) {
              log.error("************ 获取能够买的脚本列表 失败***************",e);
              map = MyResponse.myResponseError("获取信息失败");
          }
          return map;
      }


    /**
     * 获取全部的可购总结果
     * @param pageSize  页码容量
     * @param index 页码
     * @return
     */
        @GetMapping("customer/getSalesMh/{pageSize}/{index}")
    Map getSalesMh(@PathVariable Integer pageSize,@PathVariable Integer index) {
        log.info("**************获取能够买的结果列表****************");
        Map map = new HashMap();
        List<JsoupMissionAllHistory> list = new ArrayList<>();
        try {
            list = missionService.getSalesMh();
            map = PageHelper.page(list,pageSize,index,"mhList");
        } catch (Exception e) {
            log.error("************ 获取能够买的结果列表 失败***************",e);
            map = MyResponse.myResponseError("获取信息失败");
        }
        return map;
    }

    /**
     * 设置结果集的市场化信息
     * @param missionAllHistory
     * @return
     */
    @PostMapping("customer/setMhState")
    Map setMhState(@RequestBody JsoupMissionAllHistory missionAllHistory) {
        log.info("************ 设置结果集状态***************");
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        Integer userId = Integer.valueOf(request.getHeader("userId"));
        Map map = null;
        try {
            map = missionService.setMhState(missionAllHistory, userId);
        } catch (Exception e) {
            map = MyResponse.myResponseError(e.getMessage());
            log.error("设置结果集错误 执行脚本 ",e);
        }
        return map;
    }

    /**
     * 购买一个脚本
     * @param maId maId
     * @return
     */
    @PostMapping("customer/buy/{maId}")
    Map buyMa(@PathVariable Integer maId) {
        log.info("************ 购买脚本***************");
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        Integer userId = Integer.valueOf(request.getHeader("userId"));
        Map map = null;
        try {
            map = missionService.byMa(userId,maId);
        } catch (Exception e) {
            map = MyResponse.myResponseError(e.getMessage());
            log.error("购买失败,错误原因=[{}],用户id=[{}],maId =[{}]",e,userId,maId);
        }
        return map;
    }





}
