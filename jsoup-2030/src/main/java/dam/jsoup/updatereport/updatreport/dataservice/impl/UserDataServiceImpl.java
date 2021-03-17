package dam.jsoup.updatereport.updatreport.dataservice.impl;

import cn.hutool.core.util.IdUtil;
import dam.jsoup.updatereport.updatreport.dao.JsoupUserMapper;
import dam.jsoup.updatereport.updatreport.dataservice.UserDataService;
import dam.jsoup.updatereport.updatreport.pojo.JsoupUser;
import dam.jsoup.updatereport.updatreport.pojo.JsoupUserExample;
import dam.jsoup.updatereport.updatreport.util.AesUtil;
import dam.jsoup.updatereport.updatreport.util.MyResponse;
import lombok.extern.slf4j.Slf4j;


import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class UserDataServiceImpl implements UserDataService {
    private final Environment env;
    private final JsoupUserMapper userMapper;

    public UserDataServiceImpl(Environment env, JsoupUserMapper userMapper) {
        this.env = env;
        this.userMapper = userMapper;
    }

    /**
     * 登录验证
     *
     * @param userName 用户名
     * @param password 密码
     * @return 是否正确
     */
    @Override
    public Map login(String userName, String password) {
        Map map = new HashMap();
        JsoupUserExample example = new JsoupUserExample();
        example.createCriteria().andUsernameEqualTo(userName);
        List<JsoupUser> users = userMapper.selectByExample(example);
        //判断是否具有该用户
        if (users.size() != 1 || users.get(0).getUserType().equals("0000")) {
          map = MyResponse.myResponseError("无效的用户");
        }else {
            JsoupUser user = users.get(0);
            //判断密码是否正确
            if (user.getPassword().equals(AesUtil.enAes(password))){
                //生成token 序列 也将作为唯一用户凭证
                String token = IdUtil.fastSimpleUUID();
                user.setUserToken(token);
                try {
                    userMapper.updateByPrimaryKey(user);
                     map = MyResponse.myResponseOk("登录成功");
                     map.put("token",token);
                     map.put("role",user.getUserType());
                } catch (Exception e) {
                    log.error("更新用户token失败",e);
                     map = MyResponse.myResponseError("登录失败，系统内部异常");
                }
            }else {
                 map = MyResponse.myResponseError("用户名或密码错误");
            }
            return map;
        }
        return map;
    }

    /**
     * 发送邮件
     *
     * @param userName 用户名
     * @return 是否成功
     */
    @Override
    public Boolean sendEmail(String userName) {
        return null;
    }
}
