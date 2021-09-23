package com.example.assetmanage.config;

import com.example.assetmanage.intercepter.WebIntercepter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    private WebIntercepter webIntercepter;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(webIntercepter)
                .addPathPatterns("/**").excludePathPatterns("/login/**");

    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 跨域路由
        registry.addMapping("/**")
                // 跨域域名
                .allowedOriginPatterns("*")
                // 允许cookie
                .allowCredentials(true)
                // 允许方法
                .allowedMethods("*")
                .maxAge(3600);

    }

    @Autowired
    public void setWebIntercepter(WebIntercepter webIntercepter) {
        this.webIntercepter = webIntercepter;
    }
}
