package com.xx.nextfilm.handler;

import com.xx.nextfilm.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by CuiH on 2016/5/14.
 */
public class CustomAuthenticationSuccessHandler extends
        SavedRequestAwareAuthenticationSuccessHandler {

    private static final Logger LOG = LogManager.getLogger("com.xx.nextfilm");

    @Autowired
    UserService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException,ServletException {
        // 保存登陆时间
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        Date now = new Date();
        userService.updateUserLastLoginByUsername(userName, now);

        LOG.info(userName + " : login");

        super.onAuthenticationSuccess(request, response, authentication);
    }

}
