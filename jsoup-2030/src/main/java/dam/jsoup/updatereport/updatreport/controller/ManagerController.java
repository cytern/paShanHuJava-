package dam.jsoup.updatereport.updatreport.controller;

import dam.jsoup.updatereport.updatreport.dao.*;
import dam.jsoup.updatereport.updatreport.pojo.*;
import dam.jsoup.updatereport.updatreport.util.MyResponse;
import dam.jsoup.updatereport.updatreport.util.PageHelper;
import dam.jsoup.updatereport.updatreport.vo.ServerStatusVo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : dam
 * @description :
 * @create :2021-05-10 14:54:00
 */
@RestController
@RequestMapping("manager")
@AllArgsConstructor
@Slf4j
public class ManagerController {
    private final JsoupExcutorMapper excutorMapper;
    private final JsoupUserDetailMapper userDetailMapper;
    private final JsoupMissionAllMapper missionAllMapper;
    private final JsoupMissionAllHistoryMapper historyMapper;
    private final JsoupComplaintMapper complaintMapper;
    private final HandMapper handMapper;


    /**
     * 查询执行器列表
     */
    @PostMapping("getAllExecutors/{index}/{pageSize}")
    public Map<String, Object> getAllExecutor(@PathVariable Integer index,@PathVariable Integer pageSize) {
        Map map = new HashMap();
        try {
            JsoupExcutorExample example = new JsoupExcutorExample();
            List<JsoupExcutor> excutors = excutorMapper.selectByExample(example);
            return PageHelper.page(excutors,pageSize,index,"list");
        } catch (Exception exception) {
            log.error("查询所有执行器错误",exception);
            map = MyResponse.myResponseError("查询失败 系统内部异常");
        }
        return map;
    }

    /**
     * 修改执行器
     */
    @PostMapping("updateAllExecutors")
    public Map<String, Object> updateAllExecutor(@RequestBody JsoupExcutor jsoupExcutor) {
        int i = excutorMapper.updateByPrimaryKeySelective(jsoupExcutor);
        if (i >0) {
            return MyResponse.myResponseOk("修改成功");
        }else {
            return MyResponse.myResponseError("修改失败");
        }
    }

    /**
     * 查询用户
     */
    @PostMapping("getAllUser/{index}/{pageSize}")
    public Map<String,Object> getAllUser(@PathVariable Integer index,@PathVariable Integer pageSize) {
        Map map = new HashMap();
        try {
            JsoupUserDetailExample detailExample = new JsoupUserDetailExample();
            List<JsoupUserDetail> jsoupUserDetails = userDetailMapper.selectByExample(detailExample);
            return PageHelper.page(jsoupUserDetails,pageSize,index,"list");
        } catch (Exception exception) {
            log.error("查询所有用户错误",exception);
            map = MyResponse.myResponseError("查询失败 系统内部异常");
        }
        return map;
    }
    /**
     * 修改用户
     */
    @PostMapping("updateAllUser")
    public Map<String, Object> updateUser(@RequestBody JsoupUserDetail jsoupUserDetail) {
        int i = userDetailMapper.updateByPrimaryKeySelective(jsoupUserDetail);
        if (i >0) {
            return MyResponse.myResponseOk("修改成功");
        }else {
            return MyResponse.myResponseError("修改失败");
        }
    }




    /**
     * 查询脚本
     */
    @PostMapping("getAllScript/{index}/{pageSize}")
    public Map<String,Object> getAllScript(@PathVariable Integer index,@PathVariable Integer pageSize) {
        Map map = new HashMap();
        try {
            JsoupMissionAllExample missionAllExample = new JsoupMissionAllExample();
            List<JsoupMissionAll> jsoupMissionAlls = missionAllMapper.selectByExample(missionAllExample);
            return PageHelper.page(jsoupMissionAlls,pageSize,index,"list");
        } catch (Exception exception) {
            log.error("查询所有脚本错误",exception);
            map = MyResponse.myResponseError("查询失败 系统内部异常");
        }
        return map;
    }
    /**
     * 修改脚本
     */
    @PostMapping("updateAllScript")
    public Map<String, Object> updateAllScript(@RequestBody JsoupMissionAll jsoupMissionAll) {
        int i = missionAllMapper.updateByPrimaryKeySelective(jsoupMissionAll);
        if (i >0) {
            return MyResponse.myResponseOk("修改成功");
        }else {
            return MyResponse.myResponseError("修改失败");
        }
    }

    /**
     * 查询数据
     */
    @PostMapping("getAllData/{index}/{pageSize}")
    public Map<String,Object> getAllData(@PathVariable Integer index,@PathVariable Integer pageSize) {
        Map map = new HashMap();
        try {
            JsoupMissionAllHistoryExample historyExample= new JsoupMissionAllHistoryExample();
            List<JsoupMissionAllHistory> jsoupMissionAllHistories = historyMapper.selectByExample(historyExample);
            return PageHelper.page(jsoupMissionAllHistories,pageSize,index,"list");
        } catch (Exception exception) {
            log.error("查询所有数据错误",exception);
            map = MyResponse.myResponseError("查询失败 系统内部异常");
        }
        return map;
    }
    /**
     * 修改数据
     */
    @PostMapping("updateAllData")
    public Map<String, Object> updateAllData(@RequestBody JsoupMissionAllHistory allHistory) {
        int i = historyMapper.updateByPrimaryKeySelective(allHistory);
        if (i >0) {
            return MyResponse.myResponseOk("修改成功");
        }else {
            return MyResponse.myResponseError("修改失败");
        }
    }



    /**
     * 查询投诉
     */
    @PostMapping("getAllComplaint/{index}/{pageSize}")
    public Map<String,Object> getAllComplaint(@PathVariable Integer index,@PathVariable Integer pageSize) {
        Map map = new HashMap();
        try {
            JsoupComplaintExample jsoupComplaintExample = new JsoupComplaintExample();
            List<JsoupComplaint> jsoupComplaints = complaintMapper.selectByExample(jsoupComplaintExample);
            return PageHelper.page(jsoupComplaints,pageSize,index,"list");
        } catch (Exception exception) {
            log.error("查询所有投诉错误",exception);
            map = MyResponse.myResponseError("查询失败 系统内部异常");
        }
        return map;
    }
    /**
     * 修改投诉
     */
    @PostMapping("updateAllComplaint")
    public Map<String, Object> updateAllComplaint(@RequestBody JsoupComplaint jsoupComplaint) {
        int i = complaintMapper.updateByPrimaryKeySelective(jsoupComplaint);
        if (i >0) {
            return MyResponse.myResponseOk("修改成功");
        }else {
            return MyResponse.myResponseError("修改失败");
        }
    }

    @PostMapping("getAllServerStatus")
    public Map<String, Object> getAllServerStatus () {
        Map map = new HashMap();
        try {
            List<JsoupExcutor> allLiveExcutor = handMapper.getAllLiveExcutor();
            ServerStatusVo serverStatusVo = new ServerStatusVo();
            serverStatusVo.setExcutors(allLiveExcutor);
            serverStatusVo.setLiveExecutor(allLiveExcutor.size());
            serverStatusVo.setWaitTodo(handMapper.getWaitExecutorNum());
            map  = MyResponse.myResponseOk("查询成功");
            map.put("data",serverStatusVo);
        } catch (Exception exception) {
            exception.printStackTrace();
            map = MyResponse.myResponseError("查询失败");
        }
        return map;

    }



    @PostMapping("getAllWaitToDo")
    public Map<String, Object> getAllWaitToDo () {
        Map map = new HashMap();
        try {
          JsoupMissionAllHistoryExample historyExample = new JsoupMissionAllHistoryExample();
          historyExample.createCriteria().andMissionStateEqualTo("1");
            List<JsoupMissionAllHistory> jsoupMissionAllHistories = historyMapper.selectByExample(historyExample);
            map.put("list",jsoupMissionAllHistories);
        } catch (Exception exception) {
            exception.printStackTrace();
            map = MyResponse.myResponseError("查询失败");
        }
        return map;

    }


}
