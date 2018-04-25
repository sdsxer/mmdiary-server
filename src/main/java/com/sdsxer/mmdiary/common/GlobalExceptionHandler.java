package com.sdsxer.mmdiary.common;

import com.sdsxer.mmdiary.exception.BadRequestException;
import com.sdsxer.mmdiary.exception.BaseException;
import com.sdsxer.mmdiary.exception.PasswordErrorException;
import com.sdsxer.mmdiary.exception.UserNotExistException;
import com.sdsxer.mmdiary.utils.ResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger("GlobalExceptionHandler");

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public RestResponse methodArgumentNotValidErrorHandler(HttpServletRequest req, MethodArgumentNotValidException e) {
        logger.error("MethodArgumentNotValidException Handler: Host {} invokes url {} ERROR: {}", req.getRemoteHost(), req.getRequestURL(), e.getMessage());
        BindingResult bindingResult = e.getBindingResult();
        return ResponseUtils.createErrorRestResponse(ErrorCode.BAD_REQUEST, bindingResult.getFieldError().getDefaultMessage());
    }

    @ExceptionHandler(value = BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public RestResponse badRequestErrorHandler(HttpServletRequest req, Exception e) {
        logger.error("BadRequestException Handler: Host {} invokes url {} ERROR: {}", req.getRemoteHost(), req.getRequestURL(), e.getMessage());
        return ResponseUtils.createErrorRestResponse(ErrorCode.BAD_REQUEST);
    }

    @ExceptionHandler(value = NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public RestResponse noHandlerFoundErrorHandler(HttpServletRequest req, Exception e) {
        logger.error("NoHandlerFoundException Handler: Host {} invokes url {} ERROR: {}", req.getRemoteHost(), req.getRequestURL(), e.getMessage());
        return ResponseUtils.createErrorRestResponse(ErrorCode.NOT_FOUND);
    }

    @ExceptionHandler(value = BaseException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public RestResponse baseErrorHandler(HttpServletRequest req, Exception e) {
        logger.error("BaseException Handler: Host {} invokes url {} ERROR: {}", req.getRemoteHost(), req.getRequestURL(), e.getMessage());
        int code = ErrorCode.UNKNOWN_ERROR;
        if(e instanceof UserNotExistException) {
            code = ErrorCode.USER_NOT_EXIST;
        }
        else if(e instanceof PasswordErrorException) {
            code = ErrorCode.PASSWORD_ERROR;
        }
        return ResponseUtils.createErrorRestResponse(code);
    }


    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public RestResponse defaultErrorHandler(HttpServletRequest req, Exception e) {
        logger.error("DefaultException Handler: Host {} invokes url {} ERROR: {}", req.getRemoteHost(), req.getRequestURL(), e.getMessage());
        return ResponseUtils.createErrorRestResponse(e);
    }
}
