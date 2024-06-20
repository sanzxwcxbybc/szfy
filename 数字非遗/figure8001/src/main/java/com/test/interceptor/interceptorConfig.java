package com.test.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class interceptorConfig implements WebMvcConfigurer {
    @Resource
    private interceptortest interceptortest;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptortest)
                .addPathPatterns("/com/article/search/type*/*");
    }
}
