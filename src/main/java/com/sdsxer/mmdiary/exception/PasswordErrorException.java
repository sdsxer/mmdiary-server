package com.sdsxer.mmdiary.exception;

public class PasswordErrorException extends AuthenticationException {

    public PasswordErrorException(String message) {
        super(message);
    }
}
