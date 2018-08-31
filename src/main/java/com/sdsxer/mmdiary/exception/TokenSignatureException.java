package com.sdsxer.mmdiary.exception;

import org.springframework.security.authentication.BadCredentialsException;

public class TokenSignatureException extends BadCredentialsException {

    public TokenSignatureException(String msg) {
        super(msg);
    }
}
