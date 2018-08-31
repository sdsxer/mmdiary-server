package com.sdsxer.mmdiary.exception;

import org.springframework.security.authentication.BadCredentialsException;

public class MalformedPasswordException extends BadCredentialsException {

    public MalformedPasswordException(String message) {
        super(message);
    }
}