package dam.jsoup.updatereport.updatreport.dao;

import dam.jsoup.updatereport.updatreport.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : dam
 * @description :商品相关脚本
 * @create :2021-04-27 14:46:00
 */
@Repository
@Mapper
public interface GoodsMapper {
     /**
      * 获取脚本列表
      * @param searchGoodsVo 查询体
      * @return 脚本列表
      */
     List<GoodList> getMaList(SearchGoodsVo searchGoodsVo);

     /**
      * 获取数据列表
      * @param searchGoodsVo 查询体
      * @return 数据列表
      */
     List<GoodList> getMhList(SearchGoodsVo searchGoodsVo);

     /**
      * 获取脚本详情
      * @param maId 脚本id
      * @return 商品详情
      */
     GoodDetailVo getMaDetail(Integer maId);

     /**
      * 获取数据详情
      * @param mhId 数据id
      * @return 数据信息
      */
     GoodDetailVo getMhDetail(Integer mhId);

     /**
      * 获取评价列表
      * @param start
      * @param end
      * @param type
      * @param connectId
      * @return
      */
     List<CommentVo> getComment(@Param("start") Integer start,@Param("end") Integer end,
                                 @Param("type") Integer type,@Param("connectId") Integer connectId);


     List<ArticleTitleVo> getArticleTitleList (ArticleSearchVo articleSearchVo);
}
