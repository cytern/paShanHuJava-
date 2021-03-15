package dam.zuul.gateway;

import lombok.SneakyThrows;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class test {
    public static void main(String[] args) {
//
        Thread thread = new Thread(){
            @Override
            public void run() {
               pong();
            }
        };
        thread.start();
        System.out.println("ping");

    }
    private static void pong(){
        System.out.println("pong");
    }


}
