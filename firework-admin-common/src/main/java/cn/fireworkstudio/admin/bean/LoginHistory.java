package cn.fireworkstudio.admin.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Copyright: 2016 FireworkStudio
 * *
 * Author:  Daniel Kong
 * Desc:    Login history bean
 */
public class LoginHistory implements Serializable {

    /**
     * Primary Key
     */
    private Long id;

    /**
     * Login user id
     */
    private String userId;

    /**
     * Device token
     */
    private String deviceId;

    /**
     * Platform: 1 Portal 2 Android 3 iOS
     */
    private String platform;

    /**
     * Login time
     */
    private Date loginTime;

    /**
     * Get id
     */
    public Long getId() {
        return id;
    }

    /**
     * Set id
     */
    public void setId(Long id) {
        this.id = id;
    }

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
     * Get loginTime
     */
    public Date getLoginTime() {
        return loginTime;
    }

    /**
     * Set loginTime
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }
}
