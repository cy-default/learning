package com.rm13.web.filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/3/16
 */
public class HelloFilter implements Filter {

    public HelloFilter() {
        System.out.println("HelloFilter..");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("HelloFilter.init.."+filterConfig.getFilterName());
        final Enumeration<String> names = filterConfig.getInitParameterNames();
        while(names.hasMoreElements()){
            System.out.println("HelloFilter.init.."+names.nextElement());
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("HelloFilter.doFilter..");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        System.out.println("HelloFilter.destroy..");
    }
}
