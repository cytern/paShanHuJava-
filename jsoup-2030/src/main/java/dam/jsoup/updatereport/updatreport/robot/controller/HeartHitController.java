package dam.jsoup.updatereport.updatreport.robot.controller;

import dam.jsoup.updatereport.updatreport.config.Dict;
import dam.jsoup.updatereport.updatreport.robot.dto.QqRot;
import dam.jsoup.updatereport.updatreport.robot.dto.QqTimeTask;
import dam.jsoup.updatereport.updatreport.robot.pojo.CommandData;
import dam.jsoup.updatereport.updatreport.robot.pojo.HeartHitData;
import dam.jsoup.updatereport.updatreport.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("robot")
public class HeartHitController {
    private final RedisUtil redisUtil;

    public HeartHitController(RedisUtil redisUtil) {
        this.redisUtil = redisUtil;
    }

    /**
     * 心跳包维持
     */
    @RequestMapping("heartHit")
    public List<CommandData> heartHitController(@RequestBody HeartHitData hitData) {
       saveRotData(hitData);
       return getTimeTask(hitData);
    }

    @RequestMapping("addTimeTask")
    public CommandData addTimeTask(@RequestBody QqTimeTask qqTimeTask) {
          redisUtil.lLeftPush(Dict.RedisKey.TimeTask + qqTimeTask.getCreateBy(),qqTimeTask);
          return null;
    }

    //获取定时任务信息
    private List<CommandData> getTimeTask(HeartHitData hitData) {
        List<QqTimeTask> qqTimeTasks = redisUtil.lRangeObject(Dict.RedisKey.TimeTask + hitData.getRotQQID(), 0, -1, QqTimeTask.class);
        //清空这个key
        redisUtil.delete(Dict.RedisKey.TimeTask + hitData.getRotQQID());
        ArrayList<CommandData> commandData1 = new ArrayList<>();
        for (QqTimeTask t : qqTimeTasks) {
            CommandData commandData = new CommandData();
            if (t == null) {
            } else {
                commandData.setType(t.getTargetType());
                commandData.setCommand(t.getCommand());
                commandData.setQqId(t.getTargetId());
                commandData.setGroupId(t.getTargetGroupId());
                commandData.setMessage(t.getMessage());
                commandData1.add(commandData);
            }
        }

        return commandData1;
    }

    //保存更新机器人信息
    private void saveRotData(HeartHitData hitData) {
        String robotKey = Dict.RedisKey.ROBOT;
        QqRot qqRot = redisUtil.hGet(robotKey, hitData.getRotQQID(),QqRot.class);
        if (qqRot == null) {
            //表里没有 新建一个
            qqRot = new QqRot();
            qqRot.setCpuId(hitData.getCpuId());
            qqRot.setCreateTime(new Date());
            qqRot.setLastLiveTime(new Date());
            qqRot.setQqId(hitData.getRotQQID());
            qqRot.setDelFlag(0);
        }else {
            //表里有 更新一下
            qqRot.setLastLiveTime(new Date());
        }
        redisUtil.hPut(robotKey, hitData.getRotQQID(), qqRot);
    }


}
