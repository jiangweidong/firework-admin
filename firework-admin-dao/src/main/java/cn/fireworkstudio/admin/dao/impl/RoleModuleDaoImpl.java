package cn.fireworkstudio.admin.dao.impl;

import cn.fireworkstudio.admin.bean.RoleModule;
import cn.fireworkstudio.admin.dao.RoleModuleDao;
import com.raycloud.cobarclient.mybatis.spring.MySqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Copyright: 2016 FireworkStudio
 * *
 * Author:  Daniel Kong
 * Desc:    RoleModuleDao
 */
@Repository("roleModuleDao")
public class RoleModuleDaoImpl implements RoleModuleDao {

    private static final String NAMESPACE = "mybatis.mapper.RoleModuleMapper";

    @Resource
    private MySqlSessionTemplate sessionTemplate;

    /**
     * Add new role module mapping
     *
     * @param roleModule role module mapping to add
     * @return new mapping's primary key
     */
    @Override
    public long addRoleModule(RoleModule roleModule) {
        return sessionTemplate.insert(NAMESPACE + ".addRoleModule", roleModule);
    }

    /**
     * Search role module mapping by params
     *
     * @param roleModule params
     * @return role module mappings found or null
     */
    @Override
    public List<RoleModule> searchRoleModule(RoleModule roleModule) {
        return sessionTemplate.selectList(NAMESPACE + ".searchRoleModule", roleModule);
    }
}
