package cn.fireworkstudio.admin.security.filter;

import cn.fireworkstudio.admin.security.bean.JwtAuthenticationToken;
import cn.fireworkstudio.admin.security.util.JwtTokenMissingException;
import cn.fireworkstudio.admin.util.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Copyright: 2016 FireworkStudio
 * *
 * Author:  Daniel Kong
 * Desc:    Spring security authentication filter
 */
public class FireworkAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private static final String USER_LOGIN = "/user/login";
    private static final String HEADER_AUTHORIZATION = "Authorization";
    private static final String BEARER_PREFIX = "Bearer ";

    /**
     * constructor
     */
    public FireworkAuthenticationFilter() {
        super("/**");
    }

    /**
     * Require authentication or not
     */
    @Override
    protected boolean requiresAuthentication(HttpServletRequest request, HttpServletResponse response) {
        return true;
    }

    /**
     * Authentication logic
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException {

        boolean isLogin = StringUtils.getValidString(request.getRequestURI()).contains(USER_LOGIN);

        //If user login, check id and password
        if (isLogin) {
            return new UsernamePasswordAuthenticationToken(null, null);
        }

        //Get JwtToken
        String header = request.getHeader(HEADER_AUTHORIZATION);
        if (header == null || !header.startsWith(BEARER_PREFIX))
            throw new JwtTokenMissingException("Invalid authentication");

        String authToken = header.substring(7);
        JwtAuthenticationToken authRequest = new JwtAuthenticationToken(authToken);

        return getAuthenticationManager().authenticate(authRequest);
    }

    /**
     * Pass authentication
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
        chain.doFilter(request, response);
    }
}
