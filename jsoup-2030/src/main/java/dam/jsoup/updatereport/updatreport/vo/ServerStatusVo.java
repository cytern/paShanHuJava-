package dam.jsoup.updatereport.updatreport.vo;

import dam.jsoup.updatereport.updatreport.pojo.JsoupExcutor;
import lombok.Data;

import java.util.List;

/**
 * @author : dam
 * @description :
 * @create :2021-05-10 17:24:00
 */
@Data
public class ServerStatusVo {
    /**
     * 等待执行任务
     */
    private Integer waitTodo;
    /**
     * 存活执行器数量
     */
    private Integer liveExecutor;
    /**
     * 存活的执行器
     */
    private List<JsoupExcutor> excutors;
}
