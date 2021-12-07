package dam.jsoup.updatereport.updatreport;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TestMatch {
    public static void main(String[] args) {
        String input = "查分 《Tennis Ryan》 11";
        String[] s = input.split(" ");
        //说明id 有空格 那他妈的要用“”才行
        StringBuilder a = new StringBuilder(s[0]);
        for (int i = 1; i < s.length; i++) {
            a.append(" ").append(s[i]);
        }
        String substring = a.substring(a.indexOf("《") + 1, a.indexOf("》"));
        System.out.println(substring);
        }

}
