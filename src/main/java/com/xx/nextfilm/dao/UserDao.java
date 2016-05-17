package com.xx.nextfilm.dao;

import com.xx.nextfilm.entity.UserEntity;

import java.util.List;

/**
 * Created by CuiH on 2016/5/13.
 */
public interface UserDao {

    UserEntity findById(Long id, boolean needProfile, boolean needDetail);

    UserEntity findByUsername(String username, boolean needProfile, boolean needDetail);

    void updateSingleFieldByUsername(String username, String field, String content);

    void doSave(UserEntity user);

    void doUpdate(UserEntity user);

    void deleteByUsername(String username);

    List<UserEntity> findAll(boolean needProfile, boolean needDetail);

}
