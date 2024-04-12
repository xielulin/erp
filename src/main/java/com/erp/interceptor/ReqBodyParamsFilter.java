package com.erp.interceptor;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @description: TODO
 * @author: Lin
 * @date:2021/11/11 10:50
 **/
public class ReqBodyParamsFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
    }
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        ReqBodyParamsRequestWrapper requestWrapper = null;
        if(request instanceof HttpServletRequest) {
            requestWrapper = new ReqBodyParamsRequestWrapper((HttpServletRequest) request);
        }
        if(requestWrapper == null) {
            chain.doFilter(request, response);
        } else {
            chain.doFilter(requestWrapper, response);
        }
    }
    public void destroy() {
    }
}