package com.sdsxer.mmdiary.token;

import com.sdsxer.mmdiary.common.SystemProperties;
import com.sdsxer.mmdiary.domain.UserToken;
import com.sdsxer.mmdiary.exception.*;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenManager extends TokenManager {

    private final SystemProperties systemProperties;
    private final Key signingKey;

    public JwtTokenManager(SystemProperties systemProperties) {
        this.systemProperties = systemProperties;
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(systemProperties.getTokenSecretKey());
        signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
    }

    @Override
    public String generateToken(UserToken userToken) {
        Claims claims = Jwts.claims();
        claims.put(UserToken.KEY_USER_ID, userToken.getUserId());
        claims.put(UserToken.KEY_USERNAME, userToken.getUsername());
        claims.put(UserToken.KEY_ROLE_ID, userToken.getRoleId());
        JwtBuilder builder = Jwts.builder();
        builder.setClaims(claims);
        builder.setExpiration(new Date(System.currentTimeMillis() + systemProperties.getTokenExpireTime() * 1000));
        builder.signWith(SignatureAlgorithm.HS256, signingKey);
        return builder.compact();
    }

    @Override
    public UserToken parseToken(String token) {
        if(StringUtils.isEmpty(token)) {
            throw new TokenParseException();
        }
        Claims claims;
        try{
            claims = Jwts.parser()
                    .setSigningKey(signingKey)
                    .parseClaimsJws(token)
                    .getBody();
        }
        catch (ExpiredJwtException e) {
            throw new TokenExpiredException();
        }
        catch (SignatureException e) {
            throw new TokenSignatureException();
        }
        catch (MalformedJwtException e) {
            throw new TokenFormatException();
        }
        catch (Exception e) {
            throw new InvalidTokenException();
        }
        UserToken userToken = new UserToken();
        userToken.setUserId((Long) claims.get(UserToken.KEY_USER_ID));
        userToken.setUsername((String) claims.get(UserToken.KEY_USERNAME));
        return userToken;
    }
}
