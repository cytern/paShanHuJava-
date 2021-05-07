package dam.jsoup.updatereport.updatreport.service.order.impl;

import dam.jsoup.updatereport.updatreport.dao.*;
import dam.jsoup.updatereport.updatreport.pojo.*;
import dam.jsoup.updatereport.updatreport.service.JsoupActionService;
import dam.jsoup.updatereport.updatreport.service.UserService;
import dam.jsoup.updatereport.updatreport.service.order.JsoupMissionService;
import dam.jsoup.updatereport.updatreport.util.CronUtil;
import dam.jsoup.updatereport.updatreport.util.MyResponse;
import dam.jsoup.updatereport.updatreport.vo.ActionVo;
import dam.jsoup.updatereport.updatreport.vo.MissionAllData;
import dam.jsoup.updatereport.updatreport.vo.MissionData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

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
    private final OrderJsoupMaMapper orderJsoupMaMapper;
    private final OrderJsoupMhMapper orderJsoupMhMapper;
    private final JsoupUserAssetsMapper assetsMapper;
    private final JsoupUserDetailMapper userDetailMapper;
    private final UserService userService;
    private final JsoupMapper jsoupMapper;





    public MissionEditServiceImpl(JsoupMissionAllMapper jsoupMissionAllMapper, JsoupMissionMapper jsoupMissionMapper, JsoupPragramMapper pragramMapper, JsoupMissionOrderMapper orderMapper, JsoupActionService actionEditService, JsoupUserOrderMapper userOrderMapper, JsoupMissionAllHistoryMapper missionAllHistoryMapper, JsoupActionOrderMapper actionOrderMapper, JsoupActionMapper actionMapper, OrderJsoupMaMapper orderJsoupMaMapper, OrderJsoupMhMapper orderJsoupMhMapper, JsoupUserAssetsMapper assetsMapper, JsoupUserDetailMapper userDetailMapper, UserService userService, JsoupMapper jsoupMapper) {
        this.jsoupMissionAllMapper = jsoupMissionAllMapper;
        this.jsoupMissionMapper = jsoupMissionMapper;
        this.pragramMapper = pragramMapper;
        this.orderMapper = orderMapper;
        this.actionEditService = actionEditService;
        this.userOrderMapper = userOrderMapper;
        this.missionAllHistoryMapper = missionAllHistoryMapper;
        this.actionOrderMapper = actionOrderMapper;
        this.actionMapper = actionMapper;
        this.orderJsoupMaMapper = orderJsoupMaMapper;
        this.orderJsoupMhMapper = orderJsoupMhMapper;
        this.assetsMapper = assetsMapper;
        this.userDetailMapper = userDetailMapper;
        this.userService = userService;
        this.jsoupMapper = jsoupMapper;
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
        //是否为拥有者
        if (jsoupMissionAll.getUserId().equals(userId)){
            missionAllData.setIsOwner(1);
        }
        //TODO 是否拥有完成结果集

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
            criteria1.andMissionIdEqualTo(mission.getMissionId());
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
     * 获取一个执行任务数据
     *
     * @param mhId
     * @return
     */
    @Override
    public MissionAllData getRunningMissionData(Integer mhId) {
        MissionAllData missionAllData = null;
       //先获取对应的任务 执行历史
        JsoupMissionAllHistory missionAllHistory = missionAllHistoryMapper.selectByPrimaryKey(mhId);
        if (missionAllHistory == null) {
            log.error("获取脚本数据失败 入参的任务id不正确");
            return null;
        }
        //根据对应的执行任务 获取脚本数据
        JsoupMissionAll jsoupMissionAll = jsoupMissionAllMapper.selectByPrimaryKey(missionAllHistory.getMissionAllId());
        if (jsoupMissionAll == null) {
            log.error("获取脚本数据失败 入参的任务查询不到脚本信息");
            return null;
        }
        missionAllData.setMissionAllHistory(missionAllHistory);
        missionAllData.setJsoupMissionAll(jsoupMissionAll);
        missionAllData.setIsOwner(0);
        missionAllData.setIsOwner(0);
        //获取对应总脚本下的 任务订单
        JsoupMissionOrderExample missionOrderExample = new JsoupMissionOrderExample();
        missionOrderExample.createCriteria().andMoMissionAllIdEqualTo(jsoupMissionAll.getMaId());
        List<JsoupMissionOrder> jsoupMissionOrders = orderMapper.selectByExample(missionOrderExample);
        List<MissionData> maDataList = new ArrayList<>();
        for (JsoupMissionOrder jsoupMissionOrder : jsoupMissionOrders) {
            MissionData missionData = new MissionData();
            //获取任务
            JsoupMission jsoupMission = jsoupMissionMapper.selectByPrimaryKey(jsoupMissionOrder.getMoMissionId());
            missionData.setJsoupMission(jsoupMission);
            missionData.setJsoupMissionOrder(jsoupMissionOrder);
            JsoupActionOrderExample jsoupActionOrderExample = new JsoupActionOrderExample();
            jsoupActionOrderExample.createCriteria().andMissionIdEqualTo(jsoupMissionOrder.getMoMissionId());
            List<JsoupActionOrder> jsoupActionOrders = actionOrderMapper.selectByExample(jsoupActionOrderExample);
            List<ActionVo> actionVoList = new ArrayList<>();
            for (JsoupActionOrder actionOrder : jsoupActionOrders) {
                ActionVo actionVo = new ActionVo();
                //获取行动
                JsoupAction jsoupAction = actionMapper.selectByPrimaryKey(actionOrder.getActionId());
                actionVo.setActionOrder(actionOrder);
                actionVo.setJsoupAction(jsoupAction);
                //新版查询参数
                JsoupPragramExample jsoupPragramExample = new JsoupPragramExample();
                jsoupPragramExample.createCriteria().andMissionIdEqualTo(jsoupMissionOrder.getMoMissionId()).andActionIdEqualTo(actionOrder.getActionId()).andMhIdEqualTo(mhId).andDeepEqualTo(1);
                List<JsoupPragram> jsoupPragrams = pragramMapper.selectByExample(jsoupPragramExample);
                if (jsoupPragrams == null || jsoupPragrams.size()<1){
                    //表明无参数
                }else {
                    actionVo.setJsoupPragram(jsoupPragrams.get(0));
                }
                actionVoList.add(actionVo);
            }
              missionData.setActionVos(actionVoList);
            maDataList.add(missionData);
        }
        missionAllData.setMissionDataList(maDataList);
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
        //获取持有者的全部脚本
        JsoupMissionAllExample example = new JsoupMissionAllExample();
        example.createCriteria().andUserIdEqualTo(userId);
        List<JsoupMissionAll> jsoupMissionAlls = jsoupMissionAllMapper.selectByExample(example);
        if (jsoupMissionAlls == null){
            jsoupMissionAlls = new ArrayList<>();
        }
        //获取购买者的全部脚本
        OrderJsoupMaExample maExample = new OrderJsoupMaExample();
        maExample.createCriteria().andCustomerUserIdEqualTo(userId);
        List<OrderJsoupMa> orderJsoupMas = orderJsoupMaMapper.selectByExample(maExample);
        for (OrderJsoupMa orderJsoupMa : orderJsoupMas) {
            JsoupMissionAll jsoupMissionAll = jsoupMissionAllMapper.selectByPrimaryKey(orderJsoupMa.getMaId());
            jsoupMissionAlls.add(jsoupMissionAll);
        }
        //按照日期倒序排序
        List<JsoupMissionAll> collect = jsoupMissionAlls.stream().sorted(Comparator.comparing(JsoupMissionAll::getCreateTime).reversed()).collect(Collectors.toList());
        //获取总数据
        List<MissionAllData> list = new ArrayList<>();
        for (JsoupMissionAll jsoupMissionAll : collect) {
            MissionAllData allData = getMissionAllData(jsoupMissionAll.getMaId(),userId);
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
        //以持有者身份获取用户历史结果集
        List<JsoupMissionAllHistory> histories = missionAllHistoryMapper.selectByExample(example);
        //以购买者身份获取用户历史结果集
        if (histories == null) {
            histories = new ArrayList<>();
        }
         OrderJsoupMhExample mhExample = new OrderJsoupMhExample();
        mhExample.createCriteria().andCustomerUserIdEqualTo(userId);
        List<OrderJsoupMh> orderJsoupMhs = orderJsoupMhMapper.selectByExample(mhExample);
        for (OrderJsoupMh orderJsoupMh : orderJsoupMhs) {
            JsoupMissionAllHistory history = missionAllHistoryMapper.selectByPrimaryKey(orderJsoupMh.getMhId());
            if (history != null){
                histories.add(history);
            }
        }
        //按时间倒序排序 结果集
        List<JsoupMissionAllHistory> collect = histories.stream().sorted(Comparator.comparing(JsoupMissionAllHistory::getSentTime).reversed()).collect(Collectors.toList());
        //
        return collect;
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
            missionAllData.getJsoupMissionAll().setCreateTime(new Date());
            //存入初始数据
            missionAllData.getJsoupMissionAll().setMaSaleNum(0);
            missionAllData.getJsoupMissionAll().setMaPrice(new BigDecimal(200));
            missionAllData.getJsoupMissionAll().setMaRate("0");
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
                    pragram.setDeep(0);
                    if (pragram.getPragramId() <= 0){
                        pragramMapper.insertSelective(pragram);
                    }else {
                        pragramMapper.updateByPrimaryKeySelective(pragram);
                    }
                }
            }
        }
        return maId;




    }

    /**
     * 更改保存用户总订单id
     *
     * @param jsoupMissionAll 总任务
     * @param userId          用户id
     * @return
     */
    @Override
    public Map setMissionAllState(JsoupMissionAll jsoupMissionAll, Integer userId) {
        //获取missionAll
        JsoupMissionAll jsoupMissionAll1 = jsoupMissionAllMapper.selectByPrimaryKey(jsoupMissionAll.getMaId());
        if (!jsoupMissionAll1.getUserId().equals(userId)){
            return MyResponse.myResponseError("非法的修改");
        }else {
            //如果是已经上架 则不能修改
            jsoupMissionAll1.setMaState(jsoupMissionAll1.getMaState().equals(2)?2:jsoupMissionAll.getMaState());
            jsoupMissionAll1.setMaPrice(jsoupMissionAll.getMaPrice());
            jsoupMissionAllMapper.updateByPrimaryKeySelective(jsoupMissionAll1);
            return MyResponse.myResponseOk("修改成功");
        }

    }

    /**
     * 获取能够出售的全部任务
     *
     * @return
     */
    @Override
    public List<JsoupMissionAll> getSalesMa(Integer userId) {
        JsoupMissionAllExample missionAllExample = new JsoupMissionAllExample();
        //获取全部上架的任务总览
        missionAllExample.createCriteria().andMaStateEqualTo(2);
        List<JsoupMissionAll> jsoupMissionAlls = jsoupMissionAllMapper.selectByExample(missionAllExample);
        OrderJsoupMaExample maExample = new OrderJsoupMaExample();
        List<JsoupMissionAll> collect = jsoupMissionAlls.stream().peek((a) -> {
            maExample.clear();
            //判断是否为持有者
            if (a.getUserId().equals(userId)) {
                a.setUserId(1);
            } else {

                //判断是否已经购买过
                maExample.createCriteria().andCustomerUserIdEqualTo(userId).andMaIdEqualTo(a.getMaId());
                List<OrderJsoupMa> orderJsoupMas = orderJsoupMaMapper.selectByExample(maExample);
                if (orderJsoupMas.size() > 0) {
                    a.setUserId(2);
                } else {
                    a.setUserId(0);
                }
            }
        }).collect(Collectors.toList());
        return collect;
    }

    /**
     * 获取能够购买的全部结果集
     */
    @Override
    public List<JsoupMissionAllHistory> getSalesMh(Integer userId) {
        JsoupMissionAllHistoryExample example = new JsoupMissionAllHistoryExample();
        example.createCriteria().andOnSaleEqualTo("1");
        List<JsoupMissionAllHistory> histories = missionAllHistoryMapper.selectByExample(example);
        OrderJsoupMhExample mhExample = new OrderJsoupMhExample();
        //如果持有者id 与用户id相同 则将userId 设置为1 否则则设置成0  表示是否是持有者
        List<JsoupMissionAllHistory> collect = histories.stream().peek((a) -> {
            //如果持有者id 与用户id相同 则将userId 设置为1 否则则设置成0  表示是否是持有者
            if (a.getUserId().equals(userId)) {
                a.setUserId(1);
            } else {
                mhExample.clear();
                mhExample.createCriteria().andCustomerUserIdEqualTo(userId).andMhIdEqualTo(a.getMissionAllHistoryId());
                List<OrderJsoupMh> orderJsoupMhs = orderJsoupMhMapper.selectByExample(mhExample);
                if (orderJsoupMhs.size() > 0) {
                    a.setUserId(2);
                } else {
                    a.setUserId(0);
                }
            }
        }).collect(Collectors.toList());

        return collect;
    }

    /**
     * 设置结果集状态 售价
     *
     * @param jsoupMissionAllHistory 历史
     * @return
     */
    @Override
    public Map setMhState(JsoupMissionAllHistory jsoupMissionAllHistory,Integer userId) {
        //获取真实的结果集数据
        JsoupMissionAllHistory history = missionAllHistoryMapper.selectByPrimaryKey(jsoupMissionAllHistory.getMissionAllHistoryId());
        if (!history.getUserId().equals(userId) || !history.getMissionState().equals("3")){
            return MyResponse.myResponseError("非法的操作,非可售卖脚本");
        }else {
            history.setOnSale(jsoupMissionAllHistory.getOnSale().equals("1")?"1":jsoupMissionAllHistory.getOnSale());
            history.setSalePrice(jsoupMissionAllHistory.getSalePrice());
            missionAllHistoryMapper.updateByPrimaryKeySelective(history);
            return MyResponse.myResponseOk("更新成功");
        }
    }

    /**
     * 购买一个脚本
     *
     * @param userId 用户id
     * @param maId   脚本id
     * @return
     */
    @Override
    public Map byMa(Integer userId, Integer maId) {
        //判断该脚本是否能够购买
        JsoupMissionAll missionAll = jsoupMissionAllMapper.selectByPrimaryKey(maId);
        //无该脚本  未上架  持有者
        if (missionAll == null || !missionAll.getMaState().equals(2)  ||  missionAll.getUserId().equals(userId)){
            return MyResponse.myResponseError("无效的商品");
        }else {
            OrderJsoupMaExample example = new OrderJsoupMaExample();
            example.createCriteria().andCustomerUserIdEqualTo(userId).andMaIdEqualTo(maId);
            List<OrderJsoupMa> orderJsoupMas = orderJsoupMaMapper.selectByExample(example);
            if (orderJsoupMas.size()>0){
                return MyResponse.myResponseError("已在库中");
            }
            //判断用户是否具有足够的钱
           JsoupUserAssetsExample assetsExample = new JsoupUserAssetsExample();
           assetsExample.createCriteria().andUserIdEqualTo( userId);
            List<JsoupUserAssets> jsoupUserAssets = assetsMapper.selectByExample(assetsExample);
            if (missionAll.getMaPrice().compareTo(jsoupUserAssets.get(0).getCornNum())>0){
               //钱不够
               return MyResponse.myResponseError("余额不足");
            }else {
                //脚本销售量加一
                Integer maSaleNum =  missionAll.getMaSaleNum();
                if (maSaleNum == null ) {
                    maSaleNum = 0;
                }
                missionAll.setMaSaleNum(maSaleNum+1);
                jsoupMissionAllMapper.updateByPrimaryKeySelective(missionAll);
                //持有者加钱
                userService.saleSuccess(missionAll.getMaPrice(),missionAll.getUserId());
                //扣除钱
                jsoupUserAssets.get(0).setCornNum(jsoupUserAssets.get(0).getCornNum().subtract(missionAll.getMaPrice()));
                assetsMapper.updateByPrimaryKeySelective(jsoupUserAssets.get(0));
                //将商品加入订单
                OrderJsoupMa orderJsoupMa = new OrderJsoupMa();
                orderJsoupMa.setCreateTime(new Date());
                orderJsoupMa.setCustomerUserId(userId);
                orderJsoupMa.setFinishPrice(missionAll.getMaPrice());
                orderJsoupMa.setMaId(missionAll.getMaId());
                orderJsoupMa.setOwnerUserId(missionAll.getUserId());
                orderJsoupMaMapper.insertSelective(orderJsoupMa);
                return MyResponse.myResponseOk("购买成功");
            }

        }
    }

    /**
     * 购买一个结果集
     * @param userId 用户id
     * @param mhId  结果集id
     * @return
     */
    @Override
    public Map byMh(Integer userId, Integer mhId) {
        //判断该脚本是否允许购买 执行状态为完成执行  执行结果集不为空
        JsoupMissionAllHistory history = missionAllHistoryMapper.selectByPrimaryKey(mhId);
        //执行结果为失败 上架状态为 未上架  结果集持有者
        if ( history == null || !history.getMissionState().equals("3") || !history.getOnSale().equals("1") || history.getUserId().equals(userId)){
         return MyResponse.myResponseError("无效的商品");
        }
        //判断我的订单中是否拥有
        OrderJsoupMhExample orderJsoupMhExample = new OrderJsoupMhExample();
        orderJsoupMhExample.createCriteria().andCustomerUserIdEqualTo(userId).andMhIdEqualTo(mhId);
        List<OrderJsoupMh> orderJsoupMhs = orderJsoupMhMapper.selectByExample(orderJsoupMhExample);
        if (orderJsoupMhs.size()>0){
            return MyResponse.myResponseError("已在库中");
        }
        //判断是否钱够
        JsoupUserAssetsExample example = new JsoupUserAssetsExample();
         example.createCriteria().andUserIdEqualTo(userId);
        List<JsoupUserAssets> jsoupUserAssets = assetsMapper.selectByExample(example);
        if (jsoupUserAssets.get(0).getCornNum().compareTo(history.getSalePrice())<0){
            //钱不够
            return MyResponse.myResponseError("余额不足");
        }
        //扣钱
        jsoupUserAssets.get(0).setCornNum(jsoupUserAssets.get(0).getCornNum().subtract(history.getSalePrice()));
        assetsMapper.updateByPrimaryKeySelective(jsoupUserAssets.get(0));
        //销售量增加一
        Integer saleNum = history.getSaleNum();
        if (saleNum == null) {
            saleNum = 0;
        }
        history.setSaleNum(saleNum + 1);
        missionAllHistoryMapper.updateByPrimaryKeySelective(history);
        //持有者加钱
        userService.saleSuccess(history.getSalePrice(),history.getUserId());
        //加入订单
        OrderJsoupMh jsoupMh = new OrderJsoupMh();
        jsoupMh.setCreateTime(new Date());
        jsoupMh.setFinishPrice(history.getSalePrice());
        jsoupMh.setOwnerUserId(history.getUserId());
        jsoupMh.setCustomerUserId(userId);
        jsoupMh.setMhId(history.getMissionAllHistoryId());
        jsoupMh.setOwnerUserId(history.getUserId());
        orderJsoupMhMapper.insertSelective(jsoupMh);
        return MyResponse.myResponseOk("购买成功");

    }

    /**
     * 通过 ma 或者 mh 的id 获取 一个详细信息
     *
     * @param id   id
     * @param type 类型 1 为 ma 2 为mh
     * @return
     */
    @Override
    public Map getGoodUserDetail(Integer id, Integer type) {
        Map res = new HashMap();
        Integer userId = 0;
        //获取历史订单从而获取评价
        if (type == 1) {
            JsoupMissionAll missionAll = jsoupMissionAllMapper.selectByPrimaryKey(id);
            userId = missionAll.getUserId();
        }else {
            JsoupMissionAllHistory history = missionAllHistoryMapper.selectByPrimaryKey(id);
            userId = history.getUserId();
        }
        //获取用户详细信息
        JsoupUserDetailExample detailExample = new JsoupUserDetailExample();
        detailExample.createCriteria().andUserIdEqualTo(userId);
        List<JsoupUserDetail> jsoupUserDetails = userDetailMapper.selectByExample(detailExample);
        if (jsoupUserDetails.size() <1) {
            return MyResponse.myResponseError("无效的数据");
        }else {
            res.put("userDetail",jsoupUserDetails.get(0));
           return  MyResponse.myResponseOk(res);
        }
    }

    /**
     * 获取评论列表
     * @param id
     * @param type
     * @return
     */
    @Override
    public List getGoodOrderDetail(Integer id, Integer type) {

        if (type == 1) {
           OrderJsoupMaExample example = new OrderJsoupMaExample();
           example.createCriteria().andMaIdEqualTo(id);
            return orderJsoupMaMapper.selectByExample(example);
        }else {
            OrderJsoupMhExample example = new OrderJsoupMhExample();
            example.createCriteria().andMhIdEqualTo(id);
            return  orderJsoupMhMapper.selectByExample(example);
        }
    }

    /**
     * 发送一个定时任务脚本
     *
     * @param maId
     * @param userId
     * @param corn
     * @return
     */
    @Override
    public Map addAutoWorkMission(Integer maId, Integer userId, String corn,Integer times,List<JsoupPragram> pragrams) {
        if (!CronUtil.canAdd(corn)){
            log.error("最小时间间隔太小，无法完成添加");
            return MyResponse.myResponseError("最小两次任务执行间隔为五分钟！");
        }
        //添加一个序列5 的 missionOrder
        JsoupMissionAll jsoupMissionAll = jsoupMissionAllMapper.selectByPrimaryKey(maId);
        if (!jsoupMissionAll.getUserId().equals(userId)) {
            OrderJsoupMaExample example = new OrderJsoupMaExample();
            example.createCriteria().andCustomerUserIdEqualTo(userId);
            List<OrderJsoupMa> orderJsoupMas = orderJsoupMaMapper.selectByExample(example);
            if (orderJsoupMas.size()<1) {
                return MyResponse.myResponseError("非法操作");
            }
        }
        JsoupMissionAllHistory history = new JsoupMissionAllHistory();
        history.setSentTime(new Date());
        history.setMissionAllId(jsoupMissionAll.getMaId());
        history.setMissionState("5");
        history.setUserId(userId);
        history.setFinishTime(new Date());
        history.setMissionAllName(jsoupMissionAll.getMaName());
        history.setMissionAllDis(jsoupMissionAll.getMaTip());
        history.setSaleNum(0);
        history.setSalePrice(new BigDecimal(200));
        history.setIsTimeTask(1);
        history.setTimeCorn(corn);
        history.setTimeNum(times);
        history.setSaleRate("0");
        missionAllHistoryMapper.insertSelective(history);
        //根据获取的mh_id 执行插入操作
        for (JsoupPragram pragram : pragrams) {
            pragram.setFatherId(pragram.getPragramId());
            pragram.setDeep(1);
            pragram.setMhId(history.getMissionAllHistoryId());
            pragramMapper.insertSelective(pragram);
        }
        addRunningParameter(history.getMissionAllHistoryId());
        return MyResponse.myResponseOk("添加成功!");
    }

    /**
     * 删除一个定时任务
     *
     * @param mhId
     * @param userId
     * @return
     */
    @Override
    public Map deleteAutoWorkMission(Integer mhId, Integer userId) {
        JsoupMissionAllHistory missionAllHistory = missionAllHistoryMapper.selectByPrimaryKey(mhId);
        if (missionAllHistory == null || !missionAllHistory.getUserId().equals(userId)) {
            return MyResponse.myResponseError("无效的数据");
        }else {
            missionAllHistoryMapper.deleteByPrimaryKey(mhId);
            return MyResponse.myResponseOk("删除成功");
        }
    }

    /**
     * 更新一个定时任务
     *
     * @param mhId
     * @param corn
     * @return
     */
    @Override
    public Map updateAutoWorkMission(Integer mhId, String corn,Integer times,Integer userId) {
        JsoupMissionAllHistory missionAllHistory = missionAllHistoryMapper.selectByPrimaryKey(mhId);
        if (missionAllHistory == null || !missionAllHistory.getUserId().equals(userId)) {
            return MyResponse.myResponseError("无效的数据");
        }else {
           if (corn == null || CronUtil.canAdd(corn)) {
               missionAllHistory.setTimeNum(times);
               missionAllHistory.setTimeCorn(corn);
               missionAllHistoryMapper.updateByPrimaryKeySelective(missionAllHistory);
               return MyResponse.myResponseOk("修改成功");
           }else {
               return MyResponse.myResponseError("最小两次任务执行间隔为五分钟！");
           }
        }
    }

    /**
     * 添加参数
     * @param mhId
     */
    public void addRunningParameter(Integer mhId) {
        //获取mhId
        JsoupMissionAllHistory jsoupMissionAllHistory = missionAllHistoryMapper.selectByPrimaryKey(mhId);
        //获取所有构造参数
        List<JsoupPragram> pragramBymaId = jsoupMapper.getAllPragramBymaId(jsoupMissionAllHistory.getMissionAllId());
        List<JsoupPragram> allPragramByMhId = jsoupMapper.getAllPragramByMhId(mhId);
        for (JsoupPragram jsoupPragram : pragramBymaId) {
            //判断是否在mhId 中拥有
            boolean flag = false;
            for (JsoupPragram pragram : allPragramByMhId) {
                if (pragram.getFatherId().equals(jsoupPragram.getPragramId())){
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                if (jsoupPragram.getNeedAdd() == 1){
                    throw new RuntimeException("缺少必要的必填参数");
                }
                jsoupPragram.setFatherId(jsoupPragram.getPragramId());
                jsoupPragram.setDeep(1);
                jsoupPragram.setMhId(mhId);
                pragramMapper.insertSelective(jsoupPragram);
            }
        }

    }

}
