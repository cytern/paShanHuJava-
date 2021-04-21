package dam.jsoup.updatereport.updatreport.excutor;

import dam.jsoup.updatereport.updatreport.config.ServerConfig;
import dam.jsoup.updatereport.updatreport.dao.HandMapper;
import dam.jsoup.updatereport.updatreport.dao.JsoupExcutorMapper;
import dam.jsoup.updatereport.updatreport.dao.JsoupMissionAllHistoryMapper;
import dam.jsoup.updatereport.updatreport.pojo.JsoupExcutor;
import dam.jsoup.updatereport.updatreport.pojo.JsoupMissionAllHistory;
import dam.jsoup.updatereport.updatreport.pojo.JsoupMissionAllHistoryExample;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class HeartHitCheckService {
    private final JsoupExcutorMapper excutorMapper;
    private final HandMapper handMapper;
    private final ServerConfig serverConfig;
    private final JsoupMissionAllHistoryMapper historyMapper;

    @Async("taskPool")
    public void judgeExecutorLive() {
        log.info("初始化 开始检索执行器动态池 ");
        while (true) {
            try {
                Thread.sleep(serverConfig.getCheckDateT()*60*1000);
                log.info("等待结束 开始检索执行池  ");
                checkExcutor();
                Thread.sleep(serverConfig.getCheckDateT()*60*1000);
            } catch (Exception e) {
                log.error("检索执行池  失败 ",e);
            }
        }
    }

    private void checkExcutor () {
        List<JsoupExcutor> allLiveExcutor = handMapper.getAllLiveExcutor();
        for (JsoupExcutor jsoupExcutor : allLiveExcutor) {
             checkDate(jsoupExcutor);
        }
    }

    private void checkDate(JsoupExcutor excutor) {
        Date lastTime = excutor.getLiveUpdateTime();
        Calendar c1=Calendar.getInstance();
        Calendar c2=Calendar.getInstance();
        c1.setTime(lastTime);
        Date nowDate = new Date();
        c2.setTime(nowDate);
        c1.add(Calendar.MINUTE,3*serverConfig.getCheckDateT());
        //如果时间超过3t
        if (c1.before(c2)){
          //超时 统计为dead
            excutor.setStatus("0");

            //更新为dead
            handMapper.updateExcutorByExcutorToken(excutor);
            //获取正在执行 执行号为此的任务 转化为待执行
            JsoupMissionAllHistoryExample historyExample = new JsoupMissionAllHistoryExample();
            historyExample.createCriteria().andMissionStateEqualTo("2").andExcutorTokenEqualTo(excutor.getExcutorToken());
            List<JsoupMissionAllHistory> histories = historyMapper.selectByExample(historyExample);
            if (histories == null) {
              return;
            }else {
                for (JsoupMissionAllHistory history : histories) {
                    history.setMissionState("1");
                    historyMapper.updateByPrimaryKeySelective(history);
                }
            }
        }else {
            excutor.setLiveUpdateTime(new Date());
            handMapper.updateExcutorByExcutorToken(excutor);
        }
    }



}
