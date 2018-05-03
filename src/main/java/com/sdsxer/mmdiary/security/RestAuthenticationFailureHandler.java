package com.sdsxer.mmdiary.security;

import com.sdsxer.mmdiary.common.ErrorCode;
import com.sdsxer.mmdiary.common.RestResponse;
import com.sdsxer.mmdiary.utils.ResponseUtils;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RestAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
              AuthenticationException exception) {
        try {
            RestResponse restResponse = null;
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            if (exception instanceof UsernameNotFoundException) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                restResponse = ResponseUtils.createErrorRestResponse(ErrorCode.USER_NOT_EXIST);
            }
            else if (exception instanceof BadCredentialsException) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                restResponse = ResponseUtils.createErrorRestResponse(ErrorCode.PASSWORD_ERROR);

            }
            else if (exception instanceof AuthenticationCredentialsNotFoundException) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                restResponse = ResponseUtils.createErrorRestResponse(ErrorCode.BAD_REQUEST);
            }
            else if(exception instanceof AccountStatusException) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                restResponse = ResponseUtils.createErrorRestResponse(ErrorCode.ACCOUNT_DISABLED);
            }
            else {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                restResponse = ResponseUtils.createErrorRestResponse(ErrorCode.AUTHENTICATION_FAILED);
            }
            if(restResponse != null) {
                ResponseUtils.responseJson(response, restResponse);
            }
        } catch (Exception e) {

        }
    }
}
