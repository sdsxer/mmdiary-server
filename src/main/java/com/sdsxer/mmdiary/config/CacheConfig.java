package com.sdsxer.mmdiary.config;

import com.sdsxer.mmdiary.common.SystemEnvironment;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@EnableCaching
public class CacheConfig {

    @Profile(SystemEnvironment.DEV)
    @Bean
    public CacheManager ehCacheManager() {
        return new EhCacheCacheManager();
    }
//
//    @Profile(SystemEnvironment.PROD)
//    @Bean
//    public CacheManager redisCacheManager() {
//        return new RedisCacheManager(null, null);
//    }
}
