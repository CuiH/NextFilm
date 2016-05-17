package com.xx.nextfilm.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * Created by CuiH on 2016/5/15.
 * 自定义User，用于spring security的登陆，可以存储更多用户信息（整个UserEntity）
 */
public class CustomUserInfo extends User {

    private static final long serialVersionUID = -25559580612205393L;

    private UserEntity userEntity;


    public CustomUserInfo(UserEntity userEntity, String username, String password, boolean enabled,
                          boolean accountNonExpired, boolean credentialsNonExpired,
                          boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.userEntity = userEntity;
    }


    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

}
