package cn.fireworkstudio.admin.dto;

import cn.fireworkstudio.admin.bean.SysMenu;

import java.io.Serializable;
import java.util.List;

/**
 * Copyright: 2016 FireworkStudio
 * *
 * Author:  Daniel Kong
 * Desc:    Login response
 */
public class LoginResDto implements Serializable {

    /**
     * User ID
     */
    private String userId;

    /**
     * User Name
     */
    private String userName;

    /**
     * Bearer Token
     */
    private String token;

    /**
     * System menus
     */
    private List<SysMenu> menuList;

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
     * Get userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Set userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
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

    /**
     * Get menuList
     */
    public List<SysMenu> getMenuList() {
        return menuList;
    }

    /**
     * Set menuList
     */
    public void setMenuList(List<SysMenu> menuList) {
        this.menuList = menuList;
    }
}
