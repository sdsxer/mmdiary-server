package com.sdsxer.mmdiary.controller;

import com.sdsxer.mmdiary.common.ErrorCode;
import com.sdsxer.mmdiary.common.RestResponse;
import com.sdsxer.mmdiary.domain.User;
import com.sdsxer.mmdiary.exception.PasswordErrorException;
import com.sdsxer.mmdiary.exception.UserNotExistException;
import com.sdsxer.mmdiary.request.LoginRequest;
import com.sdsxer.mmdiary.service.UserService;
import com.sdsxer.mmdiary.utils.ResponseUtils;
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authc.AuthenticationException;
//import org.apache.shiro.authc.IncorrectCredentialsException;
//import org.apache.shiro.authc.UnknownAccountException;
//import org.apache.shiro.authc.UsernamePasswordToken;
//import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login")
    public RestResponse login(@RequestBody LoginRequest loginRequest) throws Exception {
//        Subject subject = SecurityUtils.getSubject();
//        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
//        token.setRememberMe(true);
//        try {
//            subject.login(token);
//        }
//        catch (IncorrectCredentialsException e) {
//            throw new UserNotExistException();
//        }
//        catch (UnknownAccountException e) {
//            throw new PasswordErrorException();
//        }
        return ResponseUtils.createErrorRestResponse(ErrorCode.SUCCESS);
    }

    @RequestMapping("/register")
    public RestResponse register(@RequestBody User user) {
        return ResponseUtils.createSuccessRestResponse(null);
    }


    @RequestMapping("/logout")
    public void logout() {

    }
}
