package com.tangyuan.trace.security;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * 安全用户模型
 */
@Getter
@Setter
public class JwtUserDetails extends User {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String openId;


    public JwtUserDetails(Integer id, String openId, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        this(id, openId, username, password, true, true, true, true, authorities);
    }

    public JwtUserDetails(Integer id, String openId, String nickName, String password) {
        this(id, openId, nickName, password, true, true, true, true, null);
    }

    public JwtUserDetails(Integer id, String openId, String username, String password, boolean enabled, boolean accountNonExpired,
                          boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.id = id;
        this.openId = openId;
    }



}