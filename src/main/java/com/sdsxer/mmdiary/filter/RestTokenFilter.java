package com.sdsxer.mmdiary.filter;

import com.sdsxer.mmdiary.cache.UserCacheManager;
import com.sdsxer.mmdiary.domain.User;
import com.sdsxer.mmdiary.exception.TokenNotFoundException;
import com.sdsxer.mmdiary.security.RestUserDetails;
import com.sdsxer.mmdiary.token.TokenManager;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RestTokenFilter extends BasicAuthenticationFilter {

    private Logger logger = LoggerFactory.getLogger(RestTokenFilter.class.getSimpleName());

    @Autowired
    private TokenManager tokenManager;

    @Autowired
    private UserCacheManager userCacheManager;

    public RestTokenFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response
            , FilterChain chain) throws IOException, ServletException {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        if(StringUtils.isEmpty(token)) {
            throw new TokenNotFoundException(null);
        }
        try{
            String username = tokenManager.parseToken(token);
            User user = userCacheManager.get(username);
            if(user == null) {
                throw new UsernameNotFoundException(username);
            }
            RestUserDetails userDetails = new RestUserDetails(user);
            UsernamePasswordAuthenticationToken authToken =
                    new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authToken);
            chain.doFilter(request, response);
        }
        catch (Exception e) {
            throw e;
        }
    }
}
