package cn.fireworkstudio.admin.dao;

import cn.fireworkstudio.admin.bean.Module;
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
 * Desc:    Test Case Of ModuleDao
 */
@ContextConfiguration(locations = {"classpath:/config/test-spring-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestModuleDao {

    private static final Logger logger = LoggerFactory.getLogger(TestModuleDao.class);

    @Autowired
    private ModuleDao moduleDao;

    @Test
    public void testAddModule() throws Exception {
        Module module = new Module();
        module.setCode("code");
        module.setName("name");
        module.setParent(null);
        module.setUrl("#");
        module.setController("dashboardController");
        module.setTemplate("views/common/dashboard.html");
        module.setOrderId(1);
        module.setValid(1);
        module.setCreateUser(StringConstant.SYSTEM);
        assertTrue(moduleDao.addModule(module) > 0);
    }

    @Test
    public void testSearchUser() throws Exception {
        Module module = new Module();
        module.setCode("code");

        List<Module> moduleList = moduleDao.searchModule(module);
        logger.info(JSON.toJSONString(moduleList));
    }

    @Test
    public void testGetModulesByUserId() throws Exception {
        List<Module> moduleList = moduleDao.getModulesByUserId("demo");
        logger.info(JSON.toJSONString(moduleList));
    }
}
