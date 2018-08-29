package com.sdsxer.mmdiary.common;

import com.sdsxer.mmdiary.exception.*;
import com.sdsxer.mmdiary.response.RestResponse;
import com.sdsxer.mmdiary.utils.ExceptionUtils;
import com.sdsxer.mmdiary.utils.ResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger("GlobalExceptionHandler");

    @ExceptionHandler({AuthenticationException.class})
    public RestResponse handleAccessDeniedException(HttpServletRequest request, Exception e) {
        if(e instanceof UsernameNotFoundException) {
            return ResponseUtils.createErrorResponse(SystemError.UserNotExist);
        }
        else if(e instanceof BadCredentialsException) {
            if(e.getCause() instanceof UsernameFormatException) {
                return ResponseUtils.createErrorResponse(SystemError.UsernameFormatError);
            }
            else if(e.getCause() instanceof PasswordFormatException) {
                return ResponseUtils.createErrorResponse(SystemError.PasswordFormatError);
            }
            else if(e.getCause() instanceof InvalidLoginInfoException) {
                return ResponseUtils.createErrorResponse(SystemError.InvalidLoginInfo);
            }
            else if(e.getCause() instanceof InvalidTokenException) {
                return ResponseUtils.createErrorResponse(SystemError.InvalidToken);
            }
        }
        else if(e instanceof AuthenticationCredentialsNotFoundException) {
            return ResponseUtils.createErrorResponse(SystemError.TokenNotFound);
        }
        else {

        }
        return null;
    }

//    @ExceptionHandler(value = {
//            BadCredentialsException.class,
//            MethodArgumentNotValidException.class,
//            BadRequestException.class})
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ResponseBody
//    public RestResponse badRequestErrorHandler(HttpServletRequest request, Exception e) {
//        logger.error("{} Handler: Host {} invokes url {} ERROR: {}", e.getClass().getSimpleName(),
//                request.getRemoteHost(), request.getRequestURL(), e.getMessage());
//        RestResponse response = ResponseUtils.createErrorRestResponse(ErrorCode.BAD_REQUEST);
//        if(e instanceof MethodArgumentNotValidException) {
//            BindingResult bindingResult = ((MethodArgumentNotValidException) e).getBindingResult();
//            response.setMessage(bindingResult.getFieldError().getDefaultMessage());
//        }
//        return response;
//    }


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
