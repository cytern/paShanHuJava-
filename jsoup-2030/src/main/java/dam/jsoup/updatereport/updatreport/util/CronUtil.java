package dam.jsoup.updatereport.updatreport.util;
import org.springframework.scheduling.support.CronSequenceGenerator;

import java.util.Calendar;
import java.util.Date;

public class CronUtil {
    /**
     * 是否需要添加为定时任务 前后一分钟
     * @param nowDate
     * @param corn
     * @return
     */
    public static boolean needAdd(Date nowDate,String corn) {
        final CronSequenceGenerator g = new CronSequenceGenerator(corn);
        Date next = g.next(nowDate);
         //判断next 的日期 是否在五分钟之内
        Calendar c1=Calendar.getInstance();
        Calendar c2=Calendar.getInstance();
        Calendar c3= Calendar.getInstance();
        //next 日期
        c1.setTime(next);
        //现在日期
        c2.setTime(nowDate);
        //五分钟后
        c3.setTime(nowDate);
        c3.add(Calendar.MINUTE,5);
        //在五分钟的域 则返回true 否则返回false
        if (c1.after(c2)&&c1.before(c3)){
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
        c3.add(Calendar.MINUTE,5);
//        两次间隔小于5分钟
        if (c3.before(c1)){
            return true;
        }else {
            return false;
        }
    }
}
