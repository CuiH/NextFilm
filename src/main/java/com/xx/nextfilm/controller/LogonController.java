package com.xx.nextfilm.controller;

import com.xx.nextfilm.service.UserService;
import com.xx.nextfilm.dto.editor.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Locale;

/**
 * Created by CuiH on 2016/5/14.
 */
@Controller
public class LogonController {

    @Autowired
    UserService userService;

    @Autowired
    MessageSource messageSource;

    @Autowired
    protected AuthenticationManager authenticationManager;


    @RequestMapping(value = "/logon", method = RequestMethod.GET)
    public String logon(ModelMap modelMap) {
        Visitor visitor = new Visitor();
        modelMap.addAttribute("visitor", visitor);

        return "logon";
    }


    @RequestMapping(value = "/logon", method = RequestMethod.POST)
    public String logonHandler(@Valid Visitor visitor, BindingResult result, HttpServletRequest request) {
        if (result.hasErrors()) {

            return "logon";
        }

        if (!userService.isUsernameUnique(visitor.getUsername())) {        // 用户名唯一
            FieldError usernameError = new FieldError("visitor", "username",
                    messageSource.getMessage("CH.unique.username",
                            new String[]{visitor.getUsername()}, Locale.getDefault()));
            result.addError(usernameError);

            return "logon";
        } else {
            userService.createUser(visitor);

            // 注册成功后自动登录
            authenticateUserAndSetSession(visitor, request);

            return "redirect:/home";
        }
    }


    // 自动登录
    private void authenticateUserAndSetSession(Visitor visitor, HttpServletRequest request) {
        String username = visitor.getUsername();
        String password = visitor.getPassword();
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);

        // generate session if one doesn't exist
        request.getSession();

        token.setDetails(new WebAuthenticationDetails(request));
        Authentication authenticatedUser = authenticationManager.authenticate(token);

        SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
    }

}
