package com.sdsxer.mmdiary.exception;

import org.springframework.security.authentication.BadCredentialsException;

public class TokenParseException extends BadCredentialsException {

    public TokenParseException(String msg) {
        super(msg);
    }
}
