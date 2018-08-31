package com.sdsxer.mmdiary.security;

import com.sdsxer.mmdiary.common.SystemError;
import com.sdsxer.mmdiary.exception.InvalidLoginInfoException;
import com.sdsxer.mmdiary.exception.LoginInfoNotFoundException;
import com.sdsxer.mmdiary.exception.MalformedPasswordException;
import com.sdsxer.mmdiary.exception.MalformedUsernameException;
import com.sdsxer.mmdiary.utils.ResponseUtils;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RestLoginFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
              AuthenticationException exception) {
        if (exception instanceof MalformedUsernameException) {
            ResponseUtils.responseError(response, SystemError.MalformedUsername);
        }
        else if (exception instanceof MalformedPasswordException) {
            ResponseUtils.responseError(response, SystemError.MalformedPassword);
        }
        else if (exception instanceof LoginInfoNotFoundException) {
            ResponseUtils.responseError(response, SystemError.LoginInfoNotFound);
        }
        else if (exception instanceof InvalidLoginInfoException) {
            ResponseUtils.responseError(response, SystemError.InvalidLoginInfo);
        }
        else if (exception instanceof UsernameNotFoundException) {
            ResponseUtils.responseError(response, SystemError.UserNotExist);
        }
        else if (exception instanceof LockedException) {
            ResponseUtils.responseError(response, SystemError.AccountLocked);
        }
        else if (exception instanceof DisabledException) {
            ResponseUtils.responseError(response, SystemError.AccountDisabled);
        }
        else if (exception instanceof BadCredentialsException) {
            ResponseUtils.responseError(response, SystemError.PasswordError);
        }
    }
}
