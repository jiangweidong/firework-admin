package cn.fireworkstudio.admin.dao.impl;

import cn.fireworkstudio.admin.bean.User;
import cn.fireworkstudio.admin.dao.UserDao;
import com.raycloud.cobarclient.mybatis.spring.MySqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Copyright: 2016 FireworkStudio
 * *
 * Author:  Daniel Kong
 * Desc:    UserDao
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {

    private static final String NAMESPACE = "mybatis.mapper.UserMapper";

    @Resource
    private MySqlSessionTemplate sessionTemplate;

    /**
     * Add new user
     *
     * @param user user to add
     * @return new user's primary key
     */
    @Override
    public long addUser(User user) {
        return sessionTemplate.insert(NAMESPACE + ".addUser", user);
    }

    /**
     * Search user by params
     *
     * @param user params
     * @return users found or null
     */
    @Override
    public List<User> searchUser(User user) {
        return sessionTemplate.selectList(NAMESPACE + ".searchUser", user);
    }
}
