package cn.fireworkstudio.admin.dao;

import cn.fireworkstudio.admin.bean.User;

import java.util.List;

/**
 * Copyright: 2016 FireworkStudio
 * *
 * Author:  Daniel Kong
 * Desc:    UserDao
 */
public interface UserDao {

    /**
     * Add new user
     *
     * @param user user to add
     * @return new user's primary key
     */
    long addUser(User user);

    /**
     * Search user by params
     *
     * @param user params
     * @return users found or null
     */
    List<User> searchUser(User user);
}
