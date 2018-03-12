package com.zhuguang.jack.filter;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class ErrorFilter extends ZuulFilter {
    
    Logger log = LoggerFactory.getLogger(getClass());
    
    public boolean shouldFilter() {
        // TODO Auto-generated method stub
        return true;
    }
    
    public Object run() {
        RequestContext currentContext = RequestContext.getCurrentContext();
        Throwable throwable = currentContext.getThrowable();
        log.info("ErrorFilter : " + throwable.getCause().getMessage());
        currentContext.set("error.status_code",
                HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        currentContext.set("error.exception", throwable.getCause());
        return "error happen";
    }
    
    @Override
    public String filterType() {
        // TODO Auto-generated method stub
        return "error";
    }
    
    @Override
    public int filterOrder() {
        // TODO Auto-generated method stub
        return 19;
    }
    
}
