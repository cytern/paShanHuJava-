package dam.zuul.gateway.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsoupActionOrder implements Serializable {
    
    private Integer actionOrderId;

    
    private Integer actionId;

    
    private Integer missionId;

    
    private Integer missionAllId;

    
    private Integer rank;

    private static final long serialVersionUID = 1L;
}

