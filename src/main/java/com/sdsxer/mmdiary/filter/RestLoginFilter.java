package com.sdsxer.mmdiary.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sdsxer.mmdiary.request.LoginRequest;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

public class RestLoginFilter extends UsernamePasswordAuthenticationFilter {

    public RestLoginFilter() {
        super();
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        if(request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE)) {
            ObjectMapper mapper = new ObjectMapper();
            UsernamePasswordAuthenticationToken authRequest = null;
            AuthenticationException exception = null;
            try (InputStream inputStream = request.getInputStream()) {
                LoginRequest loginRequest = mapper.readValue(inputStream, LoginRequest.class);
                authRequest = new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(), loginRequest.getPassword());
                setDetails(request, authRequest);
            } catch (Exception e) {
                exception = new AuthenticationCredentialsNotFoundException(null);
            } finally {
                if(exception != null) {
                    throw exception;
                } else {
                    return getAuthenticationManager().authenticate(authRequest);
                }
            }
        }
        else {
            throw new AuthenticationCredentialsNotFoundException(null);
        }
    }
}
