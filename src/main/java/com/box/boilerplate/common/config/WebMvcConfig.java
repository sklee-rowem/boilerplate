package com.box.boilerplate.common.config;

import com.box.boilerplate.member.interceptor.MemberInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {

//        registry.addInterceptor(new MemberInterceptor())
//                .addPathPatterns()
//                .excludePathPatterns("/member/**");

    }



}
