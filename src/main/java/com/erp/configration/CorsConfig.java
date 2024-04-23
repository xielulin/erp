package com.erp.configration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author xielulin
 * @create 2024-04-18 21:51
 * @desc
 **/

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 允许所有路由
                .allowedHeaders(CorsConfiguration.ALL) // 允许所有请求头
                .allowedMethods(CorsConfiguration.ALL) // 允许所有请求方法
                .allowCredentials(true) // 允许前端带上凭证（例如 cookie）
                .allowedOrigins(CorsConfiguration.ALL)
                .maxAge(3600); // 1小时内不需要再预检（发 OPTIONS 请求）
    }
}

