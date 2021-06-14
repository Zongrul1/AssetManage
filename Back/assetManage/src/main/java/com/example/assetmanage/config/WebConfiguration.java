package com.example.assetmanage.config;

import com.example.assetmanage.intercepter.WebIntercepter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    private WebIntercepter webIntercepter;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(webIntercepter)
                .addPathPatterns("/**");


    }

    @Autowired
    public void setWebIntercepter(WebIntercepter webIntercepter) {
        this.webIntercepter = webIntercepter;
    }
}
