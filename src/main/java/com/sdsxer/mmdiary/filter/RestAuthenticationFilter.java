package com.sdsxer.mmdiary.filter;

import com.sdsxer.mmdiary.exception.AuthenticationExceptioin;
import com.sdsxer.mmdiary.security.RestAuthenticationToken;
import com.sdsxer.mmdiary.utils.JwtUtils;
import io.jsonwebtoken.ClaimJwtException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RestAuthenticationFilter extends BasicAuthenticationFilter {

    public RestAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response
            , FilterChain chain) throws IOException, ServletException {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        if(StringUtils.isEmpty(token)) {
            throw new AuthenticationCredentialsNotFoundException(null);
        }

        RestAuthenticationToken authToken;
        try{
            long userId = JwtUtils.parseUserIdFromJwtToken(token);
            authToken = new RestAuthenticationToken(userId);
        }
        catch (Exception e) {
            if(e instanceof ClaimJwtException) {
                throw (ClaimJwtException) e;
            }
            else {
                throw new AuthenticationExceptioin();
            }
        }

        if(authToken != null) {
            SecurityContextHolder.getContext().setAuthentication(authToken);
            chain.doFilter(request, response);
        }
        else {
            throw new AuthenticationExceptioin();
        }
    }
}
