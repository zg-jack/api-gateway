package com.zhuguang.jack.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class SecurityFilter extends ZuulFilter {
    
    Logger log = LoggerFactory.getLogger(getClass());
    
    public Object run() {
        log.info("================SecurityFilter.run=================");
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        try {
            if ("jack".equals(username) && "123".equals(password)) {
                //            currentContext.setSendZuulResponse(true);
                //                throw new RuntimeException("has error");
            }
            else {
                currentContext.setSendZuulResponse(false);
                currentContext.setResponseStatusCode(401);
                currentContext.setResponseBody("无权访问！");
            }
        }
        catch (RuntimeException e) {
            //            currentContext.set("error.status_code",
            //                    HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            //            currentContext.set("error.exception", e);
            throw e;
        }
        return null;
    }
    
    /** 
     *  往期视频加瑶瑶老师QQ：2483034688
     *  Jack老师QQ： 2943489129
     *  时间   ：     2018年2月9日 下午7:01:57 
     *  作者   ：   烛光学院【Jack老师】
     *  
     *  判断过滤器是否被执行
     */
    public boolean shouldFilter() {
        // TODO Auto-generated method stub
        return true;
    }
    
    /** 
     *  往期视频加瑶瑶老师QQ：2483034688
     *  Jack老师QQ： 2943489129
     *  时间   ：     2018年2月9日 下午7:01:45 
     *  作者   ：   烛光学院【Jack老师】
     *  
     *  过滤器的执行顺序
     */
    @Override
    public int filterOrder() {
        // TODO Auto-generated method stub
        return 0;
    }
    
    /** 
     *  往期视频加瑶瑶老师QQ：2483034688
     *  Jack老师QQ： 2943489129
     *  时间   ：     2018年2月9日 下午7:00:41 
     *  作者   ：   烛光学院【Jack老师】
     *  
     *  过滤器类型，它决定过滤器在请求的那个生命周期执行，pre代表请求被路由之前执行
     */
    @Override
    public String filterType() {
        return "pre";
    }
    
}
