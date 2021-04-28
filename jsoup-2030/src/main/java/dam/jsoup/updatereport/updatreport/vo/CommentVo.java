package dam.jsoup.updatereport.updatreport.vo;

import dam.jsoup.updatereport.updatreport.pojo.JsoupComment;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

//用户评价Vo
@ToString(callSuper=true)
@EqualsAndHashCode(callSuper = true)
@Data
public class CommentVo extends JsoupComment {
//    用户名
    private String userName;
//   详情
    private String userDes;
//  等级
    private Integer userLever;
//下属楼中楼
    private List<CommentVo> sonList;

    /**
     * 根据deep 和fatherId 确立数组
     * @param originData
     * @return
     */
    public List<CommentVo> getCommentVo(List<CommentVo> originData) {
       //TODO
        return null;
    }
}
