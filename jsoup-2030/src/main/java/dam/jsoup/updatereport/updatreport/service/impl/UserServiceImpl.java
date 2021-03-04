package dam.jsoup.updatereport.updatreport.service.impl;

import dam.jsoup.updatereport.updatreport.dao.JsoupUserAssetsMapper;
import dam.jsoup.updatereport.updatreport.dao.JsoupUserDetailMapper;
import dam.jsoup.updatereport.updatreport.dao.JsoupUserMapper;
import dam.jsoup.updatereport.updatreport.dataservice.UserDataService;
import dam.jsoup.updatereport.updatreport.pojo.JsoupUser;
import dam.jsoup.updatereport.updatreport.pojo.JsoupUserAssets;
import dam.jsoup.updatereport.updatreport.pojo.JsoupUserDetail;
import dam.jsoup.updatereport.updatreport.pojo.JsoupUserExample;
import dam.jsoup.updatereport.updatreport.service.UserService;
import dam.jsoup.updatereport.updatreport.util.AesUtil;
import dam.jsoup.updatereport.updatreport.util.MyResponse;
import dam.jsoup.updatereport.updatreport.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public UserServiceImpl(UserDataService userDataService, JsoupUserMapper jsoupUserMapper, JsoupUserDetailMapper detailMapper, JsoupUserAssetsMapper assetsMapper) {
        this.userDataService = userDataService;
        this.jsoupUserMapper = jsoupUserMapper;
        this.detailMapper = detailMapper;
        this.assetsMapper = assetsMapper;
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
        password = AesUtil.enAes(password);
        user.setPassword(password);
        Map map = new HashMap();
        JsoupUserExample example = new JsoupUserExample();
        example.createCriteria().andUsernameEqualTo(user.getUsername());
        List<JsoupUser> list = jsoupUserMapper.selectByExample(example);
        if (list.size()>0) {
            return MyResponse.myResponseError("注册失败,用户名重复");
        }
        try {
            jsoupUserMapper.insert(user);
        } catch (Exception e) {
            log.error("注册用户失败",e);
            map = MyResponse.myResponseError("注册失败，系统内部异常");
        }
        userVo.setJsoupUser(user);
        map = MyResponse.myResponseOk("注册成功");
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
}
