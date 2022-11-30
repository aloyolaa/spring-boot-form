package com.aloyolaa.springbootform.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {

    private final HandlerInterceptor elapsedTimeInterceptor;

    public AppConfig(@Qualifier("elapsedTimeInterceptor") HandlerInterceptor elapsedTimeInterceptor) {
        this.elapsedTimeInterceptor = elapsedTimeInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(elapsedTimeInterceptor).addPathPatterns("/form/**");
    }

}
