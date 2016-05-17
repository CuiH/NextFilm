package com.xx.nextfilm.service;

import com.xx.nextfilm.dao.UserDetailDao;
import com.xx.nextfilm.dto.UserDetailEditor;
import com.xx.nextfilm.entity.UserDetailEntity;
import com.xx.nextfilm.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by CuiH on 2016/5/15.
 */
@Transactional
@Service("userDetailService")
public class UserDetailServiceImpl implements UserDetailService {

    @Autowired
    private UserDetailDao dao;


    public UserDetailEntity findUserDetailById(Long id) {
        return dao.findById(id);
    }


    public void updateUserDetail(UserDetailEntity userDetail, UserDetailEditor userDetailEditor) {
        userDetail.setFirstName(userDetailEditor.getFirstName());
        userDetail.setLastName(userDetailEditor.getLastName());
        userDetail.setBirthday(Utils.convertStringToDate(userDetailEditor.getBirthday()));
        userDetail.setGender(Utils.convertGenderToString(userDetailEditor.getGender()));

        dao.doUpdate(userDetail);
    }

}
