package cn.fireworkstudio.admin.dao;

import cn.fireworkstudio.admin.bean.LoginHistory;
import cn.fireworkstudio.admin.enums.Platform;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertTrue;

/**
 * Copyright: 2016 FireworkStudio
 * *
 * Author:  Daniel Kong
 * Desc:    Test Case Of LoginHistoryDao
 */
@ContextConfiguration(locations = {"classpath:/config/test-spring-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestLoginHistoryDao {

    private static final Logger logger = LoggerFactory.getLogger(TestLoginHistoryDao.class);

    @Autowired
    private LoginHistoryDao loginHistoryDao;

    @Test
    public void testAddLoginHistory() throws Exception {
        LoginHistory loginHistory = new LoginHistory();
        loginHistory.setUserId("demo");
        loginHistory.setDeviceId("910214021");
        loginHistory.setPlatform(Platform.ANDROID.getName());
        assertTrue(loginHistoryDao.addLoginHistory(loginHistory) > 0);
    }
}
