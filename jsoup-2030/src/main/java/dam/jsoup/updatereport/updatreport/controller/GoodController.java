package dam.jsoup.updatereport.updatreport.controller;

import dam.jsoup.updatereport.updatreport.service.order.GoodService;
import dam.jsoup.updatereport.updatreport.service.order.impl.GoodsSSService;
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
    private final GoodsSSService goodsSSService;


    @PostMapping("customer/getGoodDetailComment/{id}/{type}/{pageSize}/{index}")
   public Map getComment(@PathVariable("id")Integer id,
                         @PathVariable("type") Integer type,
                         @PathVariable("pageSize") Integer pageSize,
                         @PathVariable("index") Integer index) {
        log.info("*********************开始获取商品评价*************************");
        Map map = new HashMap();
        PageSizeVo pageSizeVo = new PageSizeVo(index,pageSize);

        try {
            List<CommentVo> maComment = goodsSSService.getCommentList(type,pageSizeVo.getPre(),pageSizeVo.getLast(),id);
            map = MyResponse.myResponseOk("查询成功");
            map.put("list",maComment);
        } catch (Exception e) {
            map = MyResponse.myResponseError("查询评价列表失败");
            log.error("查询评价列表失败",e);
        }

        return map;

    }

    @PostMapping("customer/getGoodsList/{pageSize}/{index}/{type}")
    public Map<String, Object> getGoodList(@PathVariable Integer pageSize,
                                           @PathVariable Integer index,
                                           @PathVariable Integer type,
                                           @RequestBody SearchGoodsVo searchGoodsVo ) {
        log.info("************ 获取商品列表***************");
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        Integer userId = Integer.valueOf(request.getHeader("userId"));
        searchGoodsVo.setCurrentUser(userId);
        List<GoodList> list = new ArrayList<>();
        Map map = new HashMap();
        try {
            list = goodsSSService.getGoodList(searchGoodsVo, pageSize, index, type);
           map = MyResponse.myResponseOk("成功");
        } catch (Exception e) {
            map = MyResponse.myResponseError("系统内部异常");
            log.error("查询商品列表错误",e);
        }
        map.put("list",list);
        return map;
    }
    @PostMapping("customer/sendUpOrDown/{type}/{connectId}/{upDown}")
    public Map<String, Object> sendUpOrDown(@PathVariable Integer type,
                                            @PathVariable Integer connectId,
                                            @PathVariable Integer upDown) {
        log.info("************ 用户点赞 或者点踩 ***************");
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        Integer userId = Integer.valueOf(request.getHeader("userId"));
        Map<String, Object> map = null;
        try {
            map = goodsSSService.sendUpOrDown(type, userId, connectId, upDown);
        } catch (Exception e) {
            map = MyResponse.myResponseError("评价失败");
            log.error("评价失败",e);
        }
        return map;

    }


}
