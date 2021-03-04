package dam.jsoup.updatereport.updatreport.service.impl;

import dam.jsoup.updatereport.updatreport.dao.JsoupActionMapper;
import dam.jsoup.updatereport.updatreport.dao.JsoupActionOrderMapper;
import dam.jsoup.updatereport.updatreport.dao.JsoupPragramMapper;
import dam.jsoup.updatereport.updatreport.pojo.*;
import dam.jsoup.updatereport.updatreport.service.JsoupActionService;
import dam.jsoup.updatereport.updatreport.vo.ActionVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * jsoupaction 的操作类
 */
@Service
@Slf4j
public class ActionServiceImpl implements JsoupActionService {

    private final JsoupActionMapper jsoupActionMapper;
    private final JsoupActionOrderMapper orderMapper;
    private final JsoupPragramMapper pragramMapper;

    public ActionServiceImpl(JsoupActionMapper jsoupActionMapper, JsoupActionOrderMapper orderMapper, JsoupPragramMapper pragramMapper) {
        this.jsoupActionMapper = jsoupActionMapper;
        this.orderMapper = orderMapper;
        this.pragramMapper = pragramMapper;
    }

    /**
     * 修改mission 下的jsoup 此方法为覆盖式修改，如没有actionId 则会创建id
     *
     * @param actionList list格式入参的action
     * @return 是否修改成功
     */
    @Override
    public Integer updateAction(List<JsoupAction> actionList) {
        log.info("开始覆盖式更新 updateAction    action list ");
        int r = 0;
        for (JsoupAction jsoupAction : actionList) {
            int i = jsoupActionMapper.insertOrUpdateSelective(jsoupAction);
            if (i<1){
                throw new RuntimeException("updateAction 插入更新执行异常");
            }else {
                r = r+1;
            }
        }
        return r;
    }

    /**
     * 获取一个mission 下的全部action
     *
     * @param missionId 任务id
     * @return 列表mission
     */
    @Override
    public List<JsoupAction> searchByMissionId(Integer missionId) {
        JsoupActionExample example = new JsoupActionExample();
        JsoupActionExample.Criteria criteria = example.createCriteria();
        criteria.andMissionIdEqualTo(missionId);
        return jsoupActionMapper.selectByExample(example);
    }

    /**
     * 此方法为更新一个mission 的全部action 此方法为常用方法 会清楚原有action 重新载入全部mission
     *
     * @param actionList 行动列表
     * @return 是否成功
     */
    @Override
    public Integer updateMission(List<JsoupAction> actionList) {
        //删除全部action

        if (actionList == null) {
            log.error("updateMission 输入了空的入参list");
            return 0;
        }
        JsoupAction fist =  actionList.get(0);
        jsoupActionMapper.deleteByMissionId(fist.getMissionId());
        //新插入全部list

        return  jsoupActionMapper.batchInsert(actionList);
    }

    /**
     * 此方法为删除一群action
     *
     * @param actionIds 行动id
     * @return 是否成功
     */
    @Override
    public Integer deleteAction(List<Integer> actionIds) {
        int r = 0;
        for (Integer actionId : actionIds) {
            int i = jsoupActionMapper.deleteByPrimaryKey(actionId);
            if (i<1) {
                throw new  RuntimeException("deleteAction 删除失败");
            }else {
                r= r +1 ;
            }
        }
        return  r;
    }

    /**
     * 此方法为删除一个mission 中的全部action
     *
     * @param missionId 任务id
     * @return 是否成功
     */
    @Override
    public Integer deleteMission(Integer missionId) {
        return jsoupActionMapper.deleteByMissionId(missionId);
    }

    /**
     * 获取一个mission id  下的全部 actionVo
     *
     * @param missionId
     * @return
     */
    @Override
    public List<ActionVo> getAllActionVos(Integer missionId) {
        JsoupActionOrderExample example = new JsoupActionOrderExample();
        example.createCriteria().andMissionIdEqualTo(missionId);
        List<JsoupActionOrder> orders = orderMapper.selectByExample(example);
        List<JsoupActionOrder>  rankOrders = new ArrayList<>();
        if (orders == null || orders.size()<1) {
            return  new ArrayList<>();
        }else {
             rankOrders = orders.stream().sorted(Comparator.comparing(JsoupActionOrder::getRank)).collect(Collectors.toList());
        }
        //循环得到排序好的的jsoupVo
        List<ActionVo> actionVos = new ArrayList<>();
        for (JsoupActionOrder rankOrder : rankOrders) {
            ActionVo actionVo = new ActionVo();
            //存入order
            actionVo.setActionOrder(rankOrder);
            //获取jsoupAction
            JsoupAction action = jsoupActionMapper.selectByPrimaryKey(rankOrder.getActionId());
            actionVo.setJsoupAction(action);
            //获取action pragram
            JsoupPragramExample example1 = new JsoupPragramExample();
            example1.createCriteria().andActionIdEqualTo(rankOrder.getActionId()).andMissionIdEqualTo(rankOrder.getMissionId());
            List<JsoupPragram> list = pragramMapper.selectByExample(example1);
            if (list == null || list.size()<1){
                actionVo.setJsoupPragram(new JsoupPragram());
            }else {
                actionVo.setJsoupPragram(list.get(0));
            }
            //将数据添加至总数据
            actionVos.add(actionVo);
        }
        return actionVos;
    }
}
