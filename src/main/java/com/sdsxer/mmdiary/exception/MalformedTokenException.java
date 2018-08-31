package com.sdsxer.mmdiary.exception;

import org.springframework.security.authentication.BadCredentialsException;

public class MalformedTokenException extends BadCredentialsException {

    public MalformedTokenException(String msg) {
        super(msg);
    }
}