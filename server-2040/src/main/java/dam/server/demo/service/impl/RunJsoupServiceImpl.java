package dam.server.demo.service.impl;

import dam.server.demo.config.ConfigBean;
import dam.server.demo.config.TaskThreadPoolConfig;
import dam.server.demo.pojo.ResultVO;
import dam.server.demo.service.ExcutorService;
import dam.server.demo.service.RunJsoupService;
import dam.server.demo.utils.HttpUtils;
import dam.server.demo.vo.HttpMissionDataVo;
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
    @Autowired
    private ExcutorService excutorService;
    /**
     * 异步执行服务
     */
    @Async("taskExecutor")
    @Override
    public void run() {
        //循环执行任务

            /**
             *  获取 任务 执行任务的程序
             */
            try {
                getNewTask();
            } catch (InterruptedException e) {
                e.printStackTrace();
                log.info("线程休眠错误");
            }

    }


    private void getNewTask() throws InterruptedException {
        ConfigBean configBean = ConfigBean.getInstance();
        log.info("  脚本执行线程   开始一次新的任务循环");
        //准备请求的参数
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        //cpu 识别码 未来可能替换成为token
        params.add("code",configBean.getCpuCoreId());
        params.add("token",configBean.getJsoupSetting().getExecutor().getToken());
        //发送请求
        HttpMissionDataVo missionAllData = null;
            try {
                //联网获取数据
                log.info("  脚本执行线程   获取执行脚本数据");
                missionAllData = HttpUtils.getDataApi(configBean.getGetTask(),params);
            } catch (Exception e) {
               log.error("网络请求失败",e);
                return;
            }
         //判断数据是否正确
        if (missionAllData.getState() != 1) {
            log.error("接受数据错误");
            return;
        }
        log.info("  脚本执行线程   开始执行脚本  执行数据=[{}]",missionAllData);
            List result = null;
            try {
                result = excutorService.doExcutor(missionAllData.getMissionAllData());
                //取值正常 则 进行处理
                missionAllData.setResult(result);
                missionAllData.setState(1);
            } catch (Exception e) {
               //异常 包装
                missionAllData.setException(e.getMessage());
                missionAllData.setState(2);
            }

        Boolean sendData =true;
        log.info("  脚本执行线程   开始发送结果集 ");
//       循环执行 直到发送成功 十秒间隔
        while (sendData) {
            try {
                 HttpUtils.sendDataApi(configBean.getReturnTask(),missionAllData);
                sendData = false;
            } catch (Exception e) {
                log.error("网络请求失败");
                Thread.sleep(10000);
            }
        }
        log.info("脚本执行线程 发送成功");


    }
}
