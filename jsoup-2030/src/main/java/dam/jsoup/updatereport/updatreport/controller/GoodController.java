package dam.jsoup.updatereport.updatreport.controller;

import dam.jsoup.updatereport.updatreport.service.order.GoodService;
import dam.jsoup.updatereport.updatreport.service.order.impl.GoodsListService;
import dam.jsoup.updatereport.updatreport.util.MyResponse;
import dam.jsoup.updatereport.updatreport.vo.CommentVo;
import dam.jsoup.updatereport.updatreport.vo.GoodList;
import dam.jsoup.updatereport.updatreport.vo.PageSizeVo;
import dam.jsoup.updatereport.updatreport.vo.SearchGoodsVo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@Slf4j
@AllArgsConstructor
public class GoodController {
    private final GoodService goodService;
    private final GoodsListService goodsListService;


    @PostMapping("customer/getGoodDetailComment/{id}/{type}/{pageSize}/{index}")
   public Map getComment(@PathVariable("id")Integer id,
                         @PathVariable("type") Integer type,
                         @PathVariable("pageSize") Integer pageSize,
                         @PathVariable("index") Integer index) {
        log.info("*********************开始获取商品评价*************************");
        Map map = new HashMap();
        PageSizeVo pageSizeVo = new PageSizeVo(index,pageSize);
        try {
            if (type.equals(1)){
                List<CommentVo> maComment = goodService.getMaComment(id, pageSizeVo.getPre(), pageSizeVo.getLast());
                map = MyResponse.myResponseOk("查询成功");
                map.put("list",maComment);
            }else {
                List<CommentVo> mhComment = goodService.getMhComment(id, pageSizeVo.getPre(), pageSizeVo.getLast());
                map = MyResponse.myResponseOk("查询成功");
                map.put("list",mhComment);
            }
        } catch (Exception e) {
            log.error("*********************获取商品评价失败*************************",e);
           map = MyResponse.myResponseError("系统内部异常");
        }
        return map;

    }

    @PostMapping("customer/getGoodsList/{pageSize}/{index}/{type}")
    public Map<String, Object> getList(@PathVariable Integer pageSize,
                                  @PathVariable Integer index,
                                  @PathVariable Integer type,
                                  @RequestBody SearchGoodsVo searchGoodsVo ) {
        log.info("************ 获取商品列表***************");
//        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
//        Integer userId = Integer.valueOf(request.getHeader("userId"));
        Integer userId = 4;
        searchGoodsVo.setCurrentUser(userId);
        List<GoodList> list = new ArrayList<>();
        Map map = new HashMap();
        try {
            list = goodsListService.getList(searchGoodsVo, pageSize, index, type);
           map = MyResponse.myResponseOk("成功");
        } catch (Exception e) {
            map = MyResponse.myResponseError("系统内部异常");
            log.error("查询商品列表错误",e);
        }
        map.put("list",list);
        return map;
    }
}
