package com.sdsxer.mmdiary.controller;

import com.sdsxer.mmdiary.common.ErrorCode;
import com.sdsxer.mmdiary.common.RestResponse;
import com.sdsxer.mmdiary.request.LoginRequest;
import com.sdsxer.mmdiary.request.RegisterRequest;
import com.sdsxer.mmdiary.service.UserService;
import com.sdsxer.mmdiary.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * useless, login request is deliver to spring security
     * @param loginRequest
     * @return
     * @throws Exception
     */
    @Deprecated
    @RequestMapping(value = "/login")
    public RestResponse login(@RequestBody LoginRequest loginRequest) {
        return ResponseUtils.createErrorRestResponse(ErrorCode.SUCCESS);
    }


    @RequestMapping("/detail")
    public RestResponse userDetail() {
        return null;
    }

    @RequestMapping("/register")
    public RestResponse register(@RequestBody RegisterRequest request) {
        return ResponseUtils.createSuccessRestResponse(null);
    }

}
