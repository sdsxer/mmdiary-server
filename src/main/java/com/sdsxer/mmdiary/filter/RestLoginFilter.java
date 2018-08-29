package com.sdsxer.mmdiary.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sdsxer.mmdiary.exception.InvalidLoginInfoException;
import com.sdsxer.mmdiary.exception.PasswordFormatException;
import com.sdsxer.mmdiary.exception.UsernameFormatException;
import com.sdsxer.mmdiary.request.LoginRequest;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

public class RestLoginFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request
            , HttpServletResponse response) throws AuthenticationException {
        if(!StringUtils.isEmpty(request.getContentType())
                && (request.getContentType().equalsIgnoreCase(MediaType.APPLICATION_JSON_VALUE)
                || request.getContentType().equalsIgnoreCase(MediaType.APPLICATION_JSON_UTF8_VALUE))) {
            ObjectMapper mapper = new ObjectMapper();
            UsernamePasswordAuthenticationToken loginAuthToken;
            try (InputStream inputStream = request.getInputStream()) {
                LoginRequest loginRequest = mapper.readValue(inputStream, LoginRequest.class);
                loginRequest.checkLegality();
                loginAuthToken = new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(), loginRequest.getPassword());
                setDetails(request, loginAuthToken);
            }
            catch (UsernameFormatException | PasswordFormatException e) {
                throw e;
            }
            catch (Exception e) {
                throw new InvalidLoginInfoException();
            }
            return getAuthenticationManager().authenticate(loginAuthToken);
        }
        else {
            throw new InvalidLoginInfoException();
        }
    }
}
