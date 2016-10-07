package cn.fireworkstudio.admin.dao;

import cn.fireworkstudio.admin.bean.UserRole;
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
 * Desc:    Test Case Of UserRoleDao
 */
@ContextConfiguration(locations = {"classpath:/config/test-spring-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestUserRoleDao {

    private static final Logger logger = LoggerFactory.getLogger(TestUserRoleDao.class);

    @Autowired
    private UserRoleDao userRoleDao;

    @Test
    public void testAddUserRole() throws Exception {
        UserRole userRole = new UserRole();
        userRole.setUserId("demo");
        userRole.setRoleName("GUEST");
        userRole.setValid(1);
        userRole.setCreateUser(StringConstant.SYSTEM);
        assertTrue(userRoleDao.addUserRole(userRole) > 0);
    }

    @Test
    public void testSearchUserRole() throws Exception {
        UserRole userRole = new UserRole();
        userRole.setUserId("demo");
        userRole.setRoleName("GUEST");

        List<UserRole> roleModuleList = userRoleDao.searchUserRole(userRole);
        logger.info(JSON.toJSONString(roleModuleList));
    }
}
