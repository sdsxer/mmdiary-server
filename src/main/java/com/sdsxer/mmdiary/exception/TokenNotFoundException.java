package com.sdsxer.mmdiary.exception;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;

public class TokenNotFoundException extends AuthenticationCredentialsNotFoundException {

    public TokenNotFoundException(String msg) {
        super(msg);
    }
}