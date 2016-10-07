package cn.fireworkstudio.admin.controller;

import cn.fireworkstudio.admin.dto.LoginReqDto;
import cn.fireworkstudio.admin.dto.LoginResDto;
import cn.fireworkstudio.admin.service.UserService;
import cn.fireworkstudio.admin.util.RespJson;
import cn.fireworkstudio.admin.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright: 2016 FireworkStudio
 * *
 * Author:  Daniel Kong
 * Desc:    User controller
 */
@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private static final String ERR_ID_PASSWORD_EMPTY = "UserId/Password should not be empty";

    @Autowired
    private UserService userService;

    /**
     * User login api
     *
     * @param reqDto Login request
     * @return login response
     */
    @RequestMapping(value = "/user/login", method = RequestMethod.POST, headers = {
            "Accept=application/json; charset=UTF-8", "Content-Type=application/json"})
    public RespJson userLogin(@RequestBody LoginReqDto reqDto) {
        if (reqDto == null || StringUtils.isEmpty(reqDto.getUserId())
                || StringUtils.isEmpty(reqDto.getPassword())) {
            return RespJson.buildFailureResponse(ERR_ID_PASSWORD_EMPTY);
        }
        try {
            LoginResDto resDto = userService.login(reqDto);
            return RespJson.buildSuccessResponse(resDto);
        } catch (Exception e) {
            logger.error("Login Failed: " + StringUtils.getValidString(e.getMessage()));
            return RespJson.buildFailureResponse(StringUtils.getValidString(e.getMessage()));
        }
    }
}
