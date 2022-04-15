package dam.jsoup.updatereport.updatreport.robot.service.impl;

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.nlp.v20190408.NlpClient;
import com.tencentcloudapi.nlp.v20190408.models.ChatBotRequest;
import com.tencentcloudapi.nlp.v20190408.models.ChatBotResponse;
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
}
