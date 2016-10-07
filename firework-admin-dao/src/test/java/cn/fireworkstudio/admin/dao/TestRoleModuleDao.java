package cn.fireworkstudio.admin.dao;

import cn.fireworkstudio.admin.bean.RoleModule;
import cn.fireworkstudio.admin.constant.StringConstant;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static junit.framework.TestCase.assertTrue;

/**
 * Copyright: 2016 FireworkStudio
 * *
 * Author:  Daniel Kong
 * Desc:    Test Case Of RoleModuleDao
 */
@ContextConfiguration(locations = {"classpath:/config/test-spring-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestRoleModuleDao {

    private static final Logger logger = LoggerFactory.getLogger(TestRoleModuleDao.class);

    @Autowired
    private RoleModuleDao roleModuleDao;

    @Test
    public void testAddRoleModule() throws Exception {
        RoleModule roleModule = new RoleModule();
        roleModule.setModuleCode("code");
        roleModule.setRoleName("GUEST");
        roleModule.setValid(1);
        roleModule.setCreateUser(StringConstant.SYSTEM);
        assertTrue(roleModuleDao.addRoleModule(roleModule) > 0);
    }

    @Test
    public void testSearchRoleModule() throws Exception {
        RoleModule roleModule = new RoleModule();
        roleModule.setModuleCode("code");
        roleModule.setRoleName("GUEST");

        List<RoleModule> roleModuleList = roleModuleDao.searchRoleModule(roleModule);
        logger.info(JSON.toJSONString(roleModuleList));
    }
}
