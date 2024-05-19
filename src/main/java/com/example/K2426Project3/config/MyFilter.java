package com.example.K2426Project3.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        String path = servletRequest.getServletPath();
        if (!path.equals("/login") && !path.equals("/register")){
            HttpSession session = servletRequest.getSession();
            String name = (String) session.getAttribute("name");
            if (session == null || name == null){
                servletResponse.sendRedirect("/login");
            }
        }
        chain.doFilter(servletRequest,servletResponse);
    }
}
