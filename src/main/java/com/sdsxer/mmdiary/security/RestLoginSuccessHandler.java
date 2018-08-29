package com.sdsxer.mmdiary.security;

import com.sdsxer.mmdiary.response.RestResponse;
import com.sdsxer.mmdiary.domain.User;
import com.sdsxer.mmdiary.token.TokenManager;
import com.sdsxer.mmdiary.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RestLoginSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private TokenManager tokenManager;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
              Authentication authentication) {
        User user = ((RestUserDetails) authentication.getPrincipal()).getUser();
        String token = tokenManager.generateToken(user.token());
        RestResponse restResponse = ResponseUtils.createSuccessResponse(user);

        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setHeader(HttpHeaders.AUTHORIZATION, token);

        try {
            ResponseUtils.responseJson(response, restResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
