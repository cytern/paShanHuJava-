package dam.server.demo.utils;

import java.io.IOException;

/**
 * @author : dam
 * @description :启动默认浏览器 并且进入配置页面
 * @create :2021-05-10 10:17:00
 */
public class OpenWebUtil {
    /**
     * 启动浏览器
     */
    public void openWeb () {
        try {
            String url = "http://localhost:2040/index";
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
        } catch (NullPointerException | IOException e1) {
            // 此为uri为空时抛出异常
            e1.printStackTrace();
        }

    }
}
