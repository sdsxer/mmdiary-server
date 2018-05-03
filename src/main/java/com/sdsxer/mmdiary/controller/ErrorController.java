package com.sdsxer.mmdiary.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sdsxer.mmdiary.common.ErrorCode;
import com.sdsxer.mmdiary.common.RestResponse;
import com.sdsxer.mmdiary.exception.AuthenticationExceptioin;
import com.sdsxer.mmdiary.utils.ResponseUtils;
import io.jsonwebtoken.ClaimJwtException;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;


@RestController
public class ErrorController extends BasicErrorController {

    public ErrorController() {
        super(new DefaultErrorAttributes(), new ErrorProperties());
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping
    @ResponseBody
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
        ObjectMapper mapper = new ObjectMapper();
        RestResponse restResponse;
        Exception exception = (Exception) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
        if(exception instanceof ExpiredJwtException) {
            restResponse = ResponseUtils.createErrorRestResponse(ErrorCode.CREDENTIALS_EXPIRED);
        }
        else if(exception instanceof ClaimJwtException) {
            restResponse = ResponseUtils.createErrorRestResponse(ErrorCode.AUTHENTICATION_FAILED);
            restResponse.setDetail(exception.getClass().getName());
        }
        else if(exception instanceof AuthenticationExceptioin) {
            restResponse = ResponseUtils.createErrorRestResponse(ErrorCode.AUTHENTICATION_FAILED);
            restResponse.setDetail(exception.getClass().getName());
        }
        else if(exception instanceof AuthenticationCredentialsNotFoundException) {
            restResponse = ResponseUtils.createErrorRestResponse(ErrorCode.AUTHENTICATION_FAILED);
            restResponse.setDetail(exception.getClass().getName());
        }
        else {
            restResponse = ResponseUtils.createErrorRestResponse(exception);
        }
        Map<String, Object> responseBody = mapper.convertValue(restResponse, new TypeReference<Map<String, Object>>() {});
        return new ResponseEntity<>(responseBody, HttpStatus.UNAUTHORIZED);
    }
}
