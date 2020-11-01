package com.yinsy.onepiece.user.service.impl;

import com.yinsy.onepiece.user.dto.UserLoginDTO;
import com.yinsy.onepiece.user.entity.UserLogin;
import com.yinsy.onepiece.user.repository.UserLoginRepository;
import com.yinsy.onepiece.user.service.UserLoginService;
import com.yinsy.onepiece.user.vo.UserLoginVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
@Slf4j
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    private UserLoginRepository userLoginRepository;

    @Override
    public UserLoginVO login(UserLoginDTO userLoginDTO) {
        // 根据手机号 进行用户状态校验: 用户是否存在, 用户状态是否可登陆
        UserLogin userLogin = checkUserExist(userLoginDTO);

        // 用户返回前端信息对象
        UserLoginVO userLoginVO;
        if(!ObjectUtils.isEmpty(userLogin)){
            log.debug("<用户登陆>{}",userLogin.getLoginId());
            log.info("<用户登陆>{}",userLogin.getLoginId());
            log.error("<用户登陆>{}",userLogin.getLoginId());
            log.warn("<用户登陆>{}",userLogin.getLoginId());
            // 存在登陆逻辑
            userLoginVO = userLogin(userLogin);
        } else {
            // 不存在注册逻辑
            userLoginVO = userRegister();
        }
        // 对用户信息缓存
        userInfoCacha(userLoginVO);
        return userLoginVO;
    }

    UserLogin checkUserExist(UserLoginDTO userLoginDTO){
        UserLogin userLogin = userLoginRepository.findUserLoginByLoginId(userLoginDTO.getLoginId());
        return userLogin;
    }

    UserLoginVO userLogin(UserLogin userLogin){

        UserLoginVO userLoginVO = new UserLoginVO();
        userLoginVO.setLoginId(userLogin.getLoginId());
        return userLoginVO;
    }

    UserLoginVO userRegister(){
        // TODO
        return null;
    }

    void userInfoCacha(UserLoginVO userLoginVO){
        // TODO
    }

}