package cn.fireworkstudio.admin.bean;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * Copyright: 2016 FireworkStudio
 * *
 * Author:  Daniel Kong
 * Desc:    Authenticated platform user
 */
public class PlatformUser extends User {

    /**
     * Device Id (only for mobile devices)
     */
    private String deviceId;

    /**
     * From platform
     */
    private String platform;

    /**
     * User role (separate by , )
     */
    private String role;

    /**
     * Login time
     */
    private Long loginTime;

    /**
     * 构造函数
     */
    public PlatformUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public PlatformUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired,
                           boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
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
     * Get role
     */
    public String getRole() {
        return role;
    }

    /**
     * Set role
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Get loginTime
     */
    public Long getLoginTime() {
        return loginTime;
    }

    /**
     * Set loginTime
     */
    public void setLoginTime(Long loginTime) {
        this.loginTime = loginTime;
    }
}
