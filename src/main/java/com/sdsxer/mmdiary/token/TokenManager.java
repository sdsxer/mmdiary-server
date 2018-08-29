package com.sdsxer.mmdiary.token;

import com.sdsxer.mmdiary.domain.UserToken;
import com.sdsxer.mmdiary.exception.*;
import org.springframework.stereotype.Component;

@Component
public abstract class TokenManager {

    public abstract String generateToken(UserToken userToken);

    public abstract UserToken parseToken(String token) throws
            TokenExpiredException, TokenParseException, TokenFormatException, TokenSignatureException, InvalidTokenException;
}
