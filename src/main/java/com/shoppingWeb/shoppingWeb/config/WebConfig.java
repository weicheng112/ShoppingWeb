package com.shoppingWeb.shoppingWeb.config;

import com.shoppingWeb.shoppingWeb.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {



        List<String> patterns = new ArrayList<>();
        patterns.add("/user_login");
        patterns.add("/static/**");


        // after we login in, we could view those pages
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/login_success")
                .addPathPatterns("/carts/**")
                .addPathPatterns("/users/**");
        //.excludePathPatterns(patterns);
    }
}