package dam.jsoup.updatereport.updatreport.service.order.impl;

import dam.jsoup.updatereport.updatreport.dao.HandMapper;
import dam.jsoup.updatereport.updatreport.service.order.GoodService;
import dam.jsoup.updatereport.updatreport.vo.CommentVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品相关服务
 */
@Service
@Slf4j
public class GoodServiceImpl implements GoodService {

   private final HandMapper handMapper;

    public GoodServiceImpl(HandMapper handMapper) {
        this.handMapper = handMapper;
    }


    /**
     * 获取数据的评论
     *
     * @param mhId
     * @return 评论
     */
    @Override
    public List<CommentVo> getMhComment(Integer mhId,Integer pre,Integer last) {
        return handMapper.getMhComment(mhId,pre,last);
    }

    /**
     * 获取脚本的评论
     *
     * @param maId
     * @return 评论
     */
    @Override
    public List<CommentVo> getMaComment(Integer maId,Integer pre,Integer last) {
        return handMapper.getMaComment(maId, pre, last);
    }
}
