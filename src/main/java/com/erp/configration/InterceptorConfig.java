package com.qbzz.bot.configure;

import com.qbzz.bot.intercepors.H5Interceptor;
import com.qbzz.bot.intercepors.LoginInterceptor;
import com.qbzz.bot.intercepors.ReqBodyParamsFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.filter.FormContentFilter;
import org.springframework.web.servlet.config.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    LoginInterceptor loginInterceptor;
    @Resource
    H5Interceptor h5Interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).addPathPatterns("/api/1.0/**").addPathPatterns("/api/open/1.0/foreign/**")
        .excludePathPatterns("/swagger-resources/**","swagger-ui.html", "/webjars/**", "/v2/**", "/swagger-ui.html/**","/api/open/1.0/foreign/getToken");
//        registry.addInterceptor(h5Interceptor).addPathPatterns("/api/open/1.0/html/**");
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
    /**
     * 处理请求参数为json字符串的过滤器
     * @return
     */
   /* @Bean
    public FilterRegistrationBean<ReqBodyParamsFilter> someFilterRegistration() {
        FilterRegistrationBean<ReqBodyParamsFilter> registration = new FilterRegistrationBean<ReqBodyParamsFilter>();
        registration.setFilter(reqBodyParamsFilter());
        registration.addUrlPatterns("/api/open/1.0/html/*");
        registration.setName("reqBodyParamsFilter");
        return registration;
    }
    *//**
     * request json body 过滤器
     * @return
     *//*
    @Bean(name = "reqBodyParamsFilter")
    public ReqBodyParamsFilter reqBodyParamsFilter() {
        return new ReqBodyParamsFilter();
    }*/
}
