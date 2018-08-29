package com.sdsxer.mmdiary.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SystemProperties {

    @Value("token.secret-key")
    private String tokenSecretKey;

    @Value("${token.expire-time}")
    private long tokenExpireTime;

    public String getTokenSecretKey() {
        return tokenSecretKey;
    }

    public long getTokenExpireTime() {
        return tokenExpireTime;
    }
}
