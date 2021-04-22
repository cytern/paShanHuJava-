package dam.server.demo.utils;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Map;

/**
 * @author : dam
 * @description :操作yaml的工具类
 * @create :2021-04-22 15:09:00
 */
public class YamlUtil {
    /**
     * 获取配置文件的token
     * @return 返回token
     */
    public static String getToken () {
        try {
            String src = "src/main/resources/setting.yaml";
            DumperOptions dumperOptions = new DumperOptions();
            dumperOptions.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
            dumperOptions.setDefaultScalarStyle(DumperOptions.ScalarStyle.PLAIN);
            dumperOptions.setPrettyFlow(false);
            Yaml yaml = new Yaml(dumperOptions);
            Map map =yaml.load(new FileInputStream(src));
            return (String) map.get("token");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "";

    }


    public static void setToken (String token) {
        try {
            String src = "src/main/resources/setting.yaml";
            DumperOptions dumperOptions = new DumperOptions();
            dumperOptions.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
            dumperOptions.setDefaultScalarStyle(DumperOptions.ScalarStyle.PLAIN);
            dumperOptions.setPrettyFlow(false);
            Yaml yaml = new Yaml(dumperOptions);
            Map map =yaml.load(new FileInputStream(src));
            map.put("token",token);
            yaml.dump(map,new OutputStreamWriter(new FileOutputStream(src)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
