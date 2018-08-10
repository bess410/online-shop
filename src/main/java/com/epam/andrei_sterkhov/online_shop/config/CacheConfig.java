package com.epam.andrei_sterkhov.online_shop.config;

import com.google.common.cache.CacheBuilder;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class CacheConfig {

    public static final  String CACHE_ONE = "cacheOne";
    public static final  String CACHE_TWO = "cacheTwo";

    @Bean
    public Cache cacheOne() {
        return new GuavaCache(CACHE_ONE, CacheBuilder.newBuilder()
                .expireAfterWrite(60, TimeUnit.MINUTES)
                .build());
    }

    @Bean
    public Cache cacheTwo() {
        return new GuavaCache(CACHE_TWO, CacheBuilder.newBuilder()
                .expireAfterWrite(40, TimeUnit.SECONDS)
                .build());
    }
}