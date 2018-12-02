package com.sucl.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author sucl
 * @since 2018/12/2
 */
@Component
public class DefaultFilter extends ZuulFilter{

    private static final Logger logger = LoggerFactory.getLogger(DefaultFilter.class);

    /**
     * 返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型
     *  pre：路由之前
     *  routing：路由之时
     *  post： 路由之后
     *  error：发送错误调用
     * @return
     */
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器顺序
     * @return
     */
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否要过滤
     * @return
     */
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问
     * @return
     */
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        logger.info(String.format("%s >> %s",request.getMethod(),request.getRequestURI().toString()));
        String token = request.getParameter("token");
        if(token == null){
            logger.warn("token is empty");
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            try {
                context.getResponse().getWriter().write("token is empty");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }else{
            logger.info("ok");
        }
        return token;
    }
}
