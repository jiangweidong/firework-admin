package cn.fireworkstudio.admin.security.bean;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 * Copyright: 2016 FireworkStudio
 * *
 * Author:  Daniel Kong
 * Desc:    Jwt authentication token
 */
public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken {

    private String token;

    /**
     * constructor
     */
    public JwtAuthenticationToken(String token) {
        super(null, null);
        this.token = token;
    }

    /**
     * Get token
     */
    public String getToken() {
        return token;
    }

    /**
     * Set token
     */
    public void setToken(String token) {
        this.token = token;
    }
}
