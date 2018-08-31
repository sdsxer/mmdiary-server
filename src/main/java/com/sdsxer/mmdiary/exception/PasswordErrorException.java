package com.sdsxer.mmdiary.exception;

import org.springframework.security.authentication.BadCredentialsException;

public class PasswordErrorException extends BadCredentialsException {

    public PasswordErrorException(String message) {
        super(message);
    }
}
