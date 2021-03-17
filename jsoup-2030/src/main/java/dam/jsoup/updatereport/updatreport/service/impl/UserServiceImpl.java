package dam.jsoup.updatereport.updatreport.service.impl;

import cn.hutool.core.util.IdUtil;
import dam.jsoup.updatereport.updatreport.dao.JsoupUserAssetsMapper;
import dam.jsoup.updatereport.updatreport.dao.JsoupUserDetailMapper;
import dam.jsoup.updatereport.updatreport.dao.JsoupUserMapper;
import dam.jsoup.updatereport.updatreport.dataservice.UserDataService;
import dam.jsoup.updatereport.updatreport.pojo.*;
import dam.jsoup.updatereport.updatreport.service.SendEmail;
import dam.jsoup.updatereport.updatreport.service.UserService;
import dam.jsoup.updatereport.updatreport.util.AesUtil;
import dam.jsoup.updatereport.updatreport.util.MyResponse;
import dam.jsoup.updatereport.updatreport.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@Transactional
public class UserServiceImpl implements UserService {
    private final UserDataService userDataService;
    private final JsoupUserMapper jsoupUserMapper;
    private final JsoupUserDetailMapper detailMapper;
    private final JsoupUserAssetsMapper assetsMapper;
    private static final String link = "http://localhost:2060/server/everyone/wakeUser/";
    private final SendEmail sendEmail;

    public UserServiceImpl(UserDataService userDataService, JsoupUserMapper jsoupUserMapper, JsoupUserDetailMapper detailMapper, JsoupUserAssetsMapper assetsMapper, SendEmail sendEmail) {
        this.userDataService = userDataService;
        this.jsoupUserMapper = jsoupUserMapper;
        this.detailMapper = detailMapper;
        this.assetsMapper = assetsMapper;
        this.sendEmail = sendEmail;
    }

    /**
     * 获取用户信息
     *
     * @param userVo 用户信息
     * @return 用户信息
     */
    @Override
    public UserVo getLoginData(UserVo userVo) {
        JsoupUser user = userVo.getJsoupUser();
        JsoupUserAssets assets;
        JsoupUserDetail detail;
        try {
             detail = detailMapper.selectByPrimaryKey(user.getUserId());
        } catch (Exception e) {
            log.error("查询用户详细信息失败",e);
            return null;
        }
        try {
             assets = assetsMapper.selectByPrimaryKey(user.getUserId());
        } catch (Exception e) {
            log.error("查询用户资产信息失败",e);
            return null;
        }
        userVo.setJsoupUserAssets(assets);
        userVo.setJsoupUserDetail(detail);
        return userVo;
    }

    /**
     * 登录
     *
     * @param userVo 用户信息
     * @return 用户信息
     */
    @Override
    public Map login(UserVo userVo) {
        String userName = userVo.getJsoupUser().getUsername();
        String password = userVo.getJsoupUser().getPassword();
        Map map = userDataService.login(userName, password);
        return map;
    }

    /**
     * 注册
     *
     * @param userVo 用户信息
     * @return 用户信息
     */
    @Override
    public Map registerUser(UserVo userVo) {

        //重设密码为加密后密码
        JsoupUser user = userVo.getJsoupUser();
        String password = user.getPassword();
        //验证密码长度
        String reg  = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
        if (!password.matches(reg)){
            return MyResponse.myResponseError("至少8个字符，至少1个大写字母，1个小写字母和1个数字");
        }
        //验证电话号码是否符合
        if (!userVo.getJsoupUserDetail().getUserPhone().matches("^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\\d{8}$")){
            return MyResponse.myResponseError("无效的手机号码");
        }
        if (!userVo.getJsoupUserDetail().getUserEmail().matches("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$")){
            return MyResponse.myResponseError("无效的邮箱格式");
        }
        //加密
        password = AesUtil.enAes(password);
        user.setPassword(password);
        user.setCreateTime(new Date());
        //判断用户名是否重复
        Map map = new HashMap();
        JsoupUserExample example = new JsoupUserExample();
        example.createCriteria().andUsernameEqualTo(user.getUsername());
        List<JsoupUser> list = jsoupUserMapper.selectByExample(example);
        if (list.size()>0) {
            return MyResponse.myResponseError("注册失败,用户名重复");
        }
        //判断手机号/邮箱是否重复
        JsoupUserDetailExample example1 = new JsoupUserDetailExample();
        example1.createCriteria().andUserPhoneEqualTo(userVo.getJsoupUserDetail().getUserPhone());
        List<JsoupUserDetail> jsoupUserDetails = detailMapper.selectByExample(example1);
        if (jsoupUserDetails.size()>0){
            return MyResponse.myResponseError("注册失败，该手机号已被注册");
        }
        //清除条件重新利用
        example1.clear();
        example1.createCriteria().andUserEmailEqualTo(userVo.getJsoupUserDetail().getUserEmail());
        if (detailMapper.selectByExample(example1).size()>0){
            return MyResponse.myResponseError("注册失败，该邮箱已被注册");
        }
             user.setUserType("0000");
        user.setUserToken(IdUtil.fastSimpleUUID());
            jsoupUserMapper.insert(user);
        //注入主键
            userVo.getJsoupUserDetail().setUserId(user.getUserId());
            userVo.getJsoupUserAssets().setUserId(user.getUserId());
            detailMapper.insert(userVo.getJsoupUserDetail());
            assetsMapper.insert(userVo.getJsoupUserAssets());
        userVo.setJsoupUser(user);
        map = MyResponse.myResponseOk("注册成功");
        userVo.setJsoupUser(user);
        sendEmail.sendLinkEmail(userVo.getJsoupUserDetail().getUserEmail(),link,userVo);
        map.put("user",userVo);
        return map;
    }

    /**
     * 重设密码/忘记密码
     *
     * @param userVo 用户信息
     * @return 用户信息
     */
    @Override
    public Map resetPassword(UserVo userVo) {
        //重设密码为加密后密码
        Map map = new HashMap();
        JsoupUser jsoupUser = userVo.getJsoupUser();
        String password = jsoupUser.getPassword();
        password = AesUtil.enAes(password);
        jsoupUser.setPassword(password);
        try {
            jsoupUserMapper.updateByPrimaryKey(jsoupUser);
        } catch (Exception e) {
            log.error("更新密码错误",e);
            map = MyResponse.myResponseError("更新密码失败");
        }
        map = MyResponse.myResponseOk("更新成功");
        return map;
    }

    /**
     * 修改用户信息
     *
     * @param userVo 用户信息
     * @return 用户信息
     */
    @Override
    public Map updateUser(UserVo userVo) {
        JsoupUserAssets assets = userVo.getJsoupUserAssets();
        JsoupUserDetail detail = userVo.getJsoupUserDetail();
        assets.setUserId(userVo.getJsoupUser().getUserId());
        detail.setUserId(userVo.getJsoupUser().getUserId());
        assetsMapper.updateByPrimaryKeySelective(assets);
        detailMapper.updateByPrimaryKeySelective(detail);
        return MyResponse.myResponseOk("更新成功");
    }

    @Override
    public UserVo tokenCheck(JsoupUser user) {
        JsoupUserExample example = new JsoupUserExample();
        example.createCriteria().andUserTokenEqualTo(user.getUserToken());
        List<JsoupUser> users = jsoupUserMapper.selectByExample(example);
        if (users == null || users.size()<1) {
            return new UserVo();
        }else {
            UserVo userVo = new UserVo();
            userVo.setJsoupUser(users.get(0));
            return userVo;
        }
    }

    /**
     * 激活用户
     *
     * @param token token值
     * @return
     */
    @Override
    public Map awakeUser(String token) {
        JsoupUserExample example = new JsoupUserExample();
        example.createCriteria().andUserTokenEqualTo(token);
        List<JsoupUser> users = jsoupUserMapper.selectByExample(example);
        if (users.size()<1){
            return MyResponse.myResponseError("无此账号");
        }else {
            JsoupUser user = users.get(0);
            user.setUserToken("");
            user.setUserType("1002");
            jsoupUserMapper.updateByPrimaryKey(user);
            return MyResponse.myResponseOk("激活成功！");
        }
    }
}
