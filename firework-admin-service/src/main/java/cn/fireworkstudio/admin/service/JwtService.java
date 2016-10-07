package cn.fireworkstudio.admin.service;

import cn.fireworkstudio.admin.bean.PlatformUser;

/**
 * Copyright: 2016 FireworkStudio
 * *
 * Author:  Daniel Kong
 * Desc:    Json web token service
 */
public interface JwtService {

    /**
     * Generate json web token from platform user object
     *
     * @param user platform user object
     * @return token
     */
    String generateToken(PlatformUser user);

    /**
     * Parse platform user object from json web token
     *
     * @param token Json Web Token
     * @return PlatformUser object
     */
    PlatformUser parseToken(String token);
}
