package com.xx.nextfilm.controller;

import com.xx.nextfilm.entity.CustomUserInfo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by CuiH on 2016/5/14.
 */
@Controller
public class MainController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(ModelMap modelMap) {
        String username = getCurrentUsername();
        modelMap.addAttribute("username", username);

        return "home";
    }


    public String getCurrentUsername() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof CustomUserInfo) {
            return ((CustomUserInfo) principal).getUserEntity().getUsername();
        } else {
            return null;
        }
    }
//    public String getCurrentUsername() {
//        return SecurityContextHolder.getContext().getAuthentication().getName();
//    }

}
