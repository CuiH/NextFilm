package com.xx.nextfilm.controller.back;

import com.xx.nextfilm.entity.CustomUserInfo;
import com.xx.nextfilm.exception.UserNotLoginException;
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
        String username = MainController.getCurrentUsername();
        modelMap.addAttribute("username", username);

        return "home";
    }


    public static String getCurrentUsername() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof CustomUserInfo) {

            return ((CustomUserInfo) principal).getUserEntity().getUsername();
        } else {
            throw new UserNotLoginException();
        }
    }

}
