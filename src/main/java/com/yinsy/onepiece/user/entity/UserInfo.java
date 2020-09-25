package com.yinsy.onepiece.user.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table
@Data
public class UserInfo {
    @Id
    /**
    * 用户自增主键
    **/
    private Long id;

    /**
    * 用户业务主键 唯一索引
    **/
    private String userId;

    /**
    * 用户昵称 唯一索引
    **/
    private String userName;

    /**
    * 用户头像URL
    **/
    private String userAvatar;

    /**
    * 创建时间
    **/
    private Timestamp createTime;

    /**
    * 更新时间
    **/
    private Timestamp updateTime;

}