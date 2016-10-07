package cn.fireworkstudio.admin.security.auth;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Copyright: 2016 FireworkStudio
 * *
 * Author:  Daniel Kong
 * Desc:    Security authentication entry point
 */
@Component
public class FireworkAuthenticationEntryPoint extends Http403ForbiddenEntryPoint {

    private static final String ERR_AUTH_FAILED = "Fail to pass authentication";

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, ERR_AUTH_FAILED);
    }
}
