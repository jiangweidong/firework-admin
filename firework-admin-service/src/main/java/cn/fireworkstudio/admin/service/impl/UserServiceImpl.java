package cn.fireworkstudio.admin.service.impl;

import cn.fireworkstudio.admin.bean.*;
import cn.fireworkstudio.admin.constant.StringConstant;
import cn.fireworkstudio.admin.dao.LoginHistoryDao;
import cn.fireworkstudio.admin.dao.ModuleDao;
import cn.fireworkstudio.admin.dao.UserDao;
import cn.fireworkstudio.admin.dto.LoginReqDto;
import cn.fireworkstudio.admin.dto.LoginResDto;
import cn.fireworkstudio.admin.service.JwtService;
import cn.fireworkstudio.admin.service.UserService;
import cn.fireworkstudio.admin.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Copyright: 2016 FireworkStudio
 * *
 * Author:  Daniel Kong
 * Desc:    User Service
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private static final String ERR_USER_NOT_EXIST = "User not exist";
    private static final String ERR_PWD_WRONG = "Wrong password";
    private static final String ERR_FAIL_TO_CREATE_TOKEN = "Fail to create token";

    @Autowired
    private UserDao userDao;

    @Autowired
    private LoginHistoryDao loginHistoryDao;

    @Autowired
    private ModuleDao moduleDao;

    @Autowired
    private JwtService jwtService;

    /**
     * User Login
     *
     * @param reqDto Login request
     * @return Login result
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public LoginResDto login(LoginReqDto reqDto) {
        LoginResDto resDto = new LoginResDto();

        User queryUser = new User();
        queryUser.setUserId(reqDto.getUserId());
        queryUser.setValid(1);
        List<User> userList = userDao.searchUser(queryUser);

        if (userList == null)
            throw new RuntimeException(ERR_USER_NOT_EXIST);

        // As user_id is unique key, only one record found
        User findUser = userList.get(0);
        if (!findUser.getUserPwd().equals(reqDto.getPassword()))
            throw new RuntimeException(ERR_PWD_WRONG);

        // Create login history
        LoginHistory loginHistory = new LoginHistory();
        loginHistory.setUserId(reqDto.getUserId());
        loginHistory.setDeviceId(reqDto.getDeviceId());
        loginHistory.setPlatform(reqDto.getPlatform());
        loginHistoryDao.addLoginHistory(loginHistory);

        // Build system menus
        resDto.setMenuList(buildSystemMenus(reqDto.getUserId()));

        // Fill data into result dto
        resDto.setUserId(findUser.getUserId());
        resDto.setUserName(findUser.getUserName());
        resDto.setToken(generateAccessToken(reqDto, null));

        return resDto;
    }

    /**
     * Build system menus
     *
     * @param userId user id
     * @return system menus
     */
    private List<SysMenu> buildSystemMenus(String userId) {
        List<SysMenu> menuList = new ArrayList<SysMenu>();
        List<Module> modules = moduleDao.getModulesByUserId(userId);

        // construct layer1 menus
        if (modules != null && !modules.isEmpty()) {
            for (Module module : modules) {
                if (module.getParent() == null)
                    menuList.add(buildMenuFromModule(module));
            }

            // construct layer2 and layer3 menus
            for (SysMenu firstMenu : menuList) {
                buildSubMenu(firstMenu, modules);
                if (firstMenu.getSubMenus() != null) {
                    for (SysMenu secondMenu : firstMenu.getSubMenus())
                        buildSubMenu(secondMenu, modules);
                }
            }
        }
        return menuList;
    }

    /**
     * Build system menu from module
     *
     * @param module module
     * @return system menu
     */
    private SysMenu buildMenuFromModule(Module module) {
        SysMenu sysMenu = new SysMenu();
        sysMenu.setId(module.getId());
        sysMenu.setCode(module.getCode());
        sysMenu.setName(module.getName());
        sysMenu.setParent(module.getParent());
        sysMenu.setUrl(module.getUrl());
        sysMenu.setController(module.getController());
        sysMenu.setTemplate(module.getTemplate());
        sysMenu.setOrderId(module.getOrderId());
        return sysMenu;
    }

    /**
     * Build sub menus
     *
     * @param fatherMenu parent system menu
     * @param modules    modules
     */
    private void buildSubMenu(SysMenu fatherMenu, List<Module> modules) {
        fatherMenu.setSubMenus(new ArrayList<SysMenu>());
        for (Module module : modules) {
            if (module.getParent() != null && fatherMenu.getId() == module.getParent().longValue())
                fatherMenu.getSubMenus().add(buildMenuFromModule(module));
        }
    }

    /**
     * Generate token from login request and user role
     *
     * @param reqDto login request
     * @param role   user role
     * @return token generated
     */
    private String generateAccessToken(LoginReqDto reqDto, String role) {
        PlatformUser platformUser = new PlatformUser(reqDto.getUserId(), StringConstant.EMPTY_STRING,
                new ArrayList<GrantedAuthority>());
        platformUser.setDeviceId(reqDto.getDeviceId());
        platformUser.setPlatform(reqDto.getPlatform());
        platformUser.setRole(role);
        platformUser.setLoginTime(new Date().getTime());
        String token = jwtService.generateToken(platformUser);

        if (StringUtils.isEmpty(token))
            throw new RuntimeException(ERR_FAIL_TO_CREATE_TOKEN);
        return token;
    }
}
