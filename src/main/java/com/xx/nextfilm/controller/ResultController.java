package com.xx.nextfilm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by CuiH on 2016/5/15.
 */
@Controller
public class ResultController {

    @RequestMapping(value = "/fail", method = RequestMethod.GET)
    public String fail() {
        return "fail";
    }

    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public String success() {
        return "success";
    }

}
