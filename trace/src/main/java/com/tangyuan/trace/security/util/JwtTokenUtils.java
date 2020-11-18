package com.tangyuan.trace.security.util;

import com.tangyuan.trace.dal.dto.UserInfo;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;

import java.io.Serializable;
import java.util.*;

import static com.tangyuan.constants.AuthConstant.*;

/**
 * JWT工具类
 */
public class JwtTokenUtils implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * @param authentication
     * @return
     */
    public static String generateToken(Authentication authentication) {
        Map<String, Object> claims = new HashMap<>(5);
        UserInfo userInfo = SecurityUtils.getUsername(authentication);
        UserInfo.SessionInfo sessionInfo = userInfo.getSessionInfo();
        claims.put(USERNAME, userInfo.getName());
        claims.put(OPEN_ID, sessionInfo.getOpenId());
        claims.put(CREATED, new Date());
        claims.put(AUTHORITY_CLAIM_NAME, authentication.getAuthorities());
        return generateToken(claims);
    }

    public static String generateToken(UserInfo sysEmployeeEntity) {
        Map<String, Object> claims = new HashMap<>(5);
        claims.put(USERNAME, sysEmployeeEntity.getName());
        claims.put(USER_ID, sysEmployeeEntity.getName());
        claims.put(CREATED, new Date());
        return generateToken(claims);
    }

    /**
     * 从数据声明生成令牌
     *
     * @param claims 数据声明
     * @return 令牌
     */
    private static String generateToken(Map<String, Object> claims) {
        Date expirationDate = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        return Jwts.builder().setClaims(claims).setExpiration(expirationDate).signWith(SignatureAlgorithm.HS512, SECRET).compact();
    }

}