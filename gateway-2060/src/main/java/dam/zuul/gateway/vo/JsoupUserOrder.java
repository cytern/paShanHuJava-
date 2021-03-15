package dam.zuul.gateway.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsoupUserOrder implements Serializable {

    private Integer orderId;


    private Integer userId;


    private Integer missionAllId;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")

    private Date createTime;

    private static final long serialVersionUID = 1L;
}