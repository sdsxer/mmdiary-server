package com.sdsxer.mmdiary.exception;

public class TokenParseException extends AuthenticationException {

    public TokenParseException() {
        super();
    }

    public TokenParseException(String message) {
        super(message);
    }

    public TokenParseException(String message, Throwable cause) {
        super(message, cause);
    }

    public TokenParseException(Throwable cause) {
        super(cause);
    }
}
