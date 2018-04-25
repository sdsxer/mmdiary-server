package com.sdsxer.mmdiary.config;

import com.sdsxer.mmdiary.security.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private RestAuthenticationProvider restAuthenticationProvider;

    @Autowired
    private RestAccessDeniedHandler restAccessDeniedHandler;

    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Autowired
    private RestAuthenticationSuccessHandler restAuthenticationSuccessHandler;

    @Autowired
    private RestAuthenticationFailureHandler restAuthenticationFailureHandler;

    @Autowired
    private RestLogoutSuccessHandler restLogoutSuccessHandler;

    @Autowired
    private RestUserDetailsService restUserDetailsService;

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(restAuthenticationProvider);
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(restAuthenticationProvider);
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.csrf().disable()
                .exceptionHandling()
                .accessDeniedHandler(restAccessDeniedHandler)
                .authenticationEntryPoint(restAuthenticationEntryPoint)
                .and()
                .authorizeRequests()
//                .antMatchers("/api/user/login").permitAll()
                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginProcessingUrl("/api/user/login")
//                .usernameParameter("username")
//                .passwordParameter("password")
//                .successHandler(restAuthenticationSuccessHandler)
//                .failureHandler(restAuthenticationFailureHandler)
//                .and()
//                .logout()
//                .logoutUrl("/api/user/logout")
//                .logoutSuccessHandler(restLogoutSuccessHandler)
//                .invalidateHttpSession(true);
       ;

       http.addFilterBefore(restUsernamePasswordAuthenticationFilter(),
               UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    protected RestUsernamePasswordAuthenticationFilter restUsernamePasswordAuthenticationFilter() throws Exception {
        RestUsernamePasswordAuthenticationFilter filter = new RestUsernamePasswordAuthenticationFilter();
        filter.setFilterProcessesUrl("/api/user/login");
        filter.setAuthenticationSuccessHandler(restAuthenticationSuccessHandler);
        filter.setAuthenticationFailureHandler(restAuthenticationFailureHandler);
        filter.setAuthenticationManager(authenticationManagerBean());
        return filter;
    }

//    @Bean
//    public DaoAuthenticationProvider restAuthenticationProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
////        authProvider.setUserDetailsService(restUserDetailsService);
////        authProvider.setPasswordEncoder(passwordEncoder);
//
//        RestAuthenticationProvider authProvider = new RestAuthenticationProvider();
//        authProvider.setUserDetailsService(restUserDetailsService);
//        authProvider.setPasswordEncoder(passwordEncoder);
//
//        return authProvider;
//    }
}
