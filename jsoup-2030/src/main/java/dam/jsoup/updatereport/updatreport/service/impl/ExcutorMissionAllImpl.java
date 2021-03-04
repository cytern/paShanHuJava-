package dam.jsoup.updatereport.updatreport.service.impl;

import dam.jsoup.updatereport.updatreport.dao.*;
import dam.jsoup.updatereport.updatreport.pojo.*;
import dam.jsoup.updatereport.updatreport.service.ExecutorMissionAll;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
@Slf4j
public class ExcutorMissionAllImpl implements ExecutorMissionAll {
    private final SettingMapper settingMapper;
    private final JsoupMissionAllMapper missionAllMapper;
    private final JsoupMissionOrderMapper missionOrderMapper;
    private final JsoupMissionMapper missionMapper;
    private final JsoupActionMapper  actionMapper;
    private final JsoupPragramMapper  pragramMapper;
    private final JsoupActionHisMapper  actionHisMapper;

    public ExcutorMissionAllImpl(SettingMapper settingMapper, JsoupMissionAllMapper missionAllMapper, JsoupMissionOrderMapper missionOrderMapper, JsoupMissionMapper missionMapper, JsoupActionMapper actionMapper, JsoupPragramMapper pragramMapper, JsoupActionHisMapper actionHisMapper) {
        this.settingMapper = settingMapper;
        this.missionAllMapper = missionAllMapper;
        this.missionOrderMapper = missionOrderMapper;
        this.missionMapper = missionMapper;
        this.actionMapper = actionMapper;
        this.pragramMapper = pragramMapper;
        this.actionHisMapper = actionHisMapper;
    }

    /**
     * 启动一个总任务
     *
     * @param missionAllId 总领任务id
     * @return 任务执行情况
     */
    @Override
    public Map<String, String> startMissionAll(int missionAllId) {
        Map<String,String> map = new HashMap<>();
        //封装获得初始化设置数据的方法 根据机器识别码 一一对应
        System.setProperty("webdriver.chrome.driver",settingMapper.selectByPrimaryKey(4).getSettingValue());
        ChromeOptions chromeOptions = new ChromeOptions();

        WebDriver webDriver = new ChromeDriver();

        //获取missionAll
        JsoupMissionAll jsoupMissionAll = missionAllMapper.selectByPrimaryKey(missionAllId);
        StringBuffer goLog = new StringBuffer();
        if (jsoupMissionAll == null){
            map.put("code","error");
            return map;
        }
        webDriver.navigate().to(jsoupMissionAll.getMalStartUrl());
        //根据mission all 获取 mission order
        JsoupMissionOrderExample jsoupMissionOrderExample = new JsoupMissionOrderExample();
        JsoupMissionOrderExample.Criteria criteria = jsoupMissionOrderExample.createCriteria();
        criteria.andMoMissionAllIdEqualTo(jsoupMissionAll.getMaId());
        List<JsoupMissionOrder> missionOrders = missionOrderMapper.selectByExample(jsoupMissionOrderExample);
        if (missionOrders == null || missionOrders.size() <1) {
            map.put("code","error");
            log.error("对于任务 总id =[{}] 总体信息为 missionAll=[{}] 的执行过程中 找到的子任务数量为0",jsoupMissionAll.getMaId(),jsoupMissionAll);
            return map;
        }
        for (JsoupMissionOrder order : missionOrders) {
            JsoupMission mission = missionMapper.selectByPrimaryKey(order.getMoMissionId());
            if (mission== null){
                log.error("对于 任务 id =[{}]  的执行过程中 无法找到改任务对应的任务实体",order.getMissionOrderId());
                break;
            }else {
                //根据mission获取起始action id
                int startId = mission.getStartActionId();
                while (true) {
                    JsoupAction action = actionMapper.selectByPrimaryKey(startId);
                    if (action == null){
                        log.error("对于任务 id=[{}] 的执行过程中  无法找到任务对应的action ",mission.getMissionId());
                        break;
                    }
                    String actionLog = startAction(action,webDriver,missionAllId,mission.getMissionId());
                    log.info("action 执行中 name=[{}],log=[{}] ",action.getActionName(),actionLog);
                    goLog.append(actionLog);
                    goLog.append("\r\n");
                    if (action.getActionAfterId() == null || action.getActionAfterId() == 0) {
                        break;
                    }else {
                        startId = action.getActionAfterId();
                    }
                }
            }

        }
        map.put("code","success");
        map.put("log",goLog.toString());
        webDriver.quit();
        return map;
    }

    /**
     * 执行逻辑任务
     * @param actions
     * @param webDriver
     * @param maId
     * @param mId
     * @return
     */
    private String startAction(JsoupAction actions,WebDriver webDriver,Integer maId,Integer mId) {
        //获取webElemenet 实例
        WebElement ele = getWebEle(actions.getActionEleType(),webDriver,actions.getActionEleValue());
        //确定执行逻辑
        String value = doWebEle(actions,ele,maId,mId,webDriver);
        return value;
    }



    private String doWebEle (JsoupAction action,WebElement ele,Integer maId,Integer mId,WebDriver webDriver) {
        log.info("action 实例进入执行状态   action =[{}]",action);
        JsoupActionHis actionHis = new JsoupActionHis();
        actionHis.setActionHisDate(new Date());
        actionHis.setActionHisMissionId(mId);
        actionHis.setAhMaId(maId);
        String doType = action.getActionDoType();
        StringBuffer sb = new StringBuffer();
        sb.append("  任务 ： "  +action.getActionName() + "执行了：  ");
        switch (doType) {
            case "submit":{
                ele.submit();
                sb.append("提交   ");
                break;
            }
            case "clear": {
                ele.clear();
                sb.append("清空   ");
                break;
            }
            //如果为输入input 属性
            case "input":{
                ele.sendKeys(getPragramCode(action,maId,mId));
                sb.append("输入   "+ getPragramCode(action,maId,mId) + "   ");
                break;
            }
            case "click": {
                ele.click();
                sb.append("点击   ");
                break;
            }
            case "output": {
                actionHis.setActionHisEleValue(ele.getText());
                sb.append("记录   " + ele.getText() + "  ");

                break;
            }
            case "route": {
               webDriver.navigate().to(getPragramCode(action,maId,mId));
                sb.append("跳转   ");
               break;
            }
            default:{
                ele.click();
                sb.append("点击   ");
                break;
            }
        }
        actionHisMapper.insertSelective(actionHis);
        return sb.toString();
    }

    /**
     * 经过筛选获取参数
     * @param
     * @return
     */
    private String getPragramCode (JsoupAction action,Integer maId,Integer mId) {
        JsoupPragram pragram =new JsoupPragram();
        if (action.getActionPragramId() == null || action.getActionPragramId() == 0) {
            JsoupPragramExample example = new JsoupPragramExample();
            JsoupPragramExample.Criteria criteria =example.createCriteria();
            criteria.andActionIdEqualTo(action.getActionId());
            criteria.andMissionAllIdEqualTo(maId);
            criteria.andMissionIdEqualTo(mId);
            List<JsoupPragram> pragrams = pragramMapper.selectByExample(example);
            if (pragrams==null || pragrams.size()<1) {
                log.error("执行参数填写时 查询到的 参数 为空 action=[{}]",action);
            }else {
                pragram = pragrams.get(0);
            }
        }else {
            pragram = pragramMapper.selectByPrimaryKey(action.getActionPragramId());
        }
            if (pragram.getIsRamdom() == null || pragram.getIsRamdom() == 0){
                return  pragram.getPragramValue();
            }else {
                BigDecimal upNum = pragram.getUpNum();
                BigDecimal downNum = pragram.getDownNum();
                float upV = upNum.floatValue();
                float downV = downNum.floatValue();
                BigDecimal value = new BigDecimal(Math.random()*(upV - downV)+ downV);
               value =   value.setScale(pragram.getPragramAccuracy(),BigDecimal.ROUND_DOWN);
               return value.toString();
            }
    }


    /**
     * 获取子模块实例
     * @param eleType 类型
     * @param webDriver 驱动器
     * @param eleValue 值
     * @return 获取的实例
     */
    private WebElement getWebEle(String eleType,WebDriver webDriver,String eleValue) {
        WebElement ele ;
        log.info("获取action 实例 开始  入参 eleType=[{}],eleValue=[{}]",eleType,eleValue);
        switch (eleType) {
            case "id": {
                ele = webDriver.findElement(By.id(eleValue));
                break;
            }
            case "name":{
                ele = webDriver.findElement(By.name(eleValue));
                break;
            }
            case "tagName":{
                ele = webDriver.findElement(By.tagName(eleValue));
                break;
            }
            case "className":{
                ele = webDriver.findElement(By.className(eleValue));
                break;
            }
            case "xpath":{
                ele = webDriver.findElement(By.xpath(eleValue));
                break;
            }
            default: {
                ele = webDriver.findElement(By.xpath(eleValue));
                break;
            }

        }
        return ele;
    }



}
