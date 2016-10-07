package cn.fireworkstudio.admin.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;

/**
 * Copyright: 2016 FireworkStudio
 * *
 * Author:  Daniel Kong
 * Desc:    System Module
 */
public class Module implements Serializable {

    /**
     * Primary Key
     */
    private Long id;

    /**
     * Module Code
     */
    private String code;

    /**
     * Module Name
     */
    private String name;

    /**
     * Module Parent Id
     */
    private Long parent;

    /**
     * URL
     */
    private String url;

    /**
     * AngularJS Controller
     */
    private String controller;

    /**
     * AngularJS Temlate
     */
    private String template;

    /**
     * Sequence In current module depth
     */
    private Integer orderId;

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
    @JsonIgnore
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
     * Get code
     */
    public String getCode() {
        return code;
    }

    /**
     * Set code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Get name
     */
    public String getName() {
        return name;
    }

    /**
     * Set name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get parent
     */
    public Long getParent() {
        return parent;
    }

    /**
     * Set parent
     */
    public void setParent(Long parent) {
        this.parent = parent;
    }

    /**
     * Get url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Set url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Get controller
     */
    public String getController() {
        return controller;
    }

    /**
     * Set controller
     */
    public void setController(String controller) {
        this.controller = controller;
    }

    /**
     * Get template
     */
    public String getTemplate() {
        return template;
    }

    /**
     * Set template
     */
    public void setTemplate(String template) {
        this.template = template;
    }

    /**
     * Get orderId
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * Set orderId
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * Get valid
     */
    @JsonIgnore
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
    @JsonIgnore
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
    @JsonIgnore
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
