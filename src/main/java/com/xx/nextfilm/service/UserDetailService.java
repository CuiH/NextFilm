package com.xx.nextfilm.service;

import com.xx.nextfilm.dto.editor.UserDetailEditor;
import com.xx.nextfilm.entity.UserDetailEntity;

/**
 * Created by CuiH on 2016/5/15.
 */
public interface UserDetailService {

    UserDetailEntity findUserDetailById(Long id);

    void updateUserDetail(UserDetailEntity userDetail, UserDetailEditor userDetailEditor);

    UserDetailEditor getUserDetailEditor(UserDetailEntity nowUserDetail);

}
