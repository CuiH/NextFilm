package com.xx.nextfilm.service;

import com.xx.nextfilm.dao.UserDao;
import com.xx.nextfilm.entity.UserEntity;
import com.xx.nextfilm.dto.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by CuiH on 2016/5/13.
 */
@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;


    // 两个boolean参数分别表示是否需要加载UserProfile、UserDetail，下同
    public UserEntity findUserById(Long id, boolean needProfile, boolean needDetail) {
        return dao.findById(id, needProfile, needDetail);
    }


    public UserEntity findUserByUsername(String username, boolean needProfile, boolean needDetail) {
        UserEntity user = dao.findByUsername(username, needProfile, needDetail);

        return user;
    }


    public void createUser(UserEntity user) {
        dao.doSave(user);
    }


    public void deleteUserByUsername(String username) {
        dao.deleteByUsername(username);
    }


    public List<UserEntity> findAllUsers(boolean needProfile, boolean needDetail) {
        return dao.findAll(needProfile, needDetail);
    }


    // 只是检查用户名是否唯一，无需加载UserDetail等
    public boolean isUsernameUnique(String username) {
        UserEntity user = findUserByUsername(username, false, false);

        return user == null;
    }


    public void updateUserLastLoginByUsername(String username, Date lastLogin) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = sdf.format(lastLogin);
        dao.updateSingleFieldByUsername(username, "last_login", str);
    }


    public void updateUserPasswordByUsername(String username, String newPassword) {
        dao.updateSingleFieldByUsername(username, "password", newPassword);
    }

}
