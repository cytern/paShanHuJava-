package dam.jsoup.updatereport.updatreport.robot.service.impl;

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.nlp.v20190408.NlpClient;
import com.tencentcloudapi.nlp.v20190408.models.*;
import dam.jsoup.updatereport.updatreport.robot.pojo.Constant;
import dam.jsoup.updatereport.updatreport.robot.service.TencentApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TencentApiServiceImpl implements TencentApiService {
    @Value("${tencent.SecretId}")
    private String SecretId;
    @Value("${tencent.SecretKey}")
    private String SecretKey;
    /**
     * 与闲聊机器人闲聊
     *
     * @param message
     * @return
     */
    @Override
    public String newChatWithRobot(String message) {
        Credential cred = new Credential(SecretId, SecretKey);
        // 实例化一个http选项，可选的，没有特殊需求可以跳过
        HttpProfile httpProfile = new HttpProfile();
        httpProfile.setEndpoint("nlp.tencentcloudapi.com");
        // 实例化一个client选项，可选的，没有特殊需求可以跳过
        ClientProfile clientProfile = new ClientProfile();
        clientProfile.setHttpProfile(httpProfile);
        // 实例化要请求产品的client对象,clientProfile是可选的
        NlpClient client = new NlpClient(cred, "ap-guangzhou", clientProfile);
        // 实例化一个请求对象,每个接口都会对应一个request对象
        ChatBotRequest req = new ChatBotRequest();
        req.setQuery(message);

        // 返回的resp是一个ChatBotResponse的实例，与请求对象对应
        try {
            ChatBotResponse resp = client.ChatBot(req);
            return resp.getReply();
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        }
        return "咩咩?";
    }

    /**
     * 返回转化之后的语音消息下载地址
     *
     * @param message
     * @return
     */
    @Override
    public String getChatFile(String message) {
        return null;
    }

    /**
     * 获取对话的情绪
     *
     * @param message
     * @return
     */
    @Override
    public Integer getMessageEmotion(String message) {
        try{
            // 实例化一个认证对象，入参需要传入腾讯云账户secretId，secretKey,此处还需注意密钥对的保密
            // 密钥可前往https://console.cloud.tencent.com/cam/capi网站进行获取
            Credential cred = new Credential(SecretId, SecretKey);
            // 实例化一个http选项，可选的，没有特殊需求可以跳过
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("nlp.tencentcloudapi.com");
            // 实例化一个client选项，可选的，没有特殊需求可以跳过
            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);
            // 实例化要请求产品的client对象,clientProfile是可选的
            NlpClient client = new NlpClient(cred, "ap-guangzhou", clientProfile);
            // 实例化一个请求对象,每个接口都会对应一个request对象
            SentimentAnalysisRequest req = new SentimentAnalysisRequest();
            req.setText(message);
            req.setMode("3class");
            // 返回的resp是一个SentimentAnalysisResponse的实例，与请求对象对应
            SentimentAnalysisResponse resp = client.SentimentAnalysis(req);
            // 输出json格式的字符串回包
            Float negative = resp.getNegative();
            Float positive = resp.getPositive();
            Float neutral = resp.getNeutral();
            //正常语气
            if (neutral > 0.9) {
                return Constant.emotion.normal;
            }
            //略显积极的情况下
            if (positive > 0.5) {
                //判断是否是害羞的语气
                if (isShameMessage(message)) {
                    //是害羞的如果积极性大于 8.5就是非常害羞
                    if (positive > 0.85) {
                        return Constant.emotion.shame;
                    }else {
                        return Constant.emotion.someShame;
                    }
                }else {
                    //不是害羞的情况 区分开心和非常开心
                    if (positive > 0.85) {
                        return Constant.emotion.happy;
                    }else {
                        if (neutral > negative ) {
                            return Constant.emotion.someHappy;
                        }else {
                            return Constant.emotion.someSad;
                        }

                    }
                }
            }else if (negative >0.5){
               if (isAngryMessage(message)) {
                   if (negative > 0.85) {
                       return Constant.emotion.angry;
                   }else {
                       return Constant.emotion.someAngry;
                   }
               }else {
                   if (negative>0.85) {
                       return Constant.emotion.sad;
                   }else {
                       if (neutral > positive) {
                           return Constant.emotion.someSad;
                       }else {
                           return Constant.emotion.someAngry;
                       }
                   }
               }
            }else {
                return Constant.emotion.normal;
            }
        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
        }
        return Constant.emotion.normal;
    }

    private boolean isShameMessage(String message) throws TencentCloudSDKException {
        Credential cred = new Credential(SecretId, SecretKey);
        // 实例化一个http选项，可选的，没有特殊需求可以跳过
        HttpProfile httpProfile = new HttpProfile();
        httpProfile.setEndpoint("nlp.tencentcloudapi.com");
        // 实例化一个client选项，可选的，没有特殊需求可以跳过
        ClientProfile clientProfile = new ClientProfile();
        clientProfile.setHttpProfile(httpProfile);
        NlpClient client = new NlpClient(cred, "ap-guangzhou", clientProfile);
        // 实例化一个请求对象,每个接口都会对应一个request对象
        TextSimilarityRequest req = new TextSimilarityRequest();
        req.setSrcText(message);

        String[] targetText1 = {"我喜欢你", "我爱你", "你太可爱了"};
        req.setTargetText(targetText1);

        // 返回的resp是一个TextSimilarityResponse的实例，与请求对象对应
        TextSimilarityResponse resp = client.TextSimilarity(req);
        Similarity[] similarity = resp.getSimilarity();
        for (int i = 0; i < similarity.length; i++) {
            Float score = similarity[i].getScore();
            if (score > 0.75) {
                return true;
            }
        }
        return false;
    }

    private boolean isAngryMessage(String message) throws TencentCloudSDKException {
        Credential cred = new Credential(SecretId, SecretKey);
        // 实例化一个http选项，可选的，没有特殊需求可以跳过
        HttpProfile httpProfile = new HttpProfile();
        httpProfile.setEndpoint("nlp.tencentcloudapi.com");
        // 实例化一个client选项，可选的，没有特殊需求可以跳过
        ClientProfile clientProfile = new ClientProfile();
        clientProfile.setHttpProfile(httpProfile);
        NlpClient client = new NlpClient(cred, "ap-guangzhou", clientProfile);
        // 实例化一个请求对象,每个接口都会对应一个request对象
        TextSimilarityRequest req = new TextSimilarityRequest();
        req.setSrcText(message);

        String[] targetText1 = {"是你的不对", "你不好", "你不应该这样","讨厌你"};
        req.setTargetText(targetText1);

        // 返回的resp是一个TextSimilarityResponse的实例，与请求对象对应
        TextSimilarityResponse resp = client.TextSimilarity(req);
        Similarity[] similarity = resp.getSimilarity();
        for (int i = 0; i < similarity.length; i++) {
            Float score = similarity[i].getScore();
            if (score > 0.75) {
                return true;
            }
        }
        return false;
    }
}
