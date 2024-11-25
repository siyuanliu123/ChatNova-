package com.fitnova.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 匹配所有接口
                .allowedOrigins("http://localhost:3000") // 允许的来源（前端地址）
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 允许的 HTTP 方法
                .allowedHeaders("*") // 允许的请求头
                .exposedHeaders("Authorization") // 可暴露的响应头
                .allowCredentials(true) // 是否允许发送 Cookie
                .maxAge(3600); // 预检请求的缓存时间（单位：秒）
    }
}

