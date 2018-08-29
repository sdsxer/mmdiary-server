package com.sdsxer.mmdiary.exception;

public class UserNotExistException extends AuthenticationException {

    public UserNotExistException() {
        super();
    }

    public UserNotExistException(String message) {
        super(message);
    }
}