package dam.jsoup.updatereport.updatreport.service;

import dam.jsoup.updatereport.updatreport.dao.JsoupUserMapper;
import dam.jsoup.updatereport.updatreport.pojo.JsoupUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 测试in or out 的更新是否可以插入 负数的id值
 */

@SpringBootTest
public class TestIOUservice {
    @Autowired
    private JsoupUserMapper mapper;
    @Test
    void go(){
        JsoupUser jsoupUser = new JsoupUser();
        jsoupUser.setUserId(-1);
        jsoupUser.setUsername("wdasd");
        mapper.insertSelective(jsoupUser);
    }
}
