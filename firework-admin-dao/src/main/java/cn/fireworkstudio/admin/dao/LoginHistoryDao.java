package cn.fireworkstudio.admin.dao;

import cn.fireworkstudio.admin.bean.LoginHistory;

/**
 * Copyright: 2016 FireworkStudio
 * *
 * Author:  Daniel Kong
 * Desc:    LoginHistoryDao
 */
public interface LoginHistoryDao {

    /**
     * Add new login history
     *
     * @param loginHistory Login history
     * @return new history's primary key
     */
    long addLoginHistory(LoginHistory loginHistory);
}
