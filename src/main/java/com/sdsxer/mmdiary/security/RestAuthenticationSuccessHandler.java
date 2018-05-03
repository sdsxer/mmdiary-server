package com.sdsxer.mmdiary.security;

import com.sdsxer.mmdiary.common.RestResponse;
import com.sdsxer.mmdiary.domain.User;
import com.sdsxer.mmdiary.utils.JwtUtils;
import com.sdsxer.mmdiary.utils.ResponseUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RestAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
              Authentication authentication) {
        User user = ((RestUserDetails) authentication.getPrincipal()).getUser();
        String token = JwtUtils.generateJwtToken(user.getId());
        RestResponse restResponse = ResponseUtils.createSuccessRestResponse(user);

        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.addHeader(HttpHeaders.AUTHORIZATION, token);
        ResponseUtils.responseJson(response, restResponse);
    }
}
