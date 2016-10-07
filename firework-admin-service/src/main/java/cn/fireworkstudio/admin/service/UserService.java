package cn.fireworkstudio.admin.service;

import cn.fireworkstudio.admin.dto.LoginReqDto;
import cn.fireworkstudio.admin.dto.LoginResDto;

/**
 * Copyright: 2016 FireworkStudio
 * *
 * Author:  Daniel Kong
 * Desc:    User Service
 */
public interface UserService {

    /**
     * User Login
     *
     * @param reqDto Login request
     * @return Login result
     */
    LoginResDto login(LoginReqDto reqDto);
}
