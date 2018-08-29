package com.sdsxer.mmdiary.controller;

import com.sdsxer.mmdiary.cache.UserCacheManager;
import com.sdsxer.mmdiary.response.RestResponse;
import com.sdsxer.mmdiary.request.LoginRequest;
import com.sdsxer.mmdiary.request.RegisterRequest;
import com.sdsxer.mmdiary.service.UserService;
import com.sdsxer.mmdiary.utils.ResponseUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    private final UserCacheManager userCacheManager;

    public UserController(UserService userService, UserCacheManager userCacheManager) {
        this.userService = userService;
        this.userCacheManager = userCacheManager;
    }

    @RequestMapping(value = "/login")
    public RestResponse login(@Valid @RequestBody LoginRequest loginRequest, HttpServletRequest request) {
//        User user = userService.findUserByAccount(loginRequest.getUsername());
//        if(user == null) {
//            return ResponseUtils.createErrorRestResponse(ErrorCode.USER_NOT_EXIST);
//        }
//        if(user.getStatus() == User.Status.FREEZE.value()) {
//            return ResponseUtils.createErrorRestResponse(ErrorCode.ACCOUNT_DISABLED);
//        }
//        if(!user.getPassword().equals(loginRequest.getPassword())) {
//            return ResponseUtils.createErrorRestResponse(ErrorCode.PASSWORD_ERROR);
//        }
//        userCacheManager.put(user.getId(), user);
//        return ResponseUtils.createSuccessResponse(user);
        return null;
    }

    @RequestMapping(value = "/logout")
    public RestResponse logout() {
        return ResponseUtils.createSuccessResponse("");
    }

    @RequestMapping("/register")
    public RestResponse register(@Valid @RequestBody RegisterRequest registerRequest) {
        return ResponseUtils.createSuccessResponse(null);
    }

    @RequestMapping("/me")
    public RestResponse userDetail() {
        return null;
    }
}
