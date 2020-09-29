package com.yinsy.onepiece.user.dto;

import lombok.Data;

@Data
public class UserLoginDTO {
    /**
     * 用户登陆名
     */
    private String loginId;

    /**
     * 用户密码/用户短信/其他方式
     */
    private String loginPassword;

    /**
     * 用户登陆类型
     */
    private String loginType;

    /**
     * 登陆验证码
     */
    private String verificationCode;

    /**
     * 登陆渠道
     */
    private String loginChannel;
}