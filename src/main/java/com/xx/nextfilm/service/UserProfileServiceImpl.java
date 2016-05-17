package com.xx.nextfilm.service;

import com.xx.nextfilm.dao.UserProfileDao;
import com.xx.nextfilm.entity.UserProfileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by CuiH on 2016/5/13.
 */
@Transactional
@Service("userProfileService")
public class UserProfileServiceImpl implements UserProfileService  {

    @Autowired
    private UserProfileDao dao;


    public UserProfileEntity findUserProfileById(Long id) {
        return dao.findById(id);
    }


    public UserProfileEntity findUserProfileByRole(String role) {
        return dao.findByRole(role);
    }


    public List<UserProfileEntity> findAllUserProfiles() {
        return dao.findAll();
    }

}

