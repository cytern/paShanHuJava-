package dam.server.demo.utils;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import dam.server.demo.pojo.Executor;
import dam.server.demo.pojo.JsoupSetting;
import dam.server.demo.pojo.Pool;
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
            String path = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
            String[] pathSplit = path.split("/");
            String jarName = pathSplit[pathSplit.length - 1];
            String jarPath = path.replace(jarName, "");
            String pathName=jarPath+"setting.json";
             System.out.println("配置文件路径："+jarPath);
             File file = new File(pathName);
             if (!file.exists()) {
                 file.createNewFile();
                 Pool pool = new Pool();
                 pool.setCorePoolSize(5);
                 pool.setMaxPoolSize(20);
                 pool.setKeepAliveSeconds(300);
                 pool.setQueueCapacity(50);
                 jsoupSetting.setPool(pool);
                 Executor executor = new Executor();
                 executor.setTestModel(false);
                 executor.setExecutorUrl("");
                 executor.setUserName("");
                 executor.setToken("");
                 jsoupSetting.setExecutor(executor);
                 setSettingMap(jsoupSetting);
                 return jsoupSetting;
             }

             jsoupSetting = JSONObject.parseObject(new FileInputStream(pathName), JsoupSetting.class, Feature.AutoCloseSource,
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
            String path = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
            String[] pathSplit = path.split("/");
            String jarName = pathSplit[pathSplit.length - 1];
            String jarPath = path.replace(jarName, "");
            String pathName=jarPath+"setting.json";
            File file = new File(pathName);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            outputStreamWriter.write(json);
            outputStreamWriter.flush();
            outputStreamWriter.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
