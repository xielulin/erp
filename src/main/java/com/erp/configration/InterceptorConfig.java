package com.erp.configration;


import com.erp.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.filter.FormContentFilter;
import org.springframework.web.servlet.config.annotation.*;

import java.util.concurrent.TimeUnit;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
        .excludePathPatterns("/swagger-resources/**","swagger-ui.html", "/webjars/**", "/v2/**", "/swagger-ui.html/**",
                "/user/login");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        //����ӳ��
        //no-cache �����ڱ��ػ��棬�����ڴ�����������棬�����������Ҫ��������֤�ſ���ʹ��(ÿ�ζ��������������У��)
        //no-store ���׵ý��û��壬���غʹ���������������壬ÿ�ζ��ӷ�������ȡ
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/")
                .setCacheControl(CacheControl.maxAge(0, TimeUnit.SECONDS).cachePublic());
        registry.addResourceHandler("/static/img/**").addResourceLocations("file:src/main/resources/static/img/")
                .setCacheControl(CacheControl.maxAge(0, TimeUnit.SECONDS).cachePublic());
        registry.addResourceHandler("/img/**").addResourceLocations("file:src/main/resources/static/img/")
                .setCacheControl(CacheControl.maxAge(0, TimeUnit.SECONDS).cachePublic());
        registry.addResourceHandler("/pdf/**").addResourceLocations("file:/data/python/qbzz_doc/insurance_term/")
                .setCacheControl(CacheControl.maxAge(0, TimeUnit.SECONDS).cachePublic());
    }

    //put delete��������Ա�����ʽ�����ύ
    @Bean
    public FormContentFilter getFormContentFilter() {
        return new FormContentFilter();
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE").allowedOrigins("*")
                .allowedHeaders("*").maxAge(36000).allowCredentials(true);
    }

    //����url·������ ., ʹ��Spring�����˺�׺ƥ��. �ص���׺ƥ��
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false);
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseTrailingSlashMatch(true);
    }

}
