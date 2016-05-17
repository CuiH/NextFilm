package com.xx.nextfilm.controller;

import com.xx.nextfilm.service.UserService;
import com.xx.nextfilm.dto.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by CuiH on 2016/4/28.
 */
@Controller
public class LoginController {

    @Autowired
    UserService userService;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap modelMap) {
        Visitor visitor = new Visitor();
        modelMap.addAttribute("visitor", visitor);

        return "login";
    }

}
