package dam.jsoup.updatereport.updatreport.service.impl;

import dam.jsoup.updatereport.updatreport.dao.*;
import dam.jsoup.updatereport.updatreport.pojo.*;
import dam.jsoup.updatereport.updatreport.service.JsoupActionService;
import dam.jsoup.updatereport.updatreport.service.JsoupMissionService;
import dam.jsoup.updatereport.updatreport.vo.MissionAllData;
import dam.jsoup.updatereport.updatreport.vo.MissionData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j


public class MissionEditServiceImpl implements JsoupMissionService {
    private final JsoupMissionAllMapper jsoupMissionAllMapper;
    private final JsoupMissionMapper jsoupMissionMapper;
    private final JsoupPragramMapper pragramMapper;
    private final JsoupMissionOrderMapper orderMapper;
    private final JsoupActionService actionEditService;
    private final JsoupUserOrderMapper userOrderMapper;
    private final JsoupMissionAllHistoryMapper missionAllHistoryMapper;
    private final JsoupActionOrderMapper actionOrderMapper;


    public MissionEditServiceImpl(JsoupMissionAllMapper jsoupMissionAllMapper, JsoupMissionMapper jsoupMissionMapper, JsoupPragramMapper pragramMapper, JsoupMissionOrderMapper orderMapper, JsoupActionService actionEditService, JsoupUserOrderMapper userOrderMapper, JsoupMissionAllHistoryMapper missionAllHistoryMapper, JsoupActionOrderMapper actionOrderMapper) {
        this.jsoupMissionAllMapper = jsoupMissionAllMapper;
        this.jsoupMissionMapper = jsoupMissionMapper;
        this.pragramMapper = pragramMapper;
        this.orderMapper = orderMapper;
        this.actionEditService = actionEditService;
        this.userOrderMapper = userOrderMapper;
        this.missionAllHistoryMapper = missionAllHistoryMapper;
        this.actionOrderMapper = actionOrderMapper;
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
}
