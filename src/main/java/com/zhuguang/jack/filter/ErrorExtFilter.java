package com.zhuguang.jack.filter;

import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/** 
 *  往期视频加瑶瑶老师QQ：2483034688
 *  Jack老师QQ： 2943489129
 *  时间   ：     2018年2月23日 下午2:19:47 
 *  作者   ：   烛光学院【Jack老师】
 *  
 *  该过滤器只对post过滤器产生的异常起作用,pre,route过滤器都不起作用
 */
@Component
public class ErrorExtFilter extends SendErrorFilter {
    
    public boolean shouldFilter() {
        // TODO Auto-generated method stub
        RequestContext currentContext = RequestContext.getCurrentContext();
        ZuulFilter filter = (ZuulFilter)currentContext.get("error.filter");
        
        if (filter != null && !"".equals(filter)
                && "post".equals(filter.filterType())) {
            return true;
        }
        return false;
    }
    
    @Override
    public String filterType() {
        // TODO Auto-generated method stub
        return "error";
    }
    
    @Override
    public int filterOrder() {
        // TODO Auto-generated method stub
        return 20;
    }
    
}
