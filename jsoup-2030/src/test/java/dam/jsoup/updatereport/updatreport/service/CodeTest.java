package dam.jsoup.updatereport.updatreport.service;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ShearCaptcha;

public class CodeTest {
    public static void main(String[] args) {
        ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(200, 100, 4, 4);
        String code = captcha.getCode();
        System.out.println(code);
    }
}
