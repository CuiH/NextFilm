package com.xx.nextfilm.controller.back;

import com.xx.nextfilm.service.UserService;
import com.xx.nextfilm.dto.editor.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by CuiH on 2016/4/28.
 */
@Controller
public class LoginController {

    @Autowired
    UserService userService;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @ResponseBody
    @RequestMapping(value = "/login_fail", method = RequestMethod.GET)
    public String loginFail() {
        return "{\"result\": \"fail\", \"reason\": \"wrong username or password\"}";
    }

    @ResponseBody
    @RequestMapping(value = "/login_success", method = RequestMethod.GET)
    public String loginSuccess() {
        return "{\"result\": \"success\", \"reason\": \"no content\"}";
    }

}
