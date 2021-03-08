package dam.server.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissionData {
    /**
     * 该次任务详情
     */
    private JsoupMission jsoupMission;
    /**
     * 任务下的action列表
     */
    private List<JsoupAction> actionList;

    /**
     * actionvo 数据
     */
    private List<ActionVo> actionVos;

    /**
     * 与任务相关的mission Order (选填)
     */
    private JsoupMissionOrder jsoupMissionOrder;
    /**
     * 与任务相关的pragram
     */
    private List<JsoupPragram> jsoupPragrams;

    /**
     * 与任务相关的 orders 涉及排序
     */
    private List<JsoupActionOrder> actionOrders;


}

