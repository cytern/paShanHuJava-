package com.kente.demo;

import com.kente.demo.pojo.Kentecom;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootTest
public class TestStream {
@Test
    void go() {
    List<Kentecom> list = new ArrayList<>();
    for (int i = 0; i < 13; i++) {
        for (int j = 0; j < 10; j++) {
            Kentecom kentecom = new Kentecom();
            kentecom.setMouth(i +1 + "月");
            kentecom.setType(String.valueOf(i) + "yue" + String.valueOf(j) + "日");
            list.add(kentecom);
        }
    }
    Map<String, List<Kentecom>> collectByMouth =list.stream().collect(Collectors.groupingBy(Kentecom::getMouth ,Collectors.toList()));
    System.out.println(collectByMouth.get("1月"));

}
}
