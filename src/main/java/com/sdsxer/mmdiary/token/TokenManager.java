package com.sdsxer.mmdiary.token;

import com.sdsxer.mmdiary.exception.*;

public abstract class TokenManager {

    public abstract String generateToken(String username);

    public abstract String parseToken(String token) throws
            TokenExpiredException, TokenParseException, MalformedTokenException, TokenSignatureException, InvalidTokenException;
}
