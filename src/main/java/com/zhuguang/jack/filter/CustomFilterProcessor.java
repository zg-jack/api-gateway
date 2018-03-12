package com.zhuguang.jack.filter;

import com.netflix.zuul.FilterProcessor;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class CustomFilterProcessor extends FilterProcessor {
    
    @Override
    public Object processZuulFilter(ZuulFilter filter) throws ZuulException {
        try {
            // TODO Auto-generated method stub
            return super.processZuulFilter(filter);
        }
        catch (ZuulException e) {
            RequestContext currentContext = RequestContext.getCurrentContext();
            currentContext.set("error.filter", filter);
            throw e;
        }
    }
    
}
