package com.yinsy.onepiece.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户相关API
 */
@RestController
@RequestMapping("security/api-user-demo")
public class SecurityUserDemoController {

    @GetMapping("hello")
    public void hello(){
        System.out.println("Hello! Spring Sercurity.");
    }
}
