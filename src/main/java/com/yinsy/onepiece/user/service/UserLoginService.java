package com.yinsy.onepiece.user.service;

import com.yinsy.onepiece.user.dto.UserLoginDTO;
import com.yinsy.onepiece.user.vo.UserLoginVO;

public interface UserLoginService {

    UserLoginVO login(UserLoginDTO userLoginDTO);

}