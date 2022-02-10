package dam.jsoup.updatereport.updatreport;

import dam.jsoup.updatereport.updatreport.util.CronUtil;

public class CronTest {
    public static void main(String[] args) {
        String testString = "1  2 3   5 ";
        String[] s = testString.split(" ");
        for (int i = 0; i < s.length; i++) {
            System.out.println("当前循环到第 " + i + " 个");
            System.out.println("值为 " + s[i]);
        }
    }
}
