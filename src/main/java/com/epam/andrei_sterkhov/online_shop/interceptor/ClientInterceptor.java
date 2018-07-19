package com.epam.andrei_sterkhov.online_shop.interceptor;

import com.epam.andrei_sterkhov.online_shop.dto.User;
import com.epam.andrei_sterkhov.online_shop.enums.Role;
import com.epam.andrei_sterkhov.online_shop.service.SessionUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClientInterceptor implements HandlerInterceptor {

    @Autowired
    private SessionUserService sessionUserService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        User user = sessionUserService.getCurrentSessionUser();

        if (user.getRole() == Role.ADMIN) {
            response.sendRedirect("/admin");
            return false;
        }

        return true;
    }
}