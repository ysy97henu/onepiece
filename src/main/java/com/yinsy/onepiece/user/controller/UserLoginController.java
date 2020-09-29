package com.yinsy.onepiece.user.controller;

import com.yinsy.onepiece.common.base.BaseResponse;
import com.yinsy.onepiece.user.dto.UserLoginDTO;
import com.yinsy.onepiece.user.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "user")
public class UserLoginController {

    @Autowired
    private UserLoginService userLoginService;

    @PostMapping("login")
    public BaseResponse userLogin(@RequestBody UserLoginDTO userLoginDTO) {
        return new BaseResponse(userLoginService.login(userLoginDTO));
    }
}