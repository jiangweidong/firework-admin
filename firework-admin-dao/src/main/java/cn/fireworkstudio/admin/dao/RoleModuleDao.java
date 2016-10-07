package cn.fireworkstudio.admin.dao;

import cn.fireworkstudio.admin.bean.RoleModule;

import java.util.List;

/**
 * Copyright: 2016 FireworkStudio
 * *
 * Author:  Daniel Kong
 * Desc:    RoleModuleDao
 */
public interface RoleModuleDao {

    /**
     * Add new role module mapping
     *
     * @param roleModule role module mapping to add
     * @return new mapping's primary key
     */
    long addRoleModule(RoleModule roleModule);

    /**
     * Search role module mapping by params
     *
     * @param roleModule params
     * @return role module mappings found or null
     */
    List<RoleModule> searchRoleModule(RoleModule roleModule);
}
