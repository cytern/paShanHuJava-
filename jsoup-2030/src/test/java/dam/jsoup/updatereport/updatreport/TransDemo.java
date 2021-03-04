package dam.jsoup.updatereport.updatreport;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import dam.jsoup.updatereport.updatreport.util.fanyi.TransApi;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;

@SpringBootTest
public class TransDemo {
    private static final String APP_ID = "20201207000640772";
    private static final String SECURITY_KEY = "vKJiDf4Rq1n3eIzN8lHj";
    @Test
    void go() throws IOException, InterruptedException {

        String base = "D:\\game\\steam\\steamapps\\common\\Stardew Valley\\Mods\\Stardew Valley Expanded\\[CP] Stardew Valley Expanded\\assets\\CharacterFiles\\Dialogue";
        File directory = new File(base);
        File[] files = directory.listFiles();
        TransApi api = new TransApi(APP_ID, SECURITY_KEY);
        if (files==null){
            return;
        }
        for(int i = 0; i< files.length; i++){

            System.out.println(files[i].getName());
            String pBase = base + "\\" + files[i].getName();
//            System.out.println(pBase);
            File dis2 = new File(pBase);
            File[] files1 = dis2.listFiles();
            try {
                if (files1==null){
                    break;
                }
                for (File file : files1) {
                    if (file.getName().endsWith("json")){
                        String jsonStr ;
                        FileReader fileReader = new FileReader(file);
                        Reader reader = new InputStreamReader(new FileInputStream(file),"utf-8");
                        int ch = 0;
                        StringBuffer sb = new StringBuffer();
                        while ((ch = reader.read()) != -1) {
                            sb.append((char) ch);
                        }
                        fileReader.close();
                        reader.close();
                        jsonStr = sb.toString();
                        JSONObject jsonObject = JSON.parseObject(jsonStr);
                        Map<String, Object> temMap =new HashMap<>();

                        Iterator it =jsonObject.entrySet().iterator();
                        while (it.hasNext()) {
                            Map.Entry<String, Object> entry = (Map.Entry<String, Object>) it.next();
                            String waitTrans = (String) entry.getValue();
                            System.out.println("读取到参数   " + waitTrans);

                           String query = changeType(waitTrans);
                            System.out.println("发送查询参数   "+query);
                           String res =api.getTransResult(query, "en", "zh");
                           Thread.sleep(3000);
                           JSONObject resObj = JSON.parseObject(res);
                            Map<String, Object> temRes =new HashMap<>();
                            Iterator resIt =resObj.entrySet().iterator();
                            while (resIt.hasNext()) {
                                Map.Entry<String, Object> resty = (Map.Entry<String, Object>) resIt.next();
                                temRes.put(resty.getKey(), resty.getValue());
                            }

                            List<Map<String,Object>> s = (List<Map<String, Object>>) temRes.get("trans_result");
                            Map<String,Object> map = s.get(0);
                            String resString = (String) map.get("dst");
                            System.out.println("翻译后参数  " + resString );
                            String finalyString  = backType(resString);
                            System.out.println("最终参数：" + finalyString);
                            temMap.put(entry.getKey(),finalyString);
                        }
                        File file2 =new File(pBase+ "\\"+"en_"+file.getName());
                        if(!file.exists()) {
                            file.createNewFile();
                        }
                        FileWriter fileWriter = new FileWriter(file2);
                        fileWriter.write(jsonObject.toString());
                        fileWriter.flush();
                        fileWriter.close();
                        File file4 = new File(pBase + "\\" + file.getName());
                        FileWriter fileWriter1 = new FileWriter(file4);
                        fileWriter1.write(JSONObject.toJSONString(temMap));
                        fileWriter1.flush();
                        fileWriter1.close();

                    }
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static String changeType (String in) {
       Map<String,Object> doc  = getDoc();
        Map<String,String> keyMap = (Map<String, String>) doc.get("toMap");
        List<String> key = (List<String>) doc.get("key");
      in =    in.replaceAll(Matcher.quoteReplacement("#$e#"),Matcher.quoteReplacement(" 5&！"));
      in =    in.replaceAll(Matcher.quoteReplacement("#$a#"),Matcher.quoteReplacement(" 1&！"));
        in =    in.replaceAll(Matcher.quoteReplacement("#$b#"),Matcher.quoteReplacement(" 2&！"));
        in =    in.replaceAll(Matcher.quoteReplacement("#$c#"),Matcher.quoteReplacement(" 3&！"));
        in =    in.replaceAll(Matcher.quoteReplacement("#$d#"),Matcher.quoteReplacement(" 4&！"));
        in =    in.replaceAll(Matcher.quoteReplacement("#$f#"),Matcher.quoteReplacement(" 6&！"));
        in =    in.replaceAll(Matcher.quoteReplacement("#$g#"),Matcher.quoteReplacement(" 7&！"));
        in =    in.replaceAll(Matcher.quoteReplacement("#$h#"),Matcher.quoteReplacement(" 8&！"));
        for (String s : key) {
            in =   in.replaceAll(Matcher.quoteReplacement(s),Matcher.quoteReplacement(keyMap.get(s)));
        }
        in =    in.replaceAll(Matcher.quoteReplacement("$"),Matcher.quoteReplacement(" 9&！"));
//        in =    in.replaceAll(Matcher.quoteReplacement("$"),Matcher.quoteReplacement(" 10&！"));
//        in =    in.replaceAll(Matcher.quoteReplacement("$"),Matcher.quoteReplacement(" 11&！"));
        in =    in.replaceAll(Matcher.quoteReplacement("Passage"),Matcher.quoteReplacement("鱻"));


        return in;
    }
    public static  String backType (String in) {
        Map<String,Object> doc  = getDoc();
        Map<String,String> valueMap = (Map<String, String>) doc.get("backMap");
        List<String> value = (List<String>) doc.get("value");
        in =    in.replaceAll(Matcher.quoteReplacement("1&！"),Matcher.quoteReplacement("#$a#"));
        in =    in.replaceAll(Matcher.quoteReplacement("2&！"),Matcher.quoteReplacement("#$b#"));
        in =    in.replaceAll(Matcher.quoteReplacement("3&！"),Matcher.quoteReplacement("#$c#"));
        in =    in.replaceAll(Matcher.quoteReplacement("4&！"),Matcher.quoteReplacement("#$d#"));
        in =    in.replaceAll(Matcher.quoteReplacement("5&！"),Matcher.quoteReplacement("#$e#"));
        in =    in.replaceAll(Matcher.quoteReplacement("6&！"),Matcher.quoteReplacement("#$f#"));
        in =    in.replaceAll(Matcher.quoteReplacement("7&！"),Matcher.quoteReplacement("#$g#"));
        in =    in.replaceAll(Matcher.quoteReplacement("8&！"),Matcher.quoteReplacement("#$h#"));

        for (String s : value) {
            in =    in.replaceAll(Matcher.quoteReplacement(s),Matcher.quoteReplacement(valueMap.get(s)));
        }
        in =    in.replaceAll(Matcher.quoteReplacement("9&！"),Matcher.quoteReplacement("$"));
        in =    in.replaceAll(Matcher.quoteReplacement("9和"),Matcher.quoteReplacement("$"));
//        in =    in.replaceAll(Matcher.quoteReplacement("10&！"),Matcher.quoteReplacement("...$"));
//        in =    in.replaceAll(Matcher.quoteReplacement("11&！"),Matcher.quoteReplacement("$"));
        in =    in.replaceAll(Matcher.quoteReplacement("鱻"),Matcher.quoteReplacement("Passage"));
        in =    in.replaceAll(Matcher.quoteReplacement("年"),Matcher.quoteReplacement(""));
        in =    in.replaceAll(Matcher.quoteReplacement(" "),Matcher.quoteReplacement(""));
        in =    in.replaceAll("\\.","");
        return in;
    }

    public static Map<String,Object> getDoc (){
        Map<String,String> map1 = new HashMap<>();
        Map<String,String> map2 = new HashMap<>();
        List<String> key = new ArrayList<>();
        List<String> value = new ArrayList<>();
//        for (int i = 0; i < 50; i++) {
//            map1.put(".$"+ i,"垚"+i);
//            map2.put("垚"+i,".$"+ i);
//            key.add(".$"+i);
//            value.add("垚"+i);
//            map1.put("...$"+ i,"淼"+i);
//            map2.put("淼"+i,"...$"+ i);
//            key.add("...$"+i);
//            value.add(" 淼"+i);
//        }
        Map<String,Object> map = new HashMap<>();
        map.put("toMap",map1);
        map.put("backMap",map2);
        map.put("key",key);
        map.put("value",value);
        return map;
    }

    }
