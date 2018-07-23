package com.epam.andrei_sterkhov.online_shop.interceptor;

import com.epam.andrei_sterkhov.online_shop.dto.User;
import com.epam.andrei_sterkhov.online_shop.service.SessionUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

public class AuthInterceptor implements HandlerInterceptor {

    @Autowired
    private SessionUserService sessionUserService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        User user = sessionUserService.getCurrentSessionUser();

        if (Objects.isNull(user)) {
            response.sendRedirect("/login");
            return false;
        }
        request.setAttribute("currentUser", user);
        return true;
    }
}