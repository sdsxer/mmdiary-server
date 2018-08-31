package com.sdsxer.mmdiary.exception;

import org.springframework.security.authentication.BadCredentialsException;

public class InvalidLoginInfoException extends BadCredentialsException {

    public InvalidLoginInfoException(String msg) {
        super(msg);
    }
}