package dam.jsoup.updatereport.updatreport.util.readJson;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.*;

public class JsonUtil {

    //json转对象
    public static void main(String[] args){
        String path = JsonUtil.class.getClassLoader().getResource("test.json").getPath();
        String s = JsonUtil.readJsonFile(path);
        JSONObject jobj = JSON.parseObject(s);
        System.out.println("name"+jobj.get("name"));
        JSONObject address1 = jobj.getJSONObject("address");
        String street = (String) address1.get("street");
        String city = (String) address1.get("city");
        String country = (String) address1.get("country");

        System.out.println("street :" + street);
        System.out.println("city :" + city);
        System.out.println("country :" + country);

        JSONArray links = jobj.getJSONArray("links");

        for (int i = 0 ; i < links.size();i++){
            JSONObject key1 = (JSONObject)links.get(i);
            String name = (String)key1.get("name");
            String url = (String)key1.get("url");
            System.out.println(name);
            System.out.println(url);
        }
    }

    /**
     * 读取json文件，返回json串
     * @param fileName
     * @return
     */
    public static String readJsonFile(String fileName) {
        String jsonStr = "";
        try {
            File jsonFile = new File(fileName);
            FileReader fileReader = new FileReader(jsonFile);

            Reader reader = new InputStreamReader(new FileInputStream(jsonFile),"utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}