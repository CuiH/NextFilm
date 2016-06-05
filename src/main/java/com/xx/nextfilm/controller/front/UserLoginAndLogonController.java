package com.xx.nextfilm.controller.front;

import com.xx.nextfilm.controller.back.MainController;
import com.xx.nextfilm.exception.UserNotLoginException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by CuiH on 2016/5/30.
 */
@Controller
public class UserLoginAndLogonController {

    @ResponseBody
    @RequestMapping(value = "/is_login", method = RequestMethod.GET)
    public String isLogin(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");

        try {
            String username = MainController.getCurrentUsername();

            return "{\"result\": \"success\", \"data\":\"" + username + "\"}";
        } catch (UserNotLoginException e) {

            return "{\"result\": \"fail\", \"reason\": \"not login\"}";
        }

    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String main() {
        return "nextfilm/login";
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String home() {
        return "nextfilm/main";
    }

    @RequestMapping(value = "/film", method = RequestMethod.GET)
    public String view_film() {
        return "nextfilm/film_detail";
    }

    @RequestMapping(value = "/reservation", method = RequestMethod.GET)
    public String view_reservation() {
        return "nextfilm/all_reservation";
    }

}
