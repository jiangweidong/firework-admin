package cn.fireworkstudio.admin.security.auth;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Copyright: 2016 FireworkStudio
 * *
 * Author:  Daniel Kong
 * Desc:    Security access deny handler
 */
@Component
public class FireworkAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        e.printStackTrace();
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().print("{\"code\":\"0\", \"msg\":\"Access blocked\", \"data\":\"\"}");
        response.getWriter().flush();
    }
}
