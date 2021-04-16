package dam.jsoup.updatereport.updatreport.util;

import dam.jsoup.updatereport.updatreport.vo.MissionAllData;
import dam.jsoup.updatereport.updatreport.vo.MissionData;

import java.math.BigDecimal;
import java.util.List;

public class MissionDataRunPriceUtil {
    /**
     * 检查价格
     * @return
     */
    public static BigDecimal checkMissionAllDataPrice (MissionAllData missionAllData) {
        BigDecimal bigDecimal = new BigDecimal(0);
        List<MissionData> missionDataList = missionAllData.getMissionDataList();
        Integer count = 0;
        for (MissionData missionData : missionDataList) {
            count = count + missionData.getActionVos().size();
        }
//       梯度增加金额
//        基础价格 100
        bigDecimal = bigDecimal.add(new BigDecimal(100));
//        100步以内 每步3块
        if (count < 100) {
            bigDecimal = bigDecimal.add(new BigDecimal(count*3));
            return bigDecimal;
        }else {
            bigDecimal= bigDecimal.add(new BigDecimal(100*3));
            count = count -100;
            if (count < 900) {
                bigDecimal =bigDecimal.add(new BigDecimal(count*2));
                return bigDecimal;
            }else {
                bigDecimal = bigDecimal.add(new BigDecimal(900*2));
                count = count -900;
                bigDecimal = bigDecimal.add(new BigDecimal(count*1));
                return bigDecimal;
            }
        }
    }
}
