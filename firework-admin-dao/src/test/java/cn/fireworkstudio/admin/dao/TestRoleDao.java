package cn.fireworkstudio.admin.dao;

import cn.fireworkstudio.admin.bean.Role;
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
 * Desc:    Test Case Of RoleDao
 */
@ContextConfiguration(locations = {"classpath:/config/test-spring-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestRoleDao {

    private static final Logger logger = LoggerFactory.getLogger(TestRoleDao.class);

    @Autowired
    private RoleDao roleDao;

    @Test
    public void testAddRole() throws Exception {
        Role role = new Role();
        role.setRoleName("GUEST");
        role.setValid(1);
        role.setCreateUser(StringConstant.SYSTEM);
        assertTrue(roleDao.addRole(role) > 0);
    }

    @Test
    public void testSearchRole() throws Exception {
        Role role = new Role();
        role.setRoleName("GUEST");

        List<Role> roleList = roleDao.searchRole(role);
        logger.info(JSON.toJSONString(roleList));
    }
}
