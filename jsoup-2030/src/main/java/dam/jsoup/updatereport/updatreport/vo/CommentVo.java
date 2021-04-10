package dam.jsoup.updatereport.updatreport.vo;

import lombok.Data;
//用户评价Vo
@Data
public class CommentVo {
//    用户id
    private Integer userId;
//    订单id
    private Integer orderId;
//    昵称
    private String userNickName;
//    等级
    private String lever;
//    书写评价日期
    private String sentTime;
//    评价内容
    private String commentDes;
//    用户简介
    private String userDes;
//    点赞数目
    private String upNum;
//    点踩数目
    private String downNum;
//    总条目数
    private Integer count;
}
