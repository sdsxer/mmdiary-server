package com.sdsxer.mmdiary.token;

import com.sdsxer.mmdiary.common.SystemProperties;
import com.sdsxer.mmdiary.exception.*;
import io.jsonwebtoken.*;
import org.springframework.util.StringUtils;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

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
    public String generateToken(String username) {
        Claims claims = Jwts.claims();
        claims.setId(username);
        JwtBuilder builder = Jwts.builder();
        builder.setClaims(claims);
        builder.setExpiration(new Date(System.currentTimeMillis() + systemProperties.getTokenExpireTime() * 1000));
        builder.signWith(SignatureAlgorithm.HS256, signingKey);
        return builder.compact();
    }

    @Override
    public String parseToken(String token) {
        if(StringUtils.isEmpty(token)) {
            throw new TokenParseException(token);
        }
        Claims claims;
        try{
            claims = Jwts.parser()
                    .setSigningKey(signingKey)
                    .parseClaimsJws(token)
                    .getBody();
        }
        catch (ExpiredJwtException e) {
            throw new TokenExpiredException(token);
        }
        catch (SignatureException e) {
            throw new TokenSignatureException(token);
        }
        catch (MalformedJwtException e) {
            throw new MalformedTokenException(token);
        }
        catch (Exception e) {
            throw new InvalidTokenException(token);
        }
        return claims.getId();
    }
}
