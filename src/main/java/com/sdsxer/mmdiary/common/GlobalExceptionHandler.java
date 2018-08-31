package com.sdsxer.mmdiary.common;

import com.sdsxer.mmdiary.exception.*;
import com.sdsxer.mmdiary.response.RestResponse;
import com.sdsxer.mmdiary.utils.ExceptionUtils;
import com.sdsxer.mmdiary.utils.ResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.NoHandlerFoundException;
import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger("GlobalExceptionHandler");

    @ExceptionHandler({AuthenticationException.class})
    public RestResponse handleAuthenticationException(HttpServletRequest request, Exception e) {
        if(e instanceof UsernameNotFoundException) {
            return ResponseUtils.createErrorResponse(SystemError.UserNotExist);
        }
        else if(e instanceof LoginInfoNotFoundException) {
            return ResponseUtils.createErrorResponse(SystemError.LoginInfoNotFound);
        }
        else if(e instanceof InvalidLoginInfoException) {
            return ResponseUtils.createErrorResponse(SystemError.InvalidLoginInfo);
        }
        else if(e instanceof MalformedUsernameException) {
            return ResponseUtils.createErrorResponse(SystemError.MalformedUsername);
        }
        else if(e instanceof MalformedPasswordException) {
            return ResponseUtils.createErrorResponse(SystemError.MalformedPassword);
        }
        else if(e instanceof TokenExpiredException) {
            return ResponseUtils.createErrorResponse(SystemError.TokenExpired);
        }
        else if(e instanceof TokenParseException) {
            return ResponseUtils.createErrorResponse(SystemError.InvalidToken);
        }
        else if(e instanceof MalformedTokenException) {
            return ResponseUtils.createErrorResponse(SystemError.MalformedToken);
        }
        else if(e instanceof TokenSignatureException) {
            return ResponseUtils.createErrorResponse(SystemError.InvalidToken);
        }
        else if(e instanceof InvalidTokenException) {
            return ResponseUtils.createErrorResponse(SystemError.InvalidToken);
        }
        else {
            return ResponseUtils.createErrorResponse(SystemError.UnknownError);
        }
    }


    // 404
    @ExceptionHandler(value = NoHandlerFoundException.class)
    @ResponseBody
    public RestResponse noHandlerFoundErrorHandler(HttpServletRequest request, Exception e) {
        return ResponseUtils.createErrorResponse(SystemError.NotFound, request.getServletPath());
    }

    // 500
    @ExceptionHandler(value = BaseException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public RestResponse baseErrorHandler(HttpServletRequest request, Exception e) {
        logger.error("BaseExceptionHandler: Host {} invokes url {} ERROR: {}",
                request.getRemoteHost(), request.getRequestURL(), ExceptionUtils.printStackTraceToString(e));
        return ResponseUtils.createErrorResponse(SystemError.UnknownError, ExceptionUtils.printStackTraceToString(e));
    }

    // 500
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public RestResponse defaultErrorHandler(HttpServletRequest request, Exception e) {
        logger.error("DefaultExceptionHandler: Host {} invokes url {} ERROR: {}",
                request.getRemoteHost(), request.getRequestURL(), ExceptionUtils.printStackTraceToString(e));
        return ResponseUtils.createErrorResponse(SystemError.UnknownError, ExceptionUtils.printStackTraceToString(e));
    }
}
