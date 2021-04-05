package dam.jsoup.updatereport.updatreport.service.impl;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import dam.jsoup.updatereport.updatreport.dao.JsoupMissionAllHistoryMapper;
import dam.jsoup.updatereport.updatreport.pojo.JsoupMissionAllHistory;
import dam.jsoup.updatereport.updatreport.pojo.JsoupMissionAllHistoryExample;
import dam.jsoup.updatereport.updatreport.service.TimeTaskService;
import dam.jsoup.updatereport.updatreport.util.CronUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
@Service
@Transactional
public class TimeTaskServiceImpl implements TimeTaskService {

    private final JsoupMissionAllHistoryMapper missionAllHistoryMapper;

    public TimeTaskServiceImpl(JsoupMissionAllHistoryMapper missionAllHistoryMapper) {
        this.missionAllHistoryMapper = missionAllHistoryMapper;
    }

    /**
     * 查询定时任务列表中 是否具有需要添加的任务
     *
     * @return 符合要求的定时任务数据
     */
    @Override
    public void setTaskService() {
        //获取所有定时任务
        JsoupMissionAllHistoryExample example = new JsoupMissionAllHistoryExample();
        //确定是定时任务 且定时任务执行次数拥有剩余 或者无限执行 - 并且状态为定时任务 元数据
        example.createCriteria().andIsTimeTaskEqualTo(1).andTimeNumNotEqualTo(0).andMissionStateEqualTo("5");
        List<JsoupMissionAllHistory> histories = missionAllHistoryMapper.selectByExample(example);
        Date date = new Date();
        if (histories.size()<1){
            return;
        }else {
            //对定时任务进行筛选 corn 时间是否达到
            for (int i = 0; i < histories.size(); i++) {
                JsoupMissionAllHistory allHistory = histories.get(i);
                //时间包含在近五分钟内
                if (CronUtil.needAdd(date,allHistory.getTimeCorn())){
                    //不在近五分钟内添加的任务 否则视为已经添加过
                    example.clear();
                    Calendar c1=Calendar.getInstance();
                    c1.setTime(date);
                    c1.add(Calendar.MINUTE,-5);
                    //定时任务  总任务id 与userId 相同  最近五分钟刚添加
                    example.createCriteria().andIsTimeTaskEqualTo(1)
                            .andMissionAllIdEqualTo(allHistory.getMissionAllId())
                            .andUserIdEqualTo(allHistory.getUserId())
                            //出于现在与 过去的五分钟内
                            .andSentTimeBetween(c1.getTime(),date);
                    List<JsoupMissionAllHistory> histories1 = missionAllHistoryMapper.selectByExample(example);
                    if (histories1.size()>0){
                        continue;
                    }else {
                        //原数据的执行次数是否需要递减
                        if (allHistory.getTimeNum()!= -1){
                            //任务不正确
                            if (allHistory.getTimeNum() <=0){
                                throw new MybatisPlusException("数据异常 小于0却不等于-1的定时任务.    id:  "+allHistory.getMissionAllHistoryId());
                            }else {
                                //更新原始数据
                                allHistory.setTimeNum(allHistory.getTimeNum() -1);
                                missionAllHistoryMapper.updateByPrimaryKeySelective(allHistory);
                            }
                        }

                        //添加新的mission任务  清空任务id  设置状态为1
                        allHistory.setMissionAllHistoryId(null);
                        allHistory.setMissionState("1");
                        allHistory.setIsTimeTask(0);
                        allHistory.setTimeNum(0);
                        allHistory.setTimeCorn(null);
                        //插入数据
                        missionAllHistoryMapper.insertSelective(allHistory);
                    }

                }
            }

        }

    }
}
