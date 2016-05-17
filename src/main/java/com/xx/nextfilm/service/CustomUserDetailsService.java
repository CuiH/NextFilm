package com.xx.nextfilm.service;

import com.xx.nextfilm.dao.UserDao;
import com.xx.nextfilm.entity.CustomUserInfo;
import com.xx.nextfilm.entity.UserEntity;
import com.xx.nextfilm.entity.UserProfileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by CuiH on 2016/5/14.
 */
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDao dao;


    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        // 登陆的时候将UserDetail一并加载存入session，后面可以直接取用
        UserEntity user = dao.findByUsername(username, true, true);
        if (user == null) throw new UsernameNotFoundException("username " + username + "not found.");

        List<GrantedAuthority> authorities = buildUserAuthority(user.getUserProfiles());

        return buildUserForAuthentication(user, authorities);
    }


    private User buildUserForAuthentication(UserEntity user,
                                            List<GrantedAuthority> authorities) {
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        return new CustomUserInfo(
                user,
                user.getUsername(),
                user.getPassword(),
                enabled,
                accountNonExpired,
                credentialsNonExpired,
                accountNonLocked,
                authorities
        );
    }


    private List<GrantedAuthority> buildUserAuthority(List<UserProfileEntity> userProfiles) {
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();

        for (UserProfileEntity userProfile: userProfiles) {
            authorities.add(new SimpleGrantedAuthority(userProfile.getRole()));
        }

        List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(authorities);

        return Result;
    }

}
