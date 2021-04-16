package dam.jsoup.updatereport.updatreport;

import dam.jsoup.updatereport.updatreport.util.CronUtil;

public class CronTest {
    public static void main(String[] args) {
        boolean b = CronUtil.canAdd("0 0 8 * * ?");
        System.out.println(b);
    }
}
