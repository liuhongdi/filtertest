package com.filtertest.demo.filter;

import com.filtertest.demo.util.ServletUtil;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//@Component
//@Order(1)
//@WebFilter(urlPatterns = {"/home/*","/config/*"}, filterName = "securityRequestFilter")
public class TimeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("----------------time filter init");
    }
   //过滤功能,我们统计请求所花费的时间
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("----------------time filter doFilter begin");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String path = request.getRequestURI();
        String v = request.getParameter("v");
        System.out.println("filter: v: "+v);
        if (v == null || v.equals("")) {
            ServletUtil.printString("缺少参数");
            return;
        }
        String method = request.getMethod();
        System.out.println("filter: method: "+method);
        //if ()
        long startTime = System.currentTimeMillis();
        filterChain.doFilter(servletRequest,servletResponse);
        long endTime = System.currentTimeMillis();
        System.out.println("timefilter: "+path + " costtime: "+ (endTime-startTime) +"ms ");
        System.out.println("----------------time filter doFilter end");
    }

    @Override
    public void destroy() {
        System.out.println("----------------time filter destroy");
    }

}
