package dam.server.demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {



    public static void main(String[] args) {
        String[] acc = {"adad","dadsa","dsadas","dasd"};
        List<String> ad = Arrays.stream(acc).filter(a -> a.contains("ad") && a.length() > 2).map(b -> b = b + b.length()).collect(Collectors.toList());
        System.out.println(ad);
    }


    class Run{
      private Run() {};
      

    }

}
