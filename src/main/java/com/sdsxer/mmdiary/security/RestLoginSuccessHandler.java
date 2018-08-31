package com.sdsxer.mmdiary.security;

import com.sdsxer.mmdiary.cache.UserCacheManager;
import com.sdsxer.mmdiary.dto.UserDto;
import com.sdsxer.mmdiary.response.RestResponse;
import com.sdsxer.mmdiary.domain.User;
import com.sdsxer.mmdiary.token.TokenManager;
import com.sdsxer.mmdiary.utils.ResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RestLoginSuccessHandler implements AuthenticationSuccessHandler {

    private Logger logger = LoggerFactory.getLogger(RestLoginSuccessHandler.class.getSimpleName());

    @Autowired
    private TokenManager tokenManager;

    @Autowired
    private UserCacheManager userCacheManager;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
              Authentication authentication) {
        User user = ((RestUserDetails) authentication.getPrincipal()).getUser();
        // cache user
        userCacheManager.put(user.getUsername(), user);
        // generate token
        String token = tokenManager.generateToken(user.getUsername());
        // response
        RestResponse restResponse = ResponseUtils.createSuccessResponse(new UserDto(user));
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setHeader(HttpHeaders.AUTHORIZATION, token);
        ResponseUtils.responseJson(response, restResponse);
    }
}
