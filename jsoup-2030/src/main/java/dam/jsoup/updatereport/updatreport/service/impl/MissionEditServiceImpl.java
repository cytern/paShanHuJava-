package dam.jsoup.updatereport.updatreport.service.impl;

import dam.jsoup.updatereport.updatreport.dao.*;
import dam.jsoup.updatereport.updatreport.pojo.*;
import dam.jsoup.updatereport.updatreport.service.JsoupActionService;
import dam.jsoup.updatereport.updatreport.service.JsoupMissionService;
import dam.jsoup.updatereport.updatreport.vo.ActionVo;
import dam.jsoup.updatereport.updatreport.vo.MissionAllData;
import dam.jsoup.updatereport.updatreport.vo.MissionData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
@Transactional
public class MissionEditServiceImpl implements JsoupMissionService {
    private final JsoupMissionAllMapper jsoupMissionAllMapper;
    private final JsoupMissionMapper jsoupMissionMapper;
    private final JsoupPragramMapper pragramMapper;
    private final JsoupMissionOrderMapper orderMapper;
    private final JsoupActionService actionEditService;
    private final JsoupUserOrderMapper userOrderMapper;
    private final JsoupMissionAllHistoryMapper missionAllHistoryMapper;
    private final JsoupActionOrderMapper actionOrderMapper;
    private final JsoupActionMapper actionMapper;



    public MissionEditServiceImpl(JsoupMissionAllMapper jsoupMissionAllMapper, JsoupMissionMapper jsoupMissionMapper, JsoupPragramMapper pragramMapper, JsoupMissionOrderMapper orderMapper, JsoupActionService actionEditService, JsoupUserOrderMapper userOrderMapper, JsoupMissionAllHistoryMapper missionAllHistoryMapper, JsoupActionOrderMapper actionOrderMapper, JsoupActionMapper actionMapper) {
        this.jsoupMissionAllMapper = jsoupMissionAllMapper;
        this.jsoupMissionMapper = jsoupMissionMapper;
        this.pragramMapper = pragramMapper;
        this.orderMapper = orderMapper;
        this.actionEditService = actionEditService;
        this.userOrderMapper = userOrderMapper;
        this.missionAllHistoryMapper = missionAllHistoryMapper;
        this.actionOrderMapper = actionOrderMapper;

        this.actionMapper = actionMapper;
    }


    /**
     * 获取格式化的任务数据
     *
     * @param missionAllId 任务总id
     * @return 格式化数据
     */
    @Override
    public MissionAllData getMissionAllData(Integer missionAllId,Integer userId) {
        MissionAllData missionAllData = new MissionAllData();
        //首先获取missionAll
        JsoupMissionAll jsoupMissionAll = jsoupMissionAllMapper.selectByPrimaryKey(missionAllId);
        missionAllData.setJsoupMissionAll(jsoupMissionAll);
        if (jsoupMissionAll.getUserId().equals(userId)){
            missionAllData.setIsOwner(1);
        }
        //获取missionALL 下的全部order
        JsoupMissionOrderExample example = new JsoupMissionOrderExample();
        JsoupMissionOrderExample.Criteria criteria = example.createCriteria();
        criteria.andMoMissionAllIdEqualTo(missionAllId);
        List<JsoupMissionOrder> orders = orderMapper.selectByExample(example);
        missionAllData.setOrders(orders);
        //更具orders 获取全部mission
        List<MissionData> missionDataList = new ArrayList<>();
        for (JsoupMissionOrder order : orders) {
            MissionData missionData = new MissionData();
            JsoupMission mission = jsoupMissionMapper.selectByPrimaryKey(order.getMoMissionId());
            //存入mission
            missionData.setJsoupMission(mission);
            //存入order
            missionData.setJsoupMissionOrder(order);
            //存入action
            missionData.setActionList(actionEditService.searchByMissionId(mission.getMissionId()));
            //存入 JsoupPragram
            JsoupPragramExample example1 = new JsoupPragramExample();
            JsoupPragramExample.Criteria criteria1 = example1.createCriteria();
            criteria1.andActionIdEqualTo(mission.getMissionId());
            missionData.setJsoupPragrams(pragramMapper.selectByExample(example1));
            //放入actionVos
            missionData.setActionVos(actionEditService.getAllActionVos(mission.getMissionId()));

            //放入actionOrders

            JsoupActionOrderExample orderExample = new JsoupActionOrderExample();
            orderExample.createCriteria().andMissionIdEqualTo(mission.getMissionId());
            List<JsoupActionOrder> orderList = actionOrderMapper.selectByExample(orderExample);
            if (orderList == null || orderList.size()<1) {
                missionData.setActionOrders(new ArrayList<>());
            }else {
                missionData.setActionOrders(orderList);
            }

            //添加actionOrders
            missionDataList.add(missionData);




        }
        missionAllData.setMissionDataList(missionDataList);
        return missionAllData;
    }

    /**
     * 获取某个用户的全部可使用脚本
     *
     * @param userId 用户id
     * @return 格式化数据
     */
    @Override
    public List<MissionAllData> getOnesOrder(Integer userId) {
        JsoupUserOrderExample example = new JsoupUserOrderExample();
        example.createCriteria().andUserIdEqualTo(userId);
        //获取该用户的全部订单 脚本
        List<JsoupUserOrder> orders = userOrderMapper.selectByExample(example);
        List<MissionAllData> list = new ArrayList<>();
        for (JsoupUserOrder order : orders) {
            MissionAllData allData = getMissionAllData(order.getMissionAllId(),userId);
            list.add(allData);
        }
        return list;
    }

    /**
     * 获取某个用户的全部脚本执行历史
     *
     * @param userId 用户id
     * @return 脚本历史
     */
    @Override
    public List<JsoupMissionAllHistory> getMissionAllHistory(Integer userId) {
        JsoupMissionAllHistoryExample example = new JsoupMissionAllHistoryExample();
        example.createCriteria().andUserIdEqualTo(userId);
        List<JsoupMissionAllHistory> histories = missionAllHistoryMapper.selectByExample(example);
        return histories;
    }

    /**
     * 存取一个完整的脚本信息
     *
     * @param missionAllData 总集合
     * @return 总集合
     */
    @Override
    public Integer saveMissionAll(MissionAllData missionAllData,Integer userId) {
      log.info("**********开始保存脚本的值 saveMissionAll **********");
        Integer maId = 0;
        //确定任务是否存在
        if (missionAllData.getJsoupMissionAll().getMaId() <= 0){
            //不存在首先添加新任务
            missionAllData.getJsoupMissionAll().setUserId(userId);
            jsoupMissionAllMapper.insertSelective(missionAllData.getJsoupMissionAll());
            maId = missionAllData.getJsoupMissionAll().getMaId();
        }else {
            //存在则确定任务是否与用户对应
            maId = missionAllData.getJsoupMissionAll().getMaId();
            JsoupMissionAll missionAll = jsoupMissionAllMapper.selectByPrimaryKey(missionAllData.getJsoupMissionAll().getMaId());
            if (missionAll.getUserId() != missionAllData.getJsoupMissionAll().getUserId()){
                log.error("**********保存脚本的值失败：非法用户修改**********");
                return null;
            }
        }
        //删除之前的全部missionOrder
        JsoupMissionOrderExample orderExample = new JsoupMissionOrderExample();
        orderExample.createCriteria().andMoMissionAllIdEqualTo(maId);
        orderMapper.deleteByExample(orderExample);
        //修改 或增加 missions  actions
        for (MissionData missionData : missionAllData.getMissionDataList()) {
            if (missionData.getJsoupMission().getMissionId()<=0){
                jsoupMissionMapper.insertSelective(missionData.getJsoupMission());
            }else {
                jsoupMissionMapper.updateByPrimaryKeySelective(missionData.getJsoupMission());
            }
            JsoupMissionOrder order = missionData.getJsoupMissionOrder();
            order.setMoMissionAllId(maId);
            order.setMoMissionId(missionData.getJsoupMission().getMissionId());
            order.setMoAddTime(new Date());
            orderMapper.insertSelective(order);
            //删除actionOrders
            JsoupActionOrderExample orderExample1 = new JsoupActionOrderExample();
            orderExample1.createCriteria().andMissionIdEqualTo(order.getMoMissionId());
            actionOrderMapper.deleteByExample(orderExample1);
            //增加action的数据
            for (ActionVo actionVo : missionData.getActionVos()) {

                //增加 或修改 action
                if (actionVo.getJsoupAction().getActionId()<= 0){
                    actionMapper.insertSelective(actionVo.getJsoupAction());
                }else {
                    actionMapper.updateByPrimaryKeySelective(actionVo.getJsoupAction());
                }
                JsoupActionOrder order1 = actionVo.getActionOrder();
                order1.setActionId(actionVo.getJsoupAction().getActionId());
                actionOrderMapper.insertSelective(order1);
                if (actionVo.getJsoupAction().getActionDoType().equals("input") || actionVo.getJsoupAction().getActionDoType().equals("goto")) {
                    JsoupPragram pragram = actionVo.getJsoupPragram();
                    pragram.setActionId(actionVo.getJsoupAction().getActionId());
                    pragram.setMissionId(order.getMoMissionId());
                    if (pragram.getPragramId() <= 0){
                        pragramMapper.insertSelective(pragram);
                    }else {
                        pragramMapper.updateByPrimaryKeySelective(pragram);
                    }
                }
            }
        }
        return maId;


        //删除未get 到 id 的 order

    }

}
