package com.sdsxer.mmdiary.security;

import com.sdsxer.mmdiary.common.SystemError;
import com.sdsxer.mmdiary.utils.ResponseUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RestAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
              AccessDeniedException accessDeniedException) throws IOException, ServletException {
        ResponseUtils.responseError(response, SystemError.Unauthorized);
    }
}
