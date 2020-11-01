package com.yinsy.onepiece.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 客户端公开访问API
 */
@RestController
@RequestMapping("security/api-app-demo")
public class SecurityAppDemoController {
    @GetMapping("hello")
    public void hello(){
        System.out.println("Hello! Spring Sercurity.");
    }
}