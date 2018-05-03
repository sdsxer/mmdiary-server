package com.sdsxer.mmdiary.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtils {

    private static final String SECRET_KEY = "mmdiary";
    private static final int EXPIRE_MILLIS = 7 * 24 * 60 * 60 * 1000; // a week
    private static final Key HS256_SIGNING_KEY = generateSignKey(SECRET_KEY);

    public static Claims parseJwtToken(String token) throws Exception {
        return Jwts.parser()
                .setSigningKey(HS256_SIGNING_KEY)
                .parseClaimsJws(token)
                .getBody();
    }

    public static long parseUserIdFromJwtToken(String token) throws Exception {
        Claims claims = Jwts.parser()
                .setSigningKey(HS256_SIGNING_KEY)
                .parseClaimsJws(token)
                .getBody();
        return Long.parseLong(claims.getSubject());
    }

    public static String generateJwtToken(long userId) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(Claims.SUBJECT, userId);
        return generateJwtToken(claims);
    }

    public static String generateJwtToken(Map<String, Object> claims) {
        JwtBuilder builder = Jwts.builder();
        builder.setClaims(claims);
        builder.signWith(SignatureAlgorithm.HS256, HS256_SIGNING_KEY);
        builder.setExpiration(new Date(System.currentTimeMillis() + EXPIRE_MILLIS));
        return builder.compact();
    }

    private static Key generateSignKey(String secret) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secret);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
        return signingKey;
    }
}
