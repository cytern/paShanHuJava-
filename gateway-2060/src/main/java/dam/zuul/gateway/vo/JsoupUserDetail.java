package dam.zuul.gateway.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsoupUserDetail implements Serializable {
    /**
     * 主键
     */

    private Integer userDetailId;

    /**
     * 真名
     */

    private String userRealName;

    /**
     * 小名
     */

    private String userNickName;

    /**
     * 头像url
     */

    private String userImageUrl;

    /**
     * 描述-签名
     */

    private String userDes;

    /**
     * 关连建
     */

    private Integer userId;


    private String userEmail;


    private String userPhone;

    private static final long serialVersionUID = 1L;
}