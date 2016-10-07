package cn.fireworkstudio.admin.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Copyright: 2016 FireworkStudio
 * *
 * Author:  Daniel Kong
 * Desc:    User role bean
 */
public class UserRole implements Serializable {

    /**
     * Primary Key
     */
    private Long id;

    /**
     * User ID
     */
    private String userId;

    /**
     * Role Name
     */
    private String roleName;

    /**
     * Valid: 1 Yes 0 No
     */
    private Integer valid;

    /**
     * Create Time
     */
    private Date createTime;

    /**
     * Last Update Time
     */
    private Date updateTime;

    /**
     * Create By
     */
    private String createUser;

    /**
     * Update By
     */
    private String updateUser;

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
     * Get roleName
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * Set roleName
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * Get valid
     */
    public Integer getValid() {
        return valid;
    }

    /**
     * Set valid
     */
    public void setValid(Integer valid) {
        this.valid = valid;
    }

    /**
     * Get createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * Set createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * Get updateTime
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * Set updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * Get createUser
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * Set createUser
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    /**
     * Get updateUser
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * Set updateUser
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
}
