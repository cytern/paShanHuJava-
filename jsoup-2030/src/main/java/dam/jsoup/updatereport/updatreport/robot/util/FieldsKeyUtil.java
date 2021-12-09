package dam.jsoup.updatereport.updatreport.robot.util;

import dam.jsoup.updatereport.updatreport.robot.dto.QqDetail;

import java.util.HashMap;
import java.util.List;

public class FieldsKeyUtil {
    public static HashMap<String,String> chargeList(List<QqDetail> details) {
        HashMap<String, String> stringObjectHashMap = new HashMap<>();
        for (QqDetail detail : details) {
            stringObjectHashMap.put(detail.getFormName(),detail.getFieldValue());
        }
        return stringObjectHashMap;
    }
}
