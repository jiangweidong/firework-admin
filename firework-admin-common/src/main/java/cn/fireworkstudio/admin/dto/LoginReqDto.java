package cn.fireworkstudio.admin.dto;

import java.io.Serializable;

/**
 * Copyright: 2016 FireworkStudio
 * *
 * Author:  Daniel Kong
 * Desc:    Login Request
 */
public class LoginReqDto implements Serializable {

    /**
     * User ID
     */
    private String userId;

    /**
     * Password
     */
    private String password;

    /**
     * Platform (portal or mobile)
     */
    private String platform;

    /**
     * Device id
     */
    private String deviceId;

    /**
     * Get userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Set userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Get password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get platform
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * Set platform
     */
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    /**
     * Get deviceId
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * Set deviceId
     */
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
