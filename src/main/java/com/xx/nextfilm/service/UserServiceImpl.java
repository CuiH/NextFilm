package com.xx.nextfilm.service;

import com.xx.nextfilm.dao.UserDao;
import com.xx.nextfilm.dao.UserDetailDao;
import com.xx.nextfilm.dao.UserProfileDao;
import com.xx.nextfilm.entity.UserDetailEntity;
import com.xx.nextfilm.entity.UserEntity;
import com.xx.nextfilm.dto.Visitor;
import com.xx.nextfilm.entity.UserProfileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by CuiH on 2016/5/13.
 */
@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserProfileDao userProfileDao;

    @Autowired
    private UserDetailDao userDetailDao;


    // 两个boolean参数分别表示是否需要加载UserProfile、UserDetail，下同
    public UserEntity findUserById(Long id, boolean needProfile, boolean needDetail) {
        return userDao.findById(id, needProfile, needDetail);
    }


    public UserEntity findUserByUsername(String username, boolean needProfile, boolean needDetail) {
        UserEntity user = userDao.findByUsername(username, needProfile, needDetail);

        return user;
    }


    public void createUser(Visitor visitor) {
        UserEntity newUser = new UserEntity();
        newUser.setUsername(visitor.getUsername());
        newUser.setPassword(visitor.getPassword());

        Date now = new Date();
        newUser.setCreateTime(now);
        newUser.setLastLogin(now);

        // 注册用户为ROLE_USER组
        UserProfileEntity userProfile = userProfileDao.findByRole("ROLE_USER");
        List<UserProfileEntity> userProfiles = new ArrayList<UserProfileEntity>();
        userProfiles.add(userProfile);
        newUser.setUserProfiles(userProfiles);

        userDao.doSave(newUser);

        // 同时生成UserProfile
        UserDetailEntity userDetail = new UserDetailEntity();
        userDetail.setId(newUser.getId());
        userDetailDao.doSave(userDetail);
    }


    public void deleteUserByUsername(String username) {
        userDao.deleteByUsername(username);
    }


    public List<UserEntity> findAllUsers(boolean needProfile, boolean needDetail) {
        return userDao.findAll(needProfile, needDetail);
    }


    public boolean isUsernameUnique(String username) {
        UserEntity user = findUserByUsername(username, false, false);

        return user == null;
    }


    public void updateUserLastLoginByUsername(String username, Date lastLogin) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = sdf.format(lastLogin);
        userDao.updateSingleFieldByUsername(username, "last_login", str);
    }


    public void updateUserPasswordByUsername(String username, String newPassword) {
        userDao.updateSingleFieldByUsername(username, "password", newPassword);
    }


}
