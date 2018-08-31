package com.sdsxer.mmdiary.exception;

import org.springframework.security.authentication.BadCredentialsException;

public class MalformedUsernameException extends BadCredentialsException {

    public MalformedUsernameException(String message) {
        super(message);
    }
}
