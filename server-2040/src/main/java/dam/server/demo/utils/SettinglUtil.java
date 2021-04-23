package dam.server.demo.utils;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import dam.server.demo.pojo.JsoupSetting;
import org.springframework.util.ResourceUtils;

import java.io.*;

/**
 * @author : dam
 * @description :操作yaml的工具类
 * @create :2021-04-22 15:09:00
 */
public class SettinglUtil {
    /**
     * 获取配置文件的token
     * @return 返回token
     */
    public JsoupSetting getSettingMap() {
        JsoupSetting jsoupSetting = new JsoupSetting();
        try {
            String src =  this.getClass().getResource("/setting.json").getPath();
             jsoupSetting = JSONObject.parseObject(new FileInputStream(src), JsoupSetting.class, Feature.AutoCloseSource,
                    // 允许注释
                    Feature.AllowComment,
                    // 允许单引号
                    Feature.AllowSingleQuotes,
                    // 使用 Big decimal
                    Feature.UseBigDecimal);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsoupSetting;

    }


    public  void setSettingMap (JsoupSetting jsoupSetting) {
        try {
            String json = JSONObject.toJSONString(jsoupSetting);
            String src = ResourceUtils.CLASSPATH_URL_PREFIX + "setting.json";
            FileOutputStream fileOutputStream = new FileOutputStream(src);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
            bufferedWriter.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
