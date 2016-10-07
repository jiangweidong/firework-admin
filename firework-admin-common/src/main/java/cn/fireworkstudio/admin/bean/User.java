package cn.fireworkstudio.admin.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Copyright: 2016 FireworkStudio
 * *
 * Author:  Daniel Kong
 * Desc:    System User bean
 */
public class User implements Serializable {

    /**
     * Primary Key
     */
    private Long id;

    /**
     * User Login ID
     */
    private String userId;

    /**
     * User Password
     */
    private String userPwd;

    /**
     * User Name
     */
    private String userName;

    /**
     * Gender：1 Male 2 Female
     */
    private Integer gender;

    /**
     * Identification Number
     */
    private String idNumber;

    /**
     * Mobile Number
     */
    private String mobile;

    /**
     * Email
     */
    private String email;

    /**
     * Zip Code
     */
    private String zip;

    /**
     * Address
     */
    private String address;

    /**
     * Valid User: 1 Yes 0 No
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
     * Get userPwd
     */
    public String getUserPwd() {
        return userPwd;
    }

    /**
     * Set userPwd
     */
    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
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
     * Get gender
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * Set gender
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * Get idNumber
     */
    public String getIdNumber() {
        return idNumber;
    }

    /**
     * Set idNumber
     */
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    /**
     * Get mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * Set mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * Get email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * Set zip
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * Get address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set address
     */
    public void setAddress(String address) {
        this.address = address;
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
