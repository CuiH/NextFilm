package com.xx.nextfilm.dto.editor;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * Created by CuiH on 2016/5/15.
 */
public class PasswordEditor {

    @NotEmpty
    String newPassword;


    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

}
