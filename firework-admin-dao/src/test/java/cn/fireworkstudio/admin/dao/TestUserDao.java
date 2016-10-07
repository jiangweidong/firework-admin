package cn.fireworkstudio.admin.dao;

import cn.fireworkstudio.admin.bean.User;
import cn.fireworkstudio.admin.constant.StringConstant;
import cn.fireworkstudio.admin.enums.Gender;
import cn.fireworkstudio.admin.util.MD5Utils;
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
 * Desc:    Test Case Of UserDao
 */
@ContextConfiguration(locations = {"classpath:/config/test-spring-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestUserDao {

    private static final Logger logger = LoggerFactory.getLogger(TestUserDao.class);

    @Autowired
    private UserDao userDao;

    @Test
    public void testAddUser() throws Exception {
        User user = new User();
        user.setUserId("demo");
        user.setUserPwd(MD5Utils.MD5("demo"));
        user.setUserName("demo");
        user.setGender(Gender.MALE.getCode());
        user.setIdNumber("310000198511050000");
        user.setMobile("13111111111");
        user.setEmail("demo@gmail.com");
        user.setZip("210000");
        user.setAddress("Nanjing, Jiangsu Province, China");
        user.setValid(1);
        user.setCreateUser(StringConstant.SYSTEM);
        assertTrue(userDao.addUser(user) > 0);
    }

    @Test
    public void testSearchUser() throws Exception {
        User user = new User();
        user.setUserId("demo");
        user.setUserPwd(MD5Utils.MD5("demo"));
        user.setValid(1);

        List<User> userList = userDao.searchUser(user);
        logger.info(JSON.toJSONString(userList));
    }
}
