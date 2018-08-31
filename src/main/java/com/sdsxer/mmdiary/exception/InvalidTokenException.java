package com.sdsxer.mmdiary.exception;

import org.springframework.security.authentication.BadCredentialsException;

public class InvalidTokenException extends BadCredentialsException {

    public InvalidTokenException(String msg) {
        super(msg);
    }
}