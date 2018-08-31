package com.sdsxer.mmdiary.config;

import com.sdsxer.mmdiary.common.SystemEnvironment;
import com.sdsxer.mmdiary.domain.SystemRole;
import com.sdsxer.mmdiary.filter.RestTokenFilter;
import com.sdsxer.mmdiary.filter.RestLoginFilter;
import com.sdsxer.mmdiary.security.*;
import com.sdsxer.mmdiary.security.RestAccessDeniedHandler;
import com.sdsxer.mmdiary.security.RestLoginFailureHandler;
import com.sdsxer.mmdiary.security.RestLoginSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private Environment environment;

    // when using a different authentication system,
    // and the password is not provided in your own database/data model,
    // you have to use the AuthenticationProvider
    // in another system, when storing the password in your own database,
    // all you had to do was implementing the UserDetailsService and
    // check if the user exists in your database or not, spring-security had to do the rest
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(restUserDetailsService()).passwordEncoder(passwordEncoder());
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/**/*.html");
        web.ignoring().antMatchers("/**/*.css");
        web.ignoring().antMatchers("/**/*.js");
        web.ignoring().antMatchers("/**/*.ico");
        web.ignoring().antMatchers("/**/*.png");
        web.ignoring().antMatchers("/**/*.jpg");
        web.ignoring().antMatchers("/**/*.jpeg");
        web.ignoring().antMatchers("/**/*.gif");
        web.ignoring().antMatchers("/h2-console/*");
        web.ignoring().antMatchers(HttpMethod.POST, "/api/user/register");
        web.ignoring().antMatchers(HttpMethod.GET, "/api/*/get");
        web.ignoring().antMatchers(HttpMethod.GET,"/api/*/list");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().frameOptions().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.formLogin().disable();
        http.httpBasic().disable();
        http.logout().disable();
        http.rememberMe().disable();

        http.authorizeRequests()
                .antMatchers("/api/*/add", "/api/*/update",
                        "/api/*/delete", "/api/*/revoke", "/api/*/release").hasRole(SystemRole.EDITOR)
                .antMatchers("/api/user/me").authenticated()
                .anyRequest().permitAll();

        http.exceptionHandling().accessDeniedHandler(accessDeniedHandler());
        http.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint());

        http.addFilterAt(loginFilter(), UsernamePasswordAuthenticationFilter.class);
        http.addFilterAt(tokenFilter(), BasicAuthenticationFilter.class);
    }

    @Bean
    public UserDetailsService restUserDetailsService() {
        return new RestUserDetailsService();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setHideUserNotFoundExceptions(false);
        daoAuthenticationProvider.setUserDetailsService(restUserDetailsService());
        return daoAuthenticationProvider;
    }

    private PasswordEncoder passwordEncoder() {
        if(environment.getActiveProfiles()[0].equals(SystemEnvironment.DEV)) {
            return NoOpPasswordEncoder.getInstance();
        }
        else if(environment.getActiveProfiles()[0].equals(SystemEnvironment.QA)) {
            return new BCryptPasswordEncoder();
        }
        else if(environment.getActiveProfiles()[0].equals(SystemEnvironment.PROD)) {
            return new BCryptPasswordEncoder();
        }
        return NoOpPasswordEncoder.getInstance();
    }

    private UsernamePasswordAuthenticationFilter loginFilter() throws Exception {
        RestLoginFilter loginFilter = new RestLoginFilter();
        loginFilter.setFilterProcessesUrl("/api/user/login");
        loginFilter.setAuthenticationSuccessHandler(loginSuccessHandler());
        loginFilter.setAuthenticationFailureHandler(loginFailureHandler());
        loginFilter.setAuthenticationManager(authenticationManager());
        return loginFilter;
    }

    @Bean
    public BasicAuthenticationFilter tokenFilter() throws Exception {
        return new RestTokenFilter(authenticationManager());
    }

    @Bean
    public AuthenticationSuccessHandler loginSuccessHandler() {
        return new RestLoginSuccessHandler();
    }

    @Bean
    public AuthenticationFailureHandler loginFailureHandler() {
        return new RestLoginFailureHandler();
    }

    private AuthenticationEntryPoint authenticationEntryPoint() {
        return new RestAuthenticationEntryPoint();
    }

    private AccessDeniedHandler accessDeniedHandler() {
        return new RestAccessDeniedHandler();
    }
}
