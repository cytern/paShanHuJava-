package dam.jsoup.updatereport.updatreport.service.impl;

import dam.jsoup.updatereport.updatreport.dao.*;
import dam.jsoup.updatereport.updatreport.pojo.*;
import dam.jsoup.updatereport.updatreport.service.ExecutorMission;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dam
 * @version 1.0
 * @date 2020/12/22 18:31
 */
@Service
@Slf4j
public class ExecutorMissionImpl implements ExecutorMission {
    private final JsoupActionHisMapper jsoupActionHisMapper;
    private final JsoupMissionHistoryMapper jsoupMissionHistoryMapper;
    private final JsoupPragramMapper jsoupPragramMapper;
    private final JsoupMissionMapper jsoupMissionMapper;
    private final JsoupActionMapper jsoupActionMapper;
    private final SettingMapper settingMapper;

    public ExecutorMissionImpl(JsoupActionHisMapper jsoupActionHisMapper, JsoupMissionHistoryMapper jsoupMissionHistoryMapper, JsoupPragramMapper jsoupPragramMapper, JsoupMissionMapper jsoupMissionMapper, JsoupActionMapper jsoupActionMapper, SettingMapper settingMapper) {
        this.jsoupActionHisMapper = jsoupActionHisMapper;
        this.jsoupMissionHistoryMapper = jsoupMissionHistoryMapper;
        this.jsoupPragramMapper = jsoupPragramMapper;
        this.jsoupMissionMapper = jsoupMissionMapper;
        this.jsoupActionMapper = jsoupActionMapper;
        this.settingMapper = settingMapper;
    }

    /**
     * 任务执行器主任务 将会启动一个webdriver实例 并且根据mission 便利调用 执行action方法
     * @param missionId 任务id
     * @return
     */
    @Override
    public Map<String,String> startMission(int missionId) {
        Map<String,String> map = new HashMap<>();
       JsoupMission jsoupMission = jsoupMissionMapper.selectByPrimaryKey(missionId);
       log.info("爬虫任务执行---开始----- 入参查询完毕,mission=[{}]",jsoupMission);
       if (jsoupMission.getMissionId() == null || jsoupMission.getMissionId()==0){
           map.put("title","error");
           map.put("msg","行动的action无法查询到");
           log.error("爬虫任务错误---错误为--   " + "行动的action无法查询到");
           return map;
       }
        Setting setting = settingMapper.selectByPrimaryKey(1);
        log.info("创建浏览器实例----开始----，初始化浏览器驱动");
        System.setProperty("webdriver.chrome.driver", setting.getSettingValue());

        WebDriver driver = new ChromeDriver();

        log.info("创建浏览器实例----结束----，  启动完毕");
        log.info("跳转浏览器页面----开始----， 准备跳转");
        driver.navigate().to (jsoupMission.getMissionStartUrl());
        log.info("跳转浏览器页面----结束----， 跳转完毕");
        Integer pointId = jsoupMission.getStartActionId();
        log.info("获取任务起始action----开始----， 获取完毕 id=[{}]",pointId);
        StringBuilder buffer = new StringBuilder();
       while (true){
           try {
               Thread.sleep(2000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           JsoupAction jsoupAction = jsoupActionMapper.selectByPrimaryKey(pointId);
           log.info("任务启动，开始进行获取action----   完毕  action=[{}]",jsoupAction);
           if (jsoupAction == null){
               log.info("此次action 为空 结束循环    ------ action=[{}]",jsoupAction);
               break;
           }else {
               try {



                   String type =jsoupAction.getActionEleType()==null?"":jsoupAction.getActionEleType();
                   WebElement ele =null;
                   log.info("查找元素  =------   查找类型=[{}] ",type);
                   switch (type){
                       case "id": {
                           ele = driver.findElement(By.id(jsoupAction.getActionEleValue()));
                           break;
                       }
                       case "name":{
                           ele = driver.findElement(By.name(jsoupAction.getActionEleValue()));
                           break;
                       }
                       case "tagName":{
                           ele = driver.findElement(By.tagName(jsoupAction.getActionEleValue()));
                           break;
                       }
                       case "className":{
                           ele = driver.findElement(By.className(jsoupAction.getActionEleValue()));
                           break;
                       }
                       default:{
                           ele = driver.findElement(By.xpath(jsoupAction.getActionEleValue()));
                           break;
                       }
                   }
                   log.info("元素是否具有参数     flag=[{}]",jsoupAction.getActionElePragramId() != null && jsoupAction.getActionElePragramId() != 0 );
                   if (jsoupAction.getActionElePragramId() != null && jsoupAction.getActionElePragramId() != 0){
                       JsoupPragramExample example =new JsoupPragramExample();
                       JsoupPragramExample.Criteria criteria = example.createCriteria();
                       criteria.andMissionIdEqualTo(missionId);
                       criteria.andActionIdEqualTo(jsoupAction.getActionId());
                       //此处明日修改 应该添加 actionId 于 pragram中
                       List<JsoupPragram> list = jsoupPragramMapper.selectByExample(example);
                       log.info("参数为    string=[{}]",list.get(0).getPragramValue());
                       ele.sendKeys(list.get(0).getPragramValue());
                   }
                   String doType = jsoupAction.getActionDoType()==null?"":jsoupAction.getActionDoType();

                   log.info("元素执行方法    dotype=[{}]",doType);
                   switch (doType){
                       case "submit":{
                           ele.submit();
                           break;
                       }
                       case "clear": {
                           ele.clear();
                           break;
                       }
                       default:{
                           ele.click();
                           break;
                       }
                   }
                   log.info("添加action历史操作记录         "     );
                   JsoupActionHis jsoupActionHis = new JsoupActionHis();
                   jsoupActionHis.setActionHisDate(new Date());
                   try {
                       jsoupActionHis.setActionHisEleValue(ele.getText());
                   } catch (Exception e) {
                       log.info("页面跳转 属性不存在读取值");
                   }
                   jsoupActionHis.setActionHisActionId(jsoupAction.getActionId());
                   jsoupActionHis.setActionHisMissionId(missionId);
                   jsoupActionHisMapper.insertSelective(jsoupActionHis);

                   String res = "操作：   " + jsoupAction.getActionName() + "     于   " + jsoupActionHis.getActionHisDate() + "   执行成功    ";





//                   String res = exAction(jsoupAction,driver,missionId);
                   log.info("执行本次action     结果------ res=[{}",res);
                   buffer.append("\r\n");
                   buffer.append(res);
               } catch (Exception e) {
                  buffer.append(e);
                  log.error("执行错误======="+ e);
                  e.printStackTrace();
                  return null;
               }
           }
           log.info("判断action是否 具有 后续action    结果--- flag=[{}]",jsoupAction.getActionAfterId() == null || jsoupAction.getActionAfterId() ==0);
           if (jsoupAction.getActionAfterId() == null || jsoupAction.getActionAfterId() ==0){
               log.info("action 全部执行完毕    结果     msg=[{}] ", buffer.toString());
               break;
           }else {
               pointId = jsoupAction.getActionAfterId();
           }
       }
       driver.quit();
       map.put("msg",buffer.toString());
       JsoupMissionHistory jsoupMissionHistory = new JsoupMissionHistory();
       jsoupMissionHistory.setContent(map.get("msg"));
       jsoupMissionHistory.setMissionId(missionId);
       jsoupMissionHistory.setMissionTime(new Date());
       jsoupMissionHistoryMapper.insertSelective(jsoupMissionHistory);
       map.put("title",jsoupMission.getMissionName());
       log.info("爬虫任务执行完毕---");
       return map;
    }




}
