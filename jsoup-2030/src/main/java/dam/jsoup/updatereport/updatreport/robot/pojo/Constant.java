package dam.jsoup.updatereport.updatreport.robot.pojo;

public interface Constant {
    interface commands {
        String search = "查分";
        String bind = "绑定";
        String picSearch = "图片查分";
        String ageSearchPicCreate = "帝国成绩图片生成";
    }
    interface redisKey {
        String cachedData = "ageData:cached:";

        String hotData = "ageData:hotData:";


    }
}
