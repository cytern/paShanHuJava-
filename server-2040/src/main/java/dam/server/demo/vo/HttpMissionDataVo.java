package dam.server.demo.vo;

import lombok.Data;

import java.util.List;

/**
 * 总任务实体
 */
@Data
public class HttpMissionDataVo {
    //执行状态 1为正常  2为异常
    private Integer state;
    //任务数据
    private MissionAllData missionAllData;
    //脚本历史
    private JsoupMissionAllHistory jsoupMissionAllHistory;
    //异常
    private String exception;
    //结果集
    private List result;
}
