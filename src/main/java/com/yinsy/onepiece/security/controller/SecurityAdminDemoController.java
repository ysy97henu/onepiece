package com.yinsy.onepiece.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统后台相关API
 */
@RestController
@RequestMapping("security/api-admin-demo")
public class SecurityAdminDemoController {
    @GetMapping("hello")
    public void hello(){
        System.out.println("Hello! Spring Sercurity.");
    }
}