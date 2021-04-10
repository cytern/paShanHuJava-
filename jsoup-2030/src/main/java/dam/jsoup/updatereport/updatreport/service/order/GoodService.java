package dam.jsoup.updatereport.updatreport.service.order;

import dam.jsoup.updatereport.updatreport.vo.CommentVo;

import java.util.List;

/**
 * 商品相关服务
 */
public interface GoodService {
    /**
     * 获取数据的评论
     * @return 评论
     */
    List<CommentVo> getMhComment(Integer mhId,Integer pre,Integer last);

    /**
     * 获取脚本的评论
     * @return 评论
     */
    List<CommentVo> getMaComment(Integer maId,Integer pre,Integer last);
}
