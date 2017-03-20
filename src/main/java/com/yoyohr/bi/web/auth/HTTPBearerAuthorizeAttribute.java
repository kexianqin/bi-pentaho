package com.yoyohr.bi.web.auth;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 验证是否带有token的过滤器
 * Created by Administrator on 2017/3/15.
 */

public class HTTPBearerAuthorizeAttribute implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        HttpServletResponse httpResponse=(HttpServletResponse)response;
        try {
            AuthClient authClient =new AuthClient();
            String auth=httpRequest.getHeader("Authorization");
            if ((auth != null) && (auth.length() > 7)){
                String headStr = auth.substring(0, 6).toLowerCase();
                if (headStr.compareTo("bearer") == 0){
                    auth=auth.substring(7,auth.length());
                }
            }                                                            //获取token
            boolean judgement=authClient.whetherThereIsPermission(auth);
            if(judgement==false){
                httpResponse.sendRedirect("/error/priv_error.html");
                return;
            }else{
                chain.doFilter(request,response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void destroy() {
    }
}
