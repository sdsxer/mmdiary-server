package com.sdsxer.mmdiary.exception;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;

public class LoginInfoNotFoundException extends AuthenticationCredentialsNotFoundException {

    public LoginInfoNotFoundException(String msg) {
        super(msg);
    }
}
