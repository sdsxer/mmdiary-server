package com.sdsxer.mmdiary.security;

import com.sdsxer.mmdiary.common.SystemError;
import com.sdsxer.mmdiary.exception.UserNotExistException;
import com.sdsxer.mmdiary.utils.ResponseUtils;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RestLoginFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
              AuthenticationException exception) {
        if (exception instanceof UsernameNotFoundException) {
            ResponseUtils.createErrorResponse(response, SystemError.UserNotExist);
            throw new UserNotExistException();
        }
        else if (exception instanceof BadCredentialsException) {
            ResponseUtils.createErrorResponse(response, SystemError.PasswordError);
        }
        else if (exception instanceof AccountStatusException) {
            ResponseUtils.createErrorResponse(response, SystemError.AccountDisabled);
        }
        else {
            ResponseUtils.createErrorResponse(response, SystemError.LoginFailed);
        }
    }
}
