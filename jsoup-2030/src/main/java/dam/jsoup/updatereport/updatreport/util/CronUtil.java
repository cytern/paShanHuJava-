package dam.jsoup.updatereport.updatreport.util;
import org.springframework.scheduling.support.CronSequenceGenerator;

import java.util.Calendar;
import java.util.Date;

public class CronUtil {
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

    public static boolean canAdd(String corn) {
        final CronSequenceGenerator g = new CronSequenceGenerator(corn);
        Date date = new Date();
        Date next = g.next(date);
        Date nextNext = g.next(g.next(date));
        Calendar c1=Calendar.getInstance();
        Calendar c2=Calendar.getInstance();
        Calendar c3= Calendar.getInstance();
        c1.setTime(nextNext);
        c2.setTime(next);
        c3.setTime(next);
        c3.add(Calendar.MINUTE,2);
//        两次间隔小于5分钟
        if (c3.before(c1)){
            return true;
        }else {
            return false;
        }
    }
}
