package cn.fireworkstudio.admin.dao.impl;

import cn.fireworkstudio.admin.bean.LoginHistory;
import cn.fireworkstudio.admin.dao.LoginHistoryDao;
import com.raycloud.cobarclient.mybatis.spring.MySqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Copyright: 2016 FireworkStudio
 * *
 * Author:  Daniel Kong
 * Desc:    LoginHistoryDao
 */
@Repository("loginHistoryDao")
public class LoginHistoryDaoImpl implements LoginHistoryDao {

    private static final String NAMESPACE = "mybatis.mapper.LoginHistoryMapper";

    @Resource
    private MySqlSessionTemplate sessionTemplate;

    /**
     * Add new login history
     *
     * @param loginHistory Login history
     * @return new history's primary key
     */
    @Override
    public long addLoginHistory(LoginHistory loginHistory) {
        return sessionTemplate.insert(NAMESPACE + ".addLoginHistory", loginHistory);
    }
}
