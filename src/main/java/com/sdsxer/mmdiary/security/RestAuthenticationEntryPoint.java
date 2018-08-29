package com.sdsxer.mmdiary.security;

import com.sdsxer.mmdiary.common.SystemError;
import com.sdsxer.mmdiary.utils.ResponseUtils;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
              AuthenticationException authException) throws IOException, ServletException {
        ResponseUtils.createErrorResponse(response, SystemError.Unauthorized);
    }
}
