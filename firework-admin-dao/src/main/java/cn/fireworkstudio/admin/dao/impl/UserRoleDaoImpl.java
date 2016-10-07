package cn.fireworkstudio.admin.dao.impl;

import cn.fireworkstudio.admin.bean.UserRole;
import cn.fireworkstudio.admin.dao.UserRoleDao;
import com.raycloud.cobarclient.mybatis.spring.MySqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Copyright: 2016 FireworkStudio
 * *
 * Author:  Daniel Kong
 * Desc:    UserRoleDao
 */
@Repository("userRoleDao")
public class UserRoleDaoImpl implements UserRoleDao {

    private static final String NAMESPACE = "mybatis.mapper.UserRoleMapper";

    @Resource
    private MySqlSessionTemplate sessionTemplate;

    /**
     * Add new user role mapping
     *
     * @param userRole mapping to add
     * @return new mapping's primary key
     */
    @Override
    public long addUserRole(UserRole userRole) {
        return sessionTemplate.insert(NAMESPACE + ".addUserRole", userRole);
    }

    /**
     * Search user role mappings by params
     *
     * @param userRole params
     * @return mappings found or null
     */
    @Override
    public List<UserRole> searchUserRole(UserRole userRole) {
        return sessionTemplate.selectList(NAMESPACE + ".searchUserRole", userRole);
    }
}
