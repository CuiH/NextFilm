package com.xx.nextfilm.dao;

import com.xx.nextfilm.entity.UserProfileEntity;

import java.util.List;

/**
 * Created by CuiH on 2016/5/13.
 */
public interface UserProfileDao {

    List<UserProfileEntity> findAll();

    UserProfileEntity findByRole(String role);

    UserProfileEntity findById(Long id);

}

