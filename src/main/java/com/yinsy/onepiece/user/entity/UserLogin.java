package com.yinsy.onepiece.user.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table
@Data
public class UserLogin {
    @Id
    /**
    * 自增主键
    **/
    private Long id;

    /**
    * 用户手机号
    **/
    private String loginId;

    /**
     * 用户密码
     */
    private String loginPassword;

    /**
    * 用户业务主键
    **/
    private String userId;

    /**
    * 有效标识
    **/
    private Boolean availableFlag;

    /**
    * 上次登陆时间
    **/
    private Timestamp lastLoginTime;

    /**
    * 创建时间
    **/
    private Timestamp createTime;

    /**
    * 更新时间
    **/
    private Timestamp updateTime;

}