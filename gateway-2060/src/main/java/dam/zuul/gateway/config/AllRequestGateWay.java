package dam.zuul.gateway.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 拦截所有真正请求的做法 添加同样头部
 */
@Component
@Slf4j
public class AllRequestGateWay extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 2;
    }

    @Override
    public boolean shouldFilter() {
        //这里拦截所有请求 everyone  root customer
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String requestURI = request.getRequestURI();
        if (requestURI.contains("everyone") || requestURI.contains("root") || requestURI.contains("customer")) {
            return !request.getMethod().equals("OPTIONS");
        }
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        log.info("*****************总请求校验开始*****************");
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletResponse response = ctx.getResponse();
        HttpServletRequest request = ctx.getRequest();
        response.addHeader("Access-Control-Allow-Origin","http://localhost");
        response.addHeader("Access-Control-Allow-Credentials","true");
        response.addHeader("Access-Control-Allow-Headers","authorization, content-type, accessToken");
        response.addHeader("Access-Control-Allow-Methods","GET, POST,PUT, DELETE");
        //允许继续路由
        ctx.setSendZuulResponse(true);
        ctx.setResponseStatusCode(200);
        log.info("*****************总校验请求结束*****************,入参参数=[{}]",request);
        return null;
    }
}
