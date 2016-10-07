package cn.fireworkstudio.admin.security.util;

import org.springframework.security.core.AuthenticationException;

/**
 * Copyright: 2016 FireworkStudio
 * *
 * Author:  Daniel Kong
 * Desc:    JwtTokenMalformedException
 */
public class JwtTokenMalformedException extends AuthenticationException {

    /**
     * constructor
     */
    public JwtTokenMalformedException(String msg) {
        super(msg);
    }
}
