package dam.jsoup.updatereport.updatreport;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TestMatch {
    public static void main(String[] args) {
        String input = "@231213213 查分 《Tennis Ryan》 11";
        String[] s = input.split(" ");
        //说明id 有空格 那他妈的要用“”才行
        StringBuilder a = new StringBuilder();
        for (int i = 1; i < s.length; i++) {
            a.append(s[i]).append(" ");
        }

        System.out.println(a);
        String[] s1 = a.toString().split(" ");
        System.out.println(a);
        }

}
