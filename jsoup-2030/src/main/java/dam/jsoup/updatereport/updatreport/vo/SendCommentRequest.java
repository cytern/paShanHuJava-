package dam.jsoup.updatereport.updatreport.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SendCommentRequest {
    private String comment;
    private Integer rate;
}
