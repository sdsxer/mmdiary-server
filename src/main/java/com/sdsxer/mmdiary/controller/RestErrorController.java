package com.sdsxer.mmdiary.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sdsxer.mmdiary.response.RestResponse;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;


@RestController
public class RestErrorController implements ErrorController {

    private static final String PATH = "/error";

    @Override
    public String getErrorPath() {
        return PATH;
    }

    @RequestMapping(PATH)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
        ObjectMapper mapper = new ObjectMapper();
        RestResponse restResponse;
        Exception exception = (Exception) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
//        if(exception instanceof ExpiredJwtException) {
//            restResponse = ResponseUtils.createErrorRestResponse(ErrorCode.CREDENTIALS_EXPIRED);
//        }
//        else if(exception instanceof ClaimJwtException) {
//            restResponse = ResponseUtils.createErrorRestResponse(ErrorCode.AUTHENTICATION_FAILED);
//            restResponse.setDetail(exception.getClass().getName());
//        }
////        else if(exception instanceof AuthenticationExceptioin) {
////            restResponse = ResponseUtils.createErrorRestResponse(ErrorCode.AUTHENTICATION_FAILED);
////            restResponse.setDetail(exception.getClass().getName());
////        }
//        else if(exception instanceof AuthenticationCredentialsNotFoundException) {
//            restResponse = ResponseUtils.createErrorRestResponse(ErrorCode.AUTHENTICATION_FAILED);
//            restResponse.setDetail(exception.getClass().getName());
//        }
//        else {
//            restResponse = ResponseUtils.createErrorRestResponse(exception);
//        }
        Map<String, Object> responseBody = mapper.convertValue(null, new TypeReference<Map<String, Object>>() {});
        return new ResponseEntity<>(responseBody, HttpStatus.UNAUTHORIZED);
    }
}
