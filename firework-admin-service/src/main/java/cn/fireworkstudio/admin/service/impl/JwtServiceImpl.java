package cn.fireworkstudio.admin.service.impl;

import cn.fireworkstudio.admin.bean.PlatformUser;
import cn.fireworkstudio.admin.constant.StringConstant;
import cn.fireworkstudio.admin.service.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Copyright: 2016 FireworkStudio
 * *
 * Author:  Daniel Kong
 * Desc:    Json web token service
 */
@Service("jwtService")
public class JwtServiceImpl implements JwtService {

    @Value("${jwt.secret}")
    private String secret;

    private static final String DEVICE_ID = "deviceId";
    private static final String PLATFORM = "platform";
    private static final String ROLE = "role";
    private static final String LOGIN_TIME = "loginTime";

    /**
     * Generate json web token from platform user object
     *
     * @param user platform user object
     * @return token
     */
    @Override
    public String generateToken(PlatformUser user) {
        Claims claims = Jwts.claims().setSubject(user.getUsername());
        claims.put(DEVICE_ID, user.getDeviceId());
        claims.put(PLATFORM, user.getPlatform());
        claims.put(ROLE, user.getRole());
        claims.put(LOGIN_TIME, user.getLoginTime());
        return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    /**
     * Parse platform user object from json web token
     *
     * @param token Json Web Token
     * @return PlatformUser object
     */
    @Override
    public PlatformUser parseToken(String token) {
        try {
            Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
            String role = (String) body.get(ROLE);
            List<GrantedAuthority> authorityList = AuthorityUtils.commaSeparatedStringToAuthorityList(role);
            PlatformUser user = new PlatformUser(body.getSubject(), StringConstant.EMPTY_STRING, authorityList);
            user.setDeviceId((String) body.get(DEVICE_ID));
            user.setPlatform((String) body.get(PLATFORM));
            user.setRole(role);
            user.setLoginTime((Long) body.get(LOGIN_TIME));
            return user;
        } catch (Exception e) {
            return null;
        }
    }
}
