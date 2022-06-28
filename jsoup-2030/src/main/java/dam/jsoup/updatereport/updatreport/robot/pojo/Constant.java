package dam.jsoup.updatereport.updatreport.robot.pojo;

import io.swagger.models.auth.In;

public interface Constant {
    interface commands {
        String search = "查分";
        String bind = "绑定";
        String picSearch = "图片查分";
        String ageSearchPicCreate = "帝国成绩图片生成";
        String send = "发送";
        String autoSend = "自动回复";
        String speakAs = "快说";
        String robotPic = "机器图片";
        String robotEmotion = "机器情绪";
    }
    interface redisKey {
        String cachedData = "ageData:cached:";

        String hotData = "ageData:hotData:";


    }
    interface emotion {
        /**
         * 很生气
         */
        Integer angry = 1;
        /**
         * 有点生气 /傲娇
         */
        Integer someAngry = 2;
        /**
         * 非常伤心
         */
        Integer sad = 3;
        /**
         * 有点伤心难过
         */
        Integer someSad = 4;
        /**
         * 正常的
         */
        Integer normal = 5;
        /**
         * 心情不错的
         */
        Integer someHappy = 6;
        /**
         * 很开心
         */
        Integer happy = 7;
        /**
         * 有点害羞
         */
        Integer someShame = 8;
        /**
         * 非常害羞 娇羞
         */
        Integer shame = 9;

    }

    interface businessCode {
        /**
         * 个人好感度 跨群
         */
        Integer onesDisposition = 1;
        /**
         * 个人物品列表
         */
        Integer onesItemList = 2;
        /**
         * 更新所有现行的机器物品
         */
        Integer updateAllRotItem = 3;


    }
}
