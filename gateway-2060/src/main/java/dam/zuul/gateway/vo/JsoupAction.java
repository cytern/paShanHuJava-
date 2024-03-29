package dam.zuul.gateway.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsoupAction {
    /**
     * 动作id
     */
    private Integer actionId;

    /**
     * 任务选取类型
     * id
     * name
     * tagName
     * className
     * xpath
     */

    private String actionEleType;

    /**
     * 任务执行类型
     * submit 提交
     * clear    清空
     * input    输入
     * click     点击
     * output  输出
     */

    private String actionDoType;

    /**
     * 如果类型为 nav 则跳转的url
     */

    private String actionUrl;

    /**
     * 任务组的id
     */

    private Integer missionId;

    /**
     * 寻找组件的值
     */

    private String actionEleValue;

    /**
     * 上一个action id
     */

    private Integer actionPreId;

    /**
     * 下一个 action id
     */

    private Integer actionAfterId;

    /**
     * 动作名称
     */
    @ApiModelProperty(value = "动作名称 ")
    private String actionName;

    /**
     * 字段对应id  类型为input有用、如果为空或0 则为动态变量 与 mission 有关
     */
    @ApiModelProperty(value = "字段对应id  类型为input有用、如果为空或0 则为动态变量 与 mission 有关")

    private Integer actionPragramId;

    /**
     * 废弃字段  是否具有键入值 已使用另一个字段
     */
    @ApiModelProperty(value = "废弃字段  是否具有键入值 已使用另一个字段")
    private Integer actionElePragramId;

    private static final long serialVersionUID = 1L;
}

