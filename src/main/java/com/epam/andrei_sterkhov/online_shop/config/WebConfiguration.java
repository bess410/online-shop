package com.epam.andrei_sterkhov.online_shop.config;

import com.epam.andrei_sterkhov.online_shop.interceptor.AdminInterceptor;
import com.epam.andrei_sterkhov.online_shop.interceptor.AuthInterceptor;
import com.epam.andrei_sterkhov.online_shop.interceptor.ClientInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    /*@Bean
    public AuthInterceptor getAuthInterceptor() {
        return new AuthInterceptor();
    }

    @Bean
    public AdminInterceptor getAdminInterceptor() {
        return new AdminInterceptor();
    }

    @Bean
    public ClientInterceptor getClientInterceptor() {
        return new ClientInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getAuthInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login", "/registration", "/css/**", "/js/**");
        registry.addInterceptor(getAdminInterceptor())
                .addPathPatterns("/admin", "/admin/**");
        registry.addInterceptor(getClientInterceptor())
                .addPathPatterns("/client", "/client/**");
    }*/
}