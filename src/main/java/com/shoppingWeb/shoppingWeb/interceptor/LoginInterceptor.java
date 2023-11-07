package com.shoppingWeb.shoppingWeb.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class  LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        // check if user login or not
        if (request.getSession().getAttribute("uid") == null) {
            System.out.println("there's no session ");
            response.setStatus(302);
            return false;
        }

        return true;
    }
}