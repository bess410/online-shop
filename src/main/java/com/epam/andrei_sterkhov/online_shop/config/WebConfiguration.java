package com.epam.andrei_sterkhov.online_shop.config;

import com.epam.andrei_sterkhov.online_shop.interceptor.AuthInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Bean
    public AuthInterceptor getAuthInterceptor() {
        return new AuthInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getAuthInterceptor())
                .addPathPatterns("/index")
                .addPathPatterns("/**")
                .excludePathPatterns("/login", "/registration", "/css/**", "/js/**");
    }
}