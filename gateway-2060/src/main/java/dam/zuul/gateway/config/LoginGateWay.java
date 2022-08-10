package dam.zuul.gateway.config;



import com.alibaba.fastjson.JSON;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import dam.zuul.gateway.httpservice.HttpUserService;
import dam.zuul.gateway.vo.JsoupUser;
import dam.zuul.gateway.vo.MyResponse;
import dam.zuul.gateway.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cytern
 * @date 2021-2-25
 * 网关拦截器 用于验证是否需要登录 的 请求
 */
@Component
@Slf4j
public class LoginGateWay extends ZuulFilter {
    public LoginGateWay() {

    }

    @Override
    public String filterType() {

        return FilterConstants.PRE_TYPE;
    }

    /**
     * 拦截器等级
     * @return 优先级3
     */
    @Override
    public int filterOrder() {
        return 3;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String requestURI = request.getRequestURI();
        if (request.getMethod().equals("OPTIONS")) {
            return false;
        }
        if(requestURI.contains("login" ) || requestURI.contains("everyone") || requestURI.contains("download") || requestURI.contains("system") || requestURI.contains("openData")
        ){
            return false;
        }else{
            return true;
        }
    }
       //拦截之后的做法
    @Override
    public Object run() throws ZuulException {
        log.info("进入 权限鉴定拦截  鉴定是否满足权限 ");
        Map<String,Object> map = new HashMap<>();
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String token = request.getHeader("accessToken");
        if (StringUtils.isEmpty(token)){
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(401);
            map = MyResponse.myResponseError("token为空");
            map.put("isLoginFall","1");
            currentContext.setResponseBody("access token is empty");
        }else {
            JsoupUser user = new JsoupUser();
            user.setUserToken(token);
            UserVo userVo = null;
            if (userVo == null) {
                currentContext.setSendZuulResponse(false);
                currentContext.setResponseStatusCode(401);
                map = MyResponse.myResponseError("token过期");
                map.put("isLoginFall","1");
            }else {
                String idcode = userVo.getJsoupUser().getUserType();
                if (request.getRequestURI().contains("manager") && !idcode.equals("1001")){
                    map = MyResponse.myResponseError("权限非法");
                }else {
                    currentContext.setResponseStatusCode(200);
                    currentContext.addZuulRequestHeader("userId",String.valueOf(userVo.getJsoupUser().getUserId()));
                    return  null;
                }
            }
        }
        currentContext.setResponseStatusCode(401);
        currentContext.setResponseBody(JSON.toJSONString(map));
        return null;
    }
}
