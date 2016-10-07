package cn.fireworkstudio.admin.security.auth;

import cn.fireworkstudio.admin.enums.ResponseCode;
import cn.fireworkstudio.admin.security.util.UserAuthenticationException;
import cn.fireworkstudio.admin.util.StringUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Copyright: 2016 FireworkStudio
 * *
 * Author:  Daniel Kong
 * Desc:    Security authentication failure handler
 */
@Component
public class FireworkAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        e.printStackTrace();

        String resultCode = ResponseCode.FAILURE.getCode();
        if(e instanceof UserAuthenticationException)
            resultCode = ((UserAuthenticationException) e).getResultCode();

        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().print("{\"code\":\"" + resultCode + "\", \"msg\":\"" + StringUtils.getValidString(e.getMessage()) + "\", \"data\":null}");
        response.getWriter().flush();
    }
}
