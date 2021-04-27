package dam.jsoup.updatereport.updatreport.dao;

import dam.jsoup.updatereport.updatreport.vo.GoodList;
import dam.jsoup.updatereport.updatreport.vo.SearchGoodsVo;
import org.apache.ibatis.annotations.Mapper;
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
     List<GoodList> getMaList(SearchGoodsVo searchGoodsVo);

     List<GoodList> getMhList(SearchGoodsVo searchGoodsVo);
}
