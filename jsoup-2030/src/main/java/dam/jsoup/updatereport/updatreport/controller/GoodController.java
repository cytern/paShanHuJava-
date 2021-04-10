package dam.jsoup.updatereport.updatreport.controller;

import dam.jsoup.updatereport.updatreport.service.order.GoodService;
import dam.jsoup.updatereport.updatreport.util.MyResponse;
import dam.jsoup.updatereport.updatreport.vo.CommentVo;
import dam.jsoup.updatereport.updatreport.vo.PageSizeVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class GoodController {
    private final GoodService goodService;

    public GoodController(GoodService goodService) {
        this.goodService = goodService;
    }

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
}
