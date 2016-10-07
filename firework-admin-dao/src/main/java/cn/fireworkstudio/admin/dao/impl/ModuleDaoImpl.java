package cn.fireworkstudio.admin.dao.impl;

import cn.fireworkstudio.admin.bean.Module;
import cn.fireworkstudio.admin.dao.ModuleDao;
import com.raycloud.cobarclient.mybatis.spring.MySqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Copyright: 2016 FireworkStudio
 * *
 * Author:  Daniel Kong
 * Desc:    ModuleDao
 */
@Repository("moduleDao")
public class ModuleDaoImpl implements ModuleDao {

    private static final String NAMESPACE = "mybatis.mapper.ModuleMapper";

    @Resource
    private MySqlSessionTemplate sessionTemplate;

    /**
     * Add new module
     *
     * @param module module to add
     * @return primary key of added module
     */
    @Override
    public long addModule(Module module) {
        return sessionTemplate.insert(NAMESPACE + ".addModule", module);
    }

    /**
     * Get system module list
     *
     * @param module search criteria
     * @return module list
     */
    @Override
    public List<Module> searchModule(Module module) {
        return sessionTemplate.selectList(NAMESPACE + ".searchModule", module);
    }

    /**
     * Get module list of certain user
     *
     * @param userId user id
     * @return modules that user can access
     */
    @Override
    public List<Module> getModulesByUserId(String userId) {
        return sessionTemplate.selectList(NAMESPACE + ".getModulesByUserId", userId);
    }
}
