package dam.zuul.gateway.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * 一个action 包含的全部数据
 */
public class ActionVo {
    /**
     * action 本身
     */
    private JsoupAction jsoupAction;
    /**
     * 对应的分组信息
     */
    private JsoupActionOrder actionOrder;
    /**
     * 对应的参数信息
     */
    private JsoupPragram jsoupPragram;
}


