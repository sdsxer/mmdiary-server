package com.sdsxer.mmdiary.exception;

import org.springframework.security.authentication.BadCredentialsException;

public class TokenExpiredException extends BadCredentialsException {

    public TokenExpiredException(String msg) {
        super(msg);
    }
}