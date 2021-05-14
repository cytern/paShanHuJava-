package dam.jsoup.updatereport.updatreport.controller;

import dam.jsoup.updatereport.updatreport.dao.GoodsMapper;
import dam.jsoup.updatereport.updatreport.pojo.JsoupExcutor;
import dam.jsoup.updatereport.updatreport.util.MyResponse;
import dam.jsoup.updatereport.updatreport.vo.JsoupMissionAllHistory;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@Slf4j
@AllArgsConstructor
public class IndexController {
   private final GoodsMapper goodsMapper;


   @PostMapping("customer/index/getHistory")
   public Map<String, Object> getOnesHistory () {
       log.info("************ 用户查询主页信息 执行历史***************");
       Map<String,Object> map = new HashMap<>();
       HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
       Integer userId = Integer.valueOf(request.getHeader("userId"));
       try {
           List<JsoupMissionAllHistory> onesHistory = goodsMapper.findOnesHistory(userId);
           map = MyResponse.myResponseOk("查询成功");
           map.put("list",onesHistory);
       } catch (Exception e) {
           map = MyResponse.myResponseError("查询失败");
           e.printStackTrace();
       }
       return map;
   }

    @PostMapping("customer/index/getExecutor")
    public Map<String, Object> getOnseExecutor () {
        log.info("************ 用户查询主页信息 执行器列表***************");
        Map<String,Object> map = new HashMap<>();
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        Integer userId = Integer.valueOf(request.getHeader("userId"));
        try {
            List<JsoupExcutor> list = goodsMapper.getJsoupExcutor(userId);
            map = MyResponse.myResponseOk("查询成功");
            map.put("list",list);
        } catch (Exception e) {
            map = MyResponse.myResponseError("查询失败");
            e.printStackTrace();
        }
        return map;
    }

}
