package cn.fireworkstudio.admin.security.auth;

import cn.fireworkstudio.admin.bean.PlatformUser;
import cn.fireworkstudio.admin.security.bean.JwtAuthenticationToken;
import cn.fireworkstudio.admin.security.util.JwtTokenMalformedException;
import cn.fireworkstudio.admin.service.JwtService;
import cn.fireworkstudio.admin.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 * Copyright: 2016 FireworkStudio
 * *
 * Author:  Daniel Kong
 * Desc:    Security authentication provider
 */
@Component
public class FireworkAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @Autowired
    private JwtService jwtService;

    private static final String ERR_INVALID_AUTH = "Invalid authentication info";

    @Override
    public boolean supports(Class<?> authentication) {
        return (JwtAuthenticationToken.class.isAssignableFrom(authentication));
    }

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) authentication;
        String token = jwtAuthenticationToken.getToken();

        PlatformUser user = jwtService.parseToken(token);
        if (user == null || StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPlatform()))
            throw new JwtTokenMalformedException(ERR_INVALID_AUTH);
        return user;
    }
}
