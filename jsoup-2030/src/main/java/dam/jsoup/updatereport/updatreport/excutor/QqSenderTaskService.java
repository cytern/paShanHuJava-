package dam.jsoup.updatereport.updatreport.excutor;

import cn.hutool.core.date.DateUtil;
import dam.jsoup.updatereport.updatreport.config.Dict;
import dam.jsoup.updatereport.updatreport.robot.dto.QqTimeTask;
import dam.jsoup.updatereport.updatreport.robot.dto.QqTimeTaskDao;
import dam.jsoup.updatereport.updatreport.robot.dto.QqTimeTaskExample;
import dam.jsoup.updatereport.updatreport.util.CronUtil;
import dam.jsoup.updatereport.updatreport.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.support.CronSequenceGenerator;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
@Slf4j
public class QqSenderTaskService {
    private final RedisUtil redisUtil;
    private final QqTimeTaskDao qqTimeTaskDao;
    public QqSenderTaskService(RedisUtil redisUtil, QqTimeTaskDao qqTimeTaskDao) {
        this.redisUtil = redisUtil;
        this.qqTimeTaskDao = qqTimeTaskDao;
    }


    @Async("taskPool")
    public void jundgeQqTimerTask() {
        log.info("初始化 开始检索qq定时任务 ");
        while (true) {
            try {
                Thread.sleep(60 * 1000);
                log.info("等待结束 开始检索执行池  ");
                checkExcutor();
                Thread.sleep(60 * 1000);
            } catch (Exception e) {
                log.error("检索执行池  失败 ",e);
            }
        }
    }

    //发现任务
    public void checkExcutor() {
        //获取所有定时任务
        QqTimeTaskExample qqTimeTaskExample = new QqTimeTaskExample();
        qqTimeTaskExample.createCriteria().andTimesNotEqualTo(0);
        List<QqTimeTask> taskList = qqTimeTaskDao.selectByExample(qqTimeTaskExample);
        if (taskList == null || taskList.size()<1) {
            return;
        }
        //筛选出需要进行操作的定时任务
        List<QqTimeTask> needDoTask = taskList.stream().parallel().filter(t -> {
            if (redisUtil.hasKey(Dict.RedisKey.TimeSave + t.getId())) {
                //最近五分钟添加过发送任务
                return false;
            } else {
                return CronUtil.canAdd(t.getCron());
            }
        }).collect(Collectors.toList());
        //对定时任务进行遍历 并标记增加
        needDoTask.forEach(t -> {
            //向redis中注册
            redisUtil.sAdd(Dict.RedisKey.TimeSave + t.getId(), DateUtil.now());
            redisUtil.expire(Dict.RedisKey.TimeSave + t.getId(),3, TimeUnit.MINUTES);
            //向任务中心中注册
            redisUtil.lLeftPush(Dict.RedisKey.TimeTask + t.getCreateBy(),t);
            //判断次数是否需要减少
            if (t.getTimes() > 0) {
                //需要减少
                t.setTimes(t.getTimes()-1);
                //更新一下数据库
                qqTimeTaskDao.updateByPrimaryKey(t);
            }
        });
        System.out.println("111");

    }

    /**
     * 是否需要添加为定时任务 前后一分钟
     * @param sendTime
     * @param corn
     * @return
     */
    public static boolean needAdd(Date sendTime,String corn) {
        final CronSequenceGenerator g = new CronSequenceGenerator(corn);
        Date next = g.next(sendTime);
        //判断next 的日期 是否在五分钟之内
        Calendar c1=Calendar.getInstance();
        Calendar c2=Calendar.getInstance();
        Calendar c3= Calendar.getInstance();
        Date nowDate = new Date();
        //next 日期
        c1.setTime(next);
        //现在日期
        c2.setTime(nowDate);
        //if after than add
        if (c1.before(c2)){
            return true;
        }else {
            return false;
        }

    }



}
