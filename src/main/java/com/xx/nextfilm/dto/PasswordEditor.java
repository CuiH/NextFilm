package com.xx.nextfilm.dto;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * Created by CuiH on 2016/5/15.
 */
public class PasswordEditor implements Serializable {

    @NotEmpty
    String newPassword;


    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

}
