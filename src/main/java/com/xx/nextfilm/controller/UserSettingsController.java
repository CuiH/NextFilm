package com.xx.nextfilm.controller;

import com.xx.nextfilm.dto.UserDetailEditor;
import com.xx.nextfilm.dto.PasswordEditor;
import com.xx.nextfilm.entity.CustomUserInfo;
import com.xx.nextfilm.entity.UserDetailEntity;
import com.xx.nextfilm.entity.UserEntity;
import com.xx.nextfilm.service.UserDetailService;
import com.xx.nextfilm.service.UserService;
import com.xx.nextfilm.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Date;
import java.util.Locale;

/**
 * Created by CuiH on 2016/5/15.
 */
@Controller
public class UserSettingsController {

    @Autowired
    UserService userService;

    @Autowired
    UserDetailService userDetailService;

    @Autowired
    MessageSource messageSource;


    // 改密码
    @RequestMapping(value = "/change_password", method = RequestMethod.GET)
    public String changePassword(ModelMap modelMap) {
        PasswordEditor passwordEditor = new PasswordEditor();
        modelMap.addAttribute(passwordEditor);

        return "change_password";
    }

    @RequestMapping(value = "/change_password", method = RequestMethod.POST)
    public String changePasswordHandler(@Valid PasswordEditor passwordEditor, BindingResult result) {
        if (result.hasErrors()) {
            return "change_password";
        }

        userService.updateUserPasswordByUsername(getCurrentUser().getUsername(), passwordEditor.getNewPassword());

        return "redirect:/success";
    }


    //　改UserDetail
    @RequestMapping(value = "/edit_detail", method = RequestMethod.GET)
    public String editDetail(ModelMap modelMap) {
        UserEntity nowUser = getCurrentUser();
        if (nowUser == null) {
            return "redirect:/fail";
        }

        UserDetailEntity nowUserDetail = nowUser.getUserDetail();

        // 表明误删除了数据库条目，因为UserDetail是随User一起创建的
        if (nowUserDetail == null) {
            return "redirect:/fail";
        }

        UserDetailEditor userDetailEditor = userDetailService.getUserDetailEditor(nowUserDetail);
        modelMap.addAttribute(userDetailEditor);

        return "edit_detail";
    }

    @RequestMapping(value = "/edit_detail", method = RequestMethod.POST)
    public String editDetailHandler(UserDetailEditor userDetailEditor, BindingResult result) {
        if (result.hasErrors()) {
            return "edit_detail";
        }

        // 检查birthday是否合法
        String birthday = userDetailEditor.getBirthday();
        if (birthday != null && !"".equals(birthday)){
            if (!Utils.isDateValid(birthday)) {
                FieldError birthdayError = new FieldError("userDetailEditor", "birthday",
                        messageSource.getMessage("CH.invalid.birthday", null, Locale.getDefault()));
                result.addError(birthdayError);

                return "edit_detail";
            }
        }

        UserEntity nowUser = getCurrentUser();
        if (nowUser == null) {
            return "redirect:/fail";
        }

        UserDetailEntity nowUserDetail = nowUser.getUserDetail();

        // 表明误删除了数据库条目，因为UserDetail是随User一起创建的
        if (nowUserDetail == null) {
            return "redirect:/fail";
        }

        userDetailService.updateUserDetail(nowUserDetail, userDetailEditor);

        return "redirect:/success";
    }


    @ModelAttribute("genders")
    public String[] initializeGenders() {
        return new String[]{"男", "女", "保密"};
    }


    public UserEntity getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof CustomUserInfo) {
            return ((CustomUserInfo) principal).getUserEntity();
        } else {
            return null;
        }
    }

}
