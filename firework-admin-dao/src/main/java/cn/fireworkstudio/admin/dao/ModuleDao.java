package cn.fireworkstudio.admin.dao;

import cn.fireworkstudio.admin.bean.Module;

import java.util.List;

/**
 * Copyright: 2016 FireworkStudio
 * *
 * Author:  Daniel Kong
 * Desc:    ModuleDao
 */
public interface ModuleDao {

    /**
     * Add new module
     *
     * @param module module to add
     * @return primary key of added module
     */
    long addModule(Module module);

    /**
     * Get system module list
     *
     * @param module search criteria
     * @return module list
     */
    List<Module> searchModule(Module module);

    /**
     * Get module list of certain user
     *
     * @param userId user id
     * @return modules that user can access
     */
    List<Module> getModulesByUserId(String userId);
}
