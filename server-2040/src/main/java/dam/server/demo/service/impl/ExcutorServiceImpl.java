package dam.server.demo.service.impl;

import dam.server.demo.config.ConfigBean;
import dam.server.demo.service.ExcutorService;
import dam.server.demo.vo.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Scope(scopeName = "prototype")
@Service
@Slf4j
@AllArgsConstructor
public class ExcutorServiceImpl implements ExcutorService {
    private final ConfigBean configBean;


    /**
     * 执行脚本
     *
     * @param missionAllData 一个mission的全部内容
     * @return myResponse保证的map集合 包含执行结果以及成功与否
     */
    @Override
    public List<Map<String, String>> doExcutor(MissionAllData missionAllData) throws InterruptedException {

        List<Map<String,String>> resultMap = new ArrayList<>();
        Map<String,List<String>> maps = new HashMap<>();
        //通过missionAllData 获得mission的list 并且排序
        if (missionAllData == null || missionAllData.getMissionDataList().size() < 1) {
            throw new RuntimeException("空的脚本数据");
        }
        log.info("开始执行jsoup脚本，脚本id为==[]" + missionAllData.getJsoupMissionAll().getMaId());
        List<MissionData> missionDataList = missionAllData.getMissionDataList();
        //排序
        List<MissionData> collect = missionDataList.stream().sorted(Comparator.comparing(e -> e.getJsoupMissionOrder().getMoRank())).collect(Collectors.toList());
        //打开全新的一个服务浏览器
//        String dir = applicationArguments.getNonOptionArgs().get(0);
        System.setProperty("webdriver.chrome.driver", configBean.getJsoupSetting().getExecutor().getExecutorUrl());
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("-headless");
        WebDriver webDriver = new ChromeDriver(chromeOptions);


        //循环mission
        for (MissionData missionData : collect) {
            //获取actionVo 并且排序
            List<ActionVo> actionVos = missionData.getActionVos();
            List<ActionVo> actionVos1 = actionVos.stream().sorted(Comparator.comparing(e -> e.getActionOrder().getRank())).collect(Collectors.toList());
            for (ActionVo actionVo : actionVos1) {
                Thread.sleep(1000);
                log.info("开始执行脚本任务,脚本id=[{}],脚本数据为=[{}]",actionVo.getJsoupAction().getActionId(),actionVo);
                //判断doType是否为跳转 如果是 则跳转网页
                if (actionVo.getJsoupAction().getActionDoType().equals("goto")) {
                    webDriver.navigate().to(actionVo.getJsoupPragram().getPragramValue());
                    //如果是选择标签页 则选择标签页
                } else if(actionVo.getJsoupAction().getActionDoType().equals("switch")) {
                    Set<String> windowHandles = webDriver.getWindowHandles();
                    //循环标签 判断是否有效
                    for (String handle : windowHandles) {
                       String nowH = webDriver.getWindowHandle();
                        if (!nowH.equals(handle)){
                            webDriver.switchTo().window(handle);
                        }
                    }
                } else {
                    //判断是何种选取类型
                    WebElement webElement = null;
                    try {
                        webElement = getWebEle(actionVo.getJsoupAction().getActionEleType(), actionVo.getJsoupAction().getActionEleValue(), webDriver);
                    } catch (Exception e) {
                        //无限循环frame直到全部循环完毕为止
                          webElement = getElement(webDriver,actionVo);
                           if (webElement == null){
                               webDriver.quit();
                               throw new RuntimeException("无法寻找到组件,行动名称为:   " + actionVo.getJsoupAction().getActionName() + "    任务名称为:  "+ missionData.getJsoupMission().getMissionName() );
                           }
                                   }
                    //判断执行何种操作
                     maps = doWebEle(actionVo,webElement,maps);
                }
            }
        }
        //对maps 进行处理  合成对应行的 maplist
        Integer maxSize = 0;
        Integer num = maps.size();
        Iterator<Map.Entry<String, List<String>>> it = maps.entrySet().iterator();
        //获得最大size 确定循环获取的次数
        while (it.hasNext()) {
            Map.Entry<String, List<String>> entry = it.next();
            try {
                if (maxSize<entry.getValue().size()){
                    maxSize = entry.getValue().size();
                }
            } catch (Exception e) {
                log.error("循环错误",e);
            }
        }
        //根据最大的size 循环取值

        for (int i = 0; i < maxSize; i++) {
            Map<String,String> rowMap = new HashMap<>();
            //遍历数组
            Iterator<Map.Entry<String, List<String>>> nowit = maps.entrySet().iterator();
            //获得最大size 确定循环获取的次数
            while (nowit.hasNext()) {
                Map.Entry<String, List<String>> entry = nowit.next();
                try {
                    rowMap.put(entry.getKey(),entry.getValue().get(i));
                } catch (Exception e) {
                    rowMap.put(entry.getKey(),"");
                }
            }
            resultMap.add(rowMap);
        }
        webDriver.quit();
        return resultMap;

    }

    /**
     * 从frame中获得webelement
     * @return  获得到的组件
     */
    private WebElement getElement(WebDriver webDriver,ActionVo actionVo){
        List<WebElement> iframe = webDriver.findElements(By.tagName("iframe"));
        for (int i = 0; i < iframe.size(); i++) {
            try {
                return getWebEle(actionVo.getJsoupAction().getActionEleType(),actionVo.getJsoupAction().getActionEleValue(),webDriver);
            } catch (Exception e) {
                log.info("非此frame");
            }
            webDriver.switchTo().frame(i);
            List<WebElement> iframe1 = webDriver.findElements(By.tagName("iframe"));
            if (iframe1.size()>0){
                try {
                    WebElement webElement = getWebEle(actionVo.getJsoupAction().getActionEleType(),actionVo.getJsoupAction().getActionEleValue(),webDriver);
                    return webElement;
                } catch (Exception e) {
                    log.info("非此frame");
                }
                WebDriver webDriver1 = webDriver;
                getElement(webDriver1,actionVo);
            }else {
                try {
                    WebElement webElement = getWebEle(actionVo.getJsoupAction().getActionEleType(),actionVo.getJsoupAction().getActionEleValue(),webDriver);
                    return webElement;
                } catch (Exception e) {
                   log.info("非此frame");
                }
            }
            webDriver.switchTo().parentFrame();
        }
        return null;
    }
    /**
     * 选取一个 webEle
     *
     * @param type
     * @param value
     * @param webDriver
     * @return
     */
    private WebElement getWebEle(String type, String value, WebDriver webDriver) {
        WebElement ele;
        log.info("获取action 实例 开始  入参 eleType=[{}],eleValue=[{}]", type, value);
        switch (type) {
            case "id": {
                ele = webDriver.findElement(By.id(value));
                break;
            }
            case "name": {
                ele = webDriver.findElement(By.name(value));
                break;
            }
            case "tagName": {
                ele = webDriver.findElement(By.tagName(value));
                break;
            }
            case "className": {
                ele = webDriver.findElement(By.className(value));
                break;
            }
            case "xpath": {
                ele = webDriver.findElement(By.xpath(value));
                break;
            }
            case "css": {
                ele = webDriver.findElement(By.cssSelector(value));
                break;
            }
            default: {
                throw new RuntimeException("无效的选取类型:   " + type);
            }
        }
        return ele;
    }

    /**
     * 执行操作
     *
     * @param actionVo
     * @param element
     * @param maps
     * @return
     */
    Map<String,List<String>> doWebEle(ActionVo actionVo, WebElement element, Map<String,List<String>> maps) {
        String doType = actionVo.getJsoupAction().getActionDoType();
        switch (doType) {
            case "submit": {
                element.submit();
                break;
            }
            case "clear": {
                element.clear();
                break;
            }
            //如果为输入input 属性
            case "input": {
                element.sendKeys(getPragramCode(actionVo));
                break;
            }
            case "click": {
                element.click();
                break;
            }
            case "output": {
                //map 集合的key
                String key = actionVo.getJsoupPragram().getPragramValue();
               List<String> values = maps.get(key);
               //如果不存在对应的值 则进行设计增加map
               if (values == null){
                  List<String> list = new ArrayList();
                  list.add(element.getText());
                  maps.put(key,list);
               }else {
                   //如果存在 则更新插入values
                 values.add(element.getText());
                   maps.put(key,values);
               }


                break;
            }
            default: {
               throw new RuntimeException("无效的执行类型:  " + doType);
            }
        }
        return maps;
    }

    /**
     * 获取参数码
     * @param actionVo
     * @return
     */
    String getPragramCode(ActionVo actionVo){
        JsoupPragram jsoupPragram = actionVo.getJsoupPragram();
        String pType = jsoupPragram.getPragramType();
       if (pType.equals("int")||pType.equals("decimal")){
           if (jsoupPragram.getIsRamdom() == 1){
               float high = jsoupPragram.getUpNum().floatValue();
               float down = jsoupPragram.getDownNum().floatValue();
               BigDecimal thisOne = new BigDecimal(Math.random()*(high-down)+down);
               if (jsoupPragram.getPragramAccuracy() != null && pType.equals("decimal")){
                     thisOne.setScale(jsoupPragram.getPragramAccuracy(),BigDecimal.ROUND_HALF_UP);
               }
               return thisOne.toString();
           }else {
               return jsoupPragram.getPragramValue();
           }
       }else if (pType.equals("variable")){
           //如果是变量 这里增删switch
           String pValue = jsoupPragram.getPragramValue();
           switch (pValue){
               case "todayDate":{
                 return new Date().toString();
               }
               default: {
                   return jsoupPragram.getPragramValue();
               }
           }
       }else {
           return jsoupPragram.getPragramValue();
       }
    }

}
