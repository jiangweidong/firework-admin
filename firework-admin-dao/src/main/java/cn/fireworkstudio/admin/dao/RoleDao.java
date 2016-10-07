package cn.fireworkstudio.admin.dao;

import cn.fireworkstudio.admin.bean.Role;

import java.util.List;

/**
 * Copyright: 2016 FireworkStudio
 * *
 * Author:  Daniel Kong
 * Desc:    RoleDao
 */
public interface RoleDao {

    /**
     * Add new role
     *
     * @param role role to add
     * @return new role's primary key
     */
    long addRole(Role role);

    /**
     * Search role by params
     *
     * @param role params
     * @return roles found or null
     */
    List<Role> searchRole(Role role);
}
