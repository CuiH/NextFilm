package com.xx.nextfilm.service;

import com.xx.nextfilm.entity.UserProfileEntity;

import java.util.List;

/**
 * Created by CuiH on 2016/5/13.
 */
public interface UserProfileService {

    UserProfileEntity findUserProfileById(Long id);

    UserProfileEntity findUserProfileByRole(String role);

    List<UserProfileEntity> findAllUserProfiles();

}
