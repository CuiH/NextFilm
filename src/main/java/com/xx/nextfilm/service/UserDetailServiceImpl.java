package com.xx.nextfilm.service;

import com.xx.nextfilm.dao.UserDetailDao;
import com.xx.nextfilm.dto.UserDetailEditor;
import com.xx.nextfilm.entity.UserDetailEntity;
import com.xx.nextfilm.utils.ConverterUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        userDetail.setBirthday(ConverterUtils.convertStringToDate(userDetailEditor.getBirthday()));
        userDetail.setGender(ConverterUtils.convertGenderToString(userDetailEditor.getGender()));
        userDetail.setCityCode(ConverterUtils.convertCityToCityCode(userDetailEditor.getCity()));

        dao.doUpdate(userDetail);
    }

    public UserDetailEditor getUserDetailEditor(UserDetailEntity nowUserDetail) {
        UserDetailEditor userDetailEditor = new UserDetailEditor();

        userDetailEditor.setFirstName(nowUserDetail.getFirstName());
        userDetailEditor.setLastName(nowUserDetail.getLastName());
        userDetailEditor.setBirthday(ConverterUtils.convertDateToString(nowUserDetail.getBirthday()));
        userDetailEditor.setGender(ConverterUtils.convertStringToGender(nowUserDetail.getGender()));
        userDetailEditor.setCity(ConverterUtils.convertCityCodeToCity(nowUserDetail.getCityCode()));

        return userDetailEditor;
    }

}
