package com.xx.nextfilm.utils;

import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by CuiH on 2016/5/14.
 */
public class CustomRequiresCsrfMatcher implements RequestMatcher {

    private Pattern allowedMethods = Pattern.compile("^(GET|HEAD|TRACE|OPTIONS)$");

    private List<String> excludeUrls;

    public boolean matches(HttpServletRequest request) {
        if (excludeUrls != null && excludeUrls.size() > 0) {
            String servletPath = request.getServletPath();
            for (String url : excludeUrls) {
                if (servletPath.contains(url)) {
                    return false;
                }
            }
        }
        return !allowedMethods.matcher(request.getMethod()).matches();
    }

    public List<String> getExcludeUrls() {
        return excludeUrls;
    }

    public void setExcludeUrls(List<String> excludeUrls) {
        this.excludeUrls = excludeUrls;
    }

}
