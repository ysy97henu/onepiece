package com.yinsy.onepiece.demo.controller;

import com.yinsy.onepiece.common.base.BaseResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo")
public class DemoController {

    @GetMapping("first")
    public BaseResponse firstDemo(String param){
        return new BaseResponse(param);
    }

    @GetMapping("second")
    public BaseResponse secondDemo(String param){
        return new BaseResponse(param);
    }

}
