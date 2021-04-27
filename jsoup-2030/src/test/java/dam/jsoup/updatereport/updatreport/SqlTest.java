package dam.jsoup.updatereport.updatreport;

import com.netflix.discovery.converters.Auto;
import dam.jsoup.updatereport.updatreport.dao.GoodsMapper;
import dam.jsoup.updatereport.updatreport.vo.GoodList;
import dam.jsoup.updatereport.updatreport.vo.SearchGoodsVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SqlTest {
    @Autowired
    private GoodsMapper goodsMapper;
    @Test
    void run () {
        SearchGoodsVo searchGoodsVo = new SearchGoodsVo();
        searchGoodsVo.setPageStart(0);
        searchGoodsVo.setPageEnd(10);
        List<GoodList> maList = goodsMapper.getMaList(searchGoodsVo);
        System.out.println(maList);
        List<GoodList> mhList = goodsMapper.getMhList(searchGoodsVo);
        System.out.println(mhList);
    }
}
