package dam.server.demo.service.impl;

import dam.server.demo.config.ConfigBean;
import dam.server.demo.config.TaskThreadPoolConfig;
import dam.server.demo.pojo.ResultVO;
import dam.server.demo.service.ExcutorService;
import dam.server.demo.service.RunJsoupService;
import dam.server.demo.utils.HttpUtils;
import dam.server.demo.vo.MissionAllData;
import dam.server.demo.vo.MyResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import javax.xml.transform.Result;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 任务执行脚本
 */
@Service
@Slf4j
public class RunJsoupServiceImpl implements RunJsoupService {
    private MissionAllData missionAllData;
    @Autowired
    private ExcutorService excutorService;
    @Autowired
    private ConfigBean configBean;
    /**
     * 异步执行服务
     */
    @Async
    @Override
    public void run() {
        //循环执行任务
        while (true) {
            /**
             * 循环执行 获取 任务 执行任务的程序
             */
          getNewTask();
        }
    }


    private void getNewTask(){
        //准备请求的参数
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        //cpu 识别码 未来可能替换成为token
        params.add("code",configBean.getCpuCoreId());
        //发送请求
        MissionAllData missionAllData = null;
        Boolean getData = true;
        while (getData) {
            try {
                missionAllData = HttpUtils.getDataApi(configBean.getGetTask(),params);
                Thread.sleep(30000);
            } catch (Exception e) {
               log.error("获取数据失败",e);
            }
        }
        Map map = new HashMap();
        log.info("开始执行任务");
        try {
            List result = excutorService.doExcutor(missionAllData);
            map = MyResponse.myResponseOk("执行成功");
            map.put("result",result);
        } catch (Exception e) {
            log.error("有问题啊 你写的脚本 :   ******",e);
            map = MyResponse.myResponseError(e.getMessage());
        }
        Boolean sendData =true;
        log.info("任务执行完毕");
//       循环执行 直到发送成功
        while (sendData) {
            try {
                sendData = !HttpUtils.sendDataApi(configBean.getReturnTask(),map);
                Thread.sleep(30000);
            } catch (Exception e) {
                log.error("网络请求失败",e);
            }
        }


    }
}
