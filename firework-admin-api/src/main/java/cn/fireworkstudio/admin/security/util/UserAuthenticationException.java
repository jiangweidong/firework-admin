package cn.fireworkstudio.admin.security.util;

import org.springframework.security.core.AuthenticationException;

/**
 * Copyright: 2016 FireworkStudio
 * *
 * Author:  Daniel Kong
 * Desc:    UserAuthenticationException
 */
public class UserAuthenticationException extends AuthenticationException {

    private String resultCode;

    /**
     * constructor
     */
    public UserAuthenticationException(String msg) {
        super(msg);
    }

    public UserAuthenticationException(String msg, String resultCode) {
        super(msg);
        this.resultCode = resultCode;
    }

    /**
     * Get resultCode
     */
    public String getResultCode() {
        return resultCode;
    }

    /**
     * Set resultCode
     */
    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }
}
