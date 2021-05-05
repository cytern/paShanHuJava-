package dam.jsoup.updatereport.updatreport.controller;

import dam.jsoup.updatereport.updatreport.dao.JsoupComplaintMapper;
import dam.jsoup.updatereport.updatreport.pojo.JsoupComplaint;
import dam.jsoup.updatereport.updatreport.service.order.GoodService;
import dam.jsoup.updatereport.updatreport.service.order.impl.GoodsSSService;
import dam.jsoup.updatereport.updatreport.util.MyResponse;
import dam.jsoup.updatereport.updatreport.vo.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@Slf4j
@AllArgsConstructor
public class GoodController {
    private final GoodsSSService goodsSSService;
    private final JsoupComplaintMapper complaintMapper;


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

    @PostMapping("customer/sendComment/{typeId}/{connectId}")
    public Map<String, Object> sendComment(@PathVariable Integer typeId,
                                           @PathVariable Integer connectId,
                                           @RequestBody SendCommentRequest sendCommentRequest){
        log.info("************ 用户发送评论  ***************");
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        Integer userId = Integer.valueOf(request.getHeader("userId"));
        Map<String, Object> map = null;
        try {
            boolean b = goodsSSService.doIHaveThis(typeId, userId, connectId);
            if (!b) {
                return MyResponse.myResponseError("无法评价未购买的商品");
            }
            goodsSSService.setOrderRate(sendCommentRequest.getRate(),typeId,connectId);
            map = goodsSSService.sendComment(sendCommentRequest.getComment(), typeId, connectId, userId);
        } catch (Exception e) {
            map = MyResponse.myResponseError("发送评论失败");
            log.error("发送评论失败",e);
        }
        return map;
    }

    @PostMapping("customer/getArticleList/{index}/{pageSize}")
    public Map<String, Object> getArticleList(@RequestBody ArticleSearchVo articleSearchVo,
                                              @PathVariable Integer index,
                                              @PathVariable Integer pageSize){
        log.info("************ 获取文章列表  ***************");
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        Integer userId = Integer.valueOf(request.getHeader("userId"));
        Map<String, Object> map = null;
        try {
            map = MyResponse.myResponseOk("获取文章列表成功");
            List<ArticleTitleVo> articleList = goodsSSService.getArticleList(articleSearchVo, pageSize, index);
            map.put("list",articleList);
        } catch (Exception e) {
            map = MyResponse.myResponseError("获取文章列表失败");
            log.error("获取文章列表失败",e);
        }
        return map;
    }

    /**
     * 获取文章详情
     * @param articleId
     * @return
     */
    @PostMapping("customer/getArticleDetail/{articleId}")
    public Map<String, Object> getArticleDetail(@PathVariable Integer articleId){
        log.info("************ 获取文章详情  ***************");
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        Integer userId = Integer.valueOf(request.getHeader("userId"));
        Map<String, Object> map = null;
        try {
            map = MyResponse.myResponseOk("获取文章详情成功");
            ArticleVo articleDetail = goodsSSService.getArticleDetail(articleId);
            map.put("detail",articleDetail);
        } catch (Exception e) {
            map = MyResponse.myResponseError("获取文章详情失败");
            log.error("获取文章详情失败",e);
        }
        return map;
    }

    /**
     * 发送投诉
     * @param complaint
     * @return
     */
    @PostMapping("customer/sendComplaint")
    public Map<String, Object> sendComplaint (@RequestBody JsoupComplaint complaint){
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        Integer userId = Integer.valueOf(request.getHeader("userId"));
        Map<String, Object> map = null;
        boolean b = goodsSSService.doIHaveThis(Integer.valueOf(complaint.getTypeId()), userId, complaint.getConnectId());
        if (!b) {
            return MyResponse.myResponseError("不能投诉非购买项目");
        }
        complaint.setUserId(userId);
        complaint.setSentTime(new Date());
        complaint.setUpdateTime(new Date());
        complaint.setStatus("0");
        complaintMapper.insertSelective(complaint);
        return MyResponse.myResponseOk("投诉成功，将会尽快受理");
    }




}
