package dam.jsoup.updatereport.updatreport.service.order.impl;


import dam.jsoup.updatereport.updatreport.dao.GoodsMapper;
import dam.jsoup.updatereport.updatreport.vo.GoodList;
import dam.jsoup.updatereport.updatreport.vo.SearchGoodsVo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class GoodsListService {
    private final GoodsMapper goodsMapper;

    public List<GoodList> getList(SearchGoodsVo searchGoodsVo,Integer pageSize,Integer index,Integer type){
        searchGoodsVo.resPageData(pageSize,index);
        List<GoodList>  list= new ArrayList<>();
        if (type == 1) {
            list = goodsMapper.getMaList(searchGoodsVo);
        }else {
            list = goodsMapper.getMhList(searchGoodsVo);
        }
        return list;
    }
}

