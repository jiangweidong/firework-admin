package cn.fireworkstudio.admin.dao.impl;

import cn.fireworkstudio.admin.bean.Role;
import cn.fireworkstudio.admin.dao.RoleDao;
import com.raycloud.cobarclient.mybatis.spring.MySqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Copyright: 2016 FireworkStudio
 * *
 * Author:  Daniel Kong
 * Desc:    RoleDao
 */
@Repository("roleDao")
public class RoleDaoImpl implements RoleDao {

    private static final String NAMESPACE = "mybatis.mapper.RoleMapper";

    @Resource
    private MySqlSessionTemplate sessionTemplate;

    /**
     * Add new role
     *
     * @param role role to add
     * @return new role's primary key
     */
    @Override
    public long addRole(Role role) {
        return sessionTemplate.insert(NAMESPACE + ".addRole", role);
    }

    /**
     * Search role by params
     *
     * @param role params
     * @return roles found or null
     */
    @Override
    public List<Role> searchRole(Role role) {
        return sessionTemplate.selectList(NAMESPACE + ".searchRole", role);
    }
}
