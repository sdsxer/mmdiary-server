package com.sdsxer.mmdiary.config;

import com.sdsxer.mmdiary.common.SystemEnvironment;
import com.sdsxer.mmdiary.common.SystemProperties;
import com.sdsxer.mmdiary.token.JwtTokenManager;
import com.sdsxer.mmdiary.token.TokenManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class TokenConfig {

    @Profile(SystemEnvironment.DEV)
    @Bean
    public TokenManager jwtTokenManager(SystemProperties properties) {
        return new JwtTokenManager(properties);
    }

    @Profile(SystemEnvironment.PROD)
    @Bean
    public TokenManager tokenManager(SystemProperties properties) {
        return new JwtTokenManager(properties);
    }
}
