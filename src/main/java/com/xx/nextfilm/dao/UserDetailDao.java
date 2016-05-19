package com.xx.nextfilm.dao;

import com.xx.nextfilm.entity.UserDetailEntity;

import java.util.List;

/**
 * Created by CuiH on 2016/5/15.
 */
public interface UserDetailDao {

    UserDetailEntity findById(Long id);

    void doUpdate(UserDetailEntity userDetail);

    void doSave(UserDetailEntity userDetail);

}
