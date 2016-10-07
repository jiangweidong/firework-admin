package cn.fireworkstudio.admin.security.util;

import org.springframework.security.core.AuthenticationException;

/**
 * Copyright: 2016 FireworkStudio
 * *
 * Author:  Daniel Kong
 * Desc:    JwtTokenMissingException
 */
public class JwtTokenMissingException extends AuthenticationException {

    /**
     * 构造函数
     */
    public JwtTokenMissingException(String msg) {
        super(msg);
    }
}
