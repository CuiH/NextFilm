package com.xx.nextfilm.controller.back;

import com.xx.nextfilm.entity.UserEntity;
import com.xx.nextfilm.exception.UserNotLoginException;
import com.xx.nextfilm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String frontLogin() {
        return "nextfilm/login";
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
