package dam.jsoup.updatereport.updatreport.service.order.impl;


import dam.jsoup.updatereport.updatreport.dao.*;
import dam.jsoup.updatereport.updatreport.pojo.*;
import dam.jsoup.updatereport.updatreport.pojo.JsoupMissionAllHistory;
import dam.jsoup.updatereport.updatreport.util.MyResponse;
import dam.jsoup.updatereport.updatreport.vo.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
@Slf4j
public class GoodsSSService {
    private final GoodsMapper goodsMapper;
    private final JsoupUpDownMapper upDownMapper;
    private final OrderJsoupMaMapper orderJsoupMaMapper;
    private final OrderJsoupMhMapper orderJsoupMhMapper;
    private final JsoupCommentMapper commentMapper;
    private final JsoupArticleMapper articleMapper;
    private final JsoupUserDetailMapper detailMapper;
    private final JsoupMissionAllMapper maMapper;
    private final JsoupMissionAllHistoryMapper mhMapper;

    /**
     * 获取商品列表
     * @param searchGoodsVo
     * @param pageSize
     * @param index
     * @param type
     * @return
     */
    public List<GoodList> getGoodList(SearchGoodsVo searchGoodsVo, Integer pageSize, Integer index, Integer type){
        searchGoodsVo.resPageData(pageSize,index);
        List<GoodList>  list= new ArrayList<>();
        if (type == 1) {
            list = goodsMapper.getMaList(searchGoodsVo);
        }else {
            list = goodsMapper.getMhList(searchGoodsVo);
        }
        return list;
    }

    /**
     * 获取文章标题列表
     * @param articleSearchVo
     * @param pageSize
     * @param index
     * @return
     */
    public List<ArticleTitleVo> getArticleList(ArticleSearchVo articleSearchVo,Integer pageSize,Integer index) {
        articleSearchVo.resPageData(pageSize,index);
        List<ArticleTitleVo> articleTitleList = goodsMapper.getArticleTitleList(articleSearchVo);
        return  articleTitleList;
    }
    /**
     * 获取一个商品的评价列表
     * @param type
     * @param start
     * @param end
     * @param connectId
     * @return
     */
    public List<CommentVo> getCommentList(Integer type,Integer start,Integer end,Integer connectId){
        List<CommentVo> comment = goodsMapper.getComment(start, end, type, connectId);
        return comment;
    }

    /**
     * 获取文章详情
     * @param articleId
     * @return
     */
    public ArticleVo getArticleDetail(Integer articleId) {
        ArticleVo articleVo = new ArticleVo();
        JsoupArticle jsoupArticle = articleMapper.selectByPrimaryKey(articleId);
        JsoupUserDetailExample example = new JsoupUserDetailExample();
        example.createCriteria().andUserIdEqualTo(jsoupArticle.getUserId());
        JsoupUserDetail jsoupUserDetail = detailMapper.selectByExample(example).get(0);
        articleVo.setUserDetail(jsoupUserDetail);
        articleVo.setJsoupArticle(jsoupArticle);
        return articleVo;
    }
    /**
     * 发送评价
     * @return
     */
    public Map<String, Object> sendComment(String comment,Integer typeId,Integer connectId,Integer userId)  {
        JsoupCommentExample commentExample = new JsoupCommentExample();
        commentExample.createCriteria().andTypeIdEqualTo(typeId).andConnectIdEqualTo(connectId).andUserIdEqualTo(userId).andDeepEqualTo(0);
        JsoupComment jsoupComment = commentMapper.selectByExample(commentExample).get(0);
        if (jsoupComment == null) {
            jsoupComment = new JsoupComment();
            jsoupComment.setComment(comment);
            jsoupComment.setConnectId(connectId);
            jsoupComment.setDownNum(0);
            jsoupComment.setUpNum(0);
            jsoupComment.setTypeId(typeId);
            jsoupComment.setUserId(userId);
            jsoupComment.setDeep(0);
            commentMapper.insertSelective(jsoupComment);
        }else {
            jsoupComment.setComment(comment);
            commentMapper.updateByPrimaryKeySelective(jsoupComment);
        }
        return MyResponse.myResponseOk("评价成功");

    }
    /**
     * 点赞或者点踩
     * @param type
     * @param userId
     * @param connectId
     * @param upDown
     * @return
     */
    public Map<String,Object> sendUpOrDown (Integer type, Integer userId, Integer connectId, Integer upDown) {
        //我拥有这个？
        boolean b = doIHaveThis(type, userId, connectId);
        if (!b) {
            return MyResponse.myResponseError("无法修改非自身拥有的评价");
        }
        //获取
        if (upDown!=1&&upDown!=-1){
            return MyResponse.myResponseError("无效的参数");
        }
        JsoupUpDownExample example  = new JsoupUpDownExample();
        example.createCriteria().andTypeIdEqualTo(type).andUserIdEqualTo(userId).andConnectIdEqualTo(connectId);
        JsoupUpDown jsoupUpDown = upDownMapper.selectByExample(example).get(0);
        if (jsoupUpDown != null) {
            if (upDown.equals(jsoupUpDown.getUpDown())){
                return MyResponse.myResponseError("手速太快啦");
            }else {
                jsoupUpDown.setUpDown(upDown);
                upDownMapper.updateByPrimaryKey(jsoupUpDown);
                return MyResponse.myResponseOk("成功");
            }
        }else {
           JsoupUpDown jsoup = new JsoupUpDown();
           jsoup.setUpDown(upDown);
           jsoup.setConnectId(connectId);
           jsoup.setCreateTime(new Date());
           jsoup.setUserId(userId);
           jsoup.setTypeId(type);
           upDownMapper.insertSelective(jsoup);
           return MyResponse.myResponseOk("成功");
        }
    }

    /**
     * 设置订单评价
     * @param rate
     * @param type
     * @param connectId
     */
    public void setOrderRate (Integer rate, Integer type, Integer connectId) {
        if (type == 1){
            OrderJsoupMa orderJsoupMa = orderJsoupMaMapper.selectByPrimaryKey(connectId);
            if (orderJsoupMa != null) {
                orderJsoupMa.setScore(rate);
                orderJsoupMaMapper.updateByPrimaryKeySelective(orderJsoupMa);
                JsoupMissionAll jsoupMissionAll = maMapper.selectByPrimaryKey(orderJsoupMa.getMaId());
                BigDecimal nowRate = new BigDecimal(jsoupMissionAll.getMaRate());
                BigDecimal addOrDown = new BigDecimal(rate -5).divide(new BigDecimal(jsoupMissionAll.getMaSaleNum()));
                BigDecimal afterRate = nowRate.subtract(addOrDown);
                jsoupMissionAll.setMaRate(afterRate.toString());
                maMapper.updateByPrimaryKeySelective(jsoupMissionAll);
            }
        }else if (type == 2) {
            OrderJsoupMh orderJsoupMa = orderJsoupMhMapper.selectByPrimaryKey(connectId);
            if (orderJsoupMa != null) {
                orderJsoupMa.setScore(rate);
                orderJsoupMhMapper.updateByPrimaryKeySelective(orderJsoupMa);
                JsoupMissionAllHistory jsoupMissionAllHistory = mhMapper.selectByPrimaryKey(orderJsoupMa.getMhId());
                BigDecimal nowRate = new BigDecimal(jsoupMissionAllHistory.getSaleRate());
                BigDecimal addOrDown = new BigDecimal(rate -5).divide(new BigDecimal(jsoupMissionAllHistory.getSaleNum()));
                BigDecimal afterRate = nowRate.subtract(addOrDown);
                jsoupMissionAllHistory.setSaleRate(afterRate.toString());
                mhMapper.updateByPrimaryKeySelective(jsoupMissionAllHistory);
            }
        }
    }

    /**
     * 我是否拥有这个脚本/数据
     * @param type
     * @param userId
     * @param connectId
     * @return
     */
    public boolean doIHaveThis(Integer type, Integer userId, Integer connectId) {
        if (type == 1){
            OrderJsoupMaExample maExample = new OrderJsoupMaExample();
            maExample.createCriteria().andCustomerUserIdEqualTo(userId).andOrderIdEqualTo(connectId);
            OrderJsoupMa orderJsoupMa = orderJsoupMaMapper.selectByExample(maExample).get(0);
            if (orderJsoupMa == null) {
                return false;
            }else {
                return true;
            }
        }else if (type ==2) {
            OrderJsoupMhExample mhExample  = new OrderJsoupMhExample();
            mhExample.createCriteria().andCustomerUserIdEqualTo(userId).andOrderIdEqualTo(connectId);
            OrderJsoupMh orderJsoupMh = orderJsoupMhMapper.selectByExample(mhExample).get(0);
            if (orderJsoupMh == null) {
                return false;
            }else {
                return true;
            }
        }else if (type == 3){
             //评论随便点赞或者点踩
                return true;
        }else if(type == 4){
            //帖子随便点
            return true;
        }else {
            return false;
        }

    }

}

