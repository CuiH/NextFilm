package com.xx.nextfilm.service;

import com.xx.nextfilm.entity.UserEntity;
import com.xx.nextfilm.dto.editor.Visitor;

import java.util.Date;
import java.util.List;

/**
 * Created by CuiH on 2016/5/13.
 */
public interface UserService {

    UserEntity findUserById(Long id, boolean needProfile, boolean needDetail);

    UserEntity findUserByUsername(String username, boolean needProfile, boolean needDetail);

    void createUser(Visitor visitor);

    void deleteUserByUsername(String username);

    void updateUserPasswordByUsername(String username, String newPassword);

    void updateUserLastLoginByUsername(String username, Date lastLogin);

    List<UserEntity> findAllUsers(boolean needProfile, boolean needDetail);

    boolean isUsernameUnique(String username);

}
