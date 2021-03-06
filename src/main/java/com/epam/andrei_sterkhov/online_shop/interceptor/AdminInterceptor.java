package com.epam.andrei_sterkhov.online_shop.interceptor;

import com.epam.andrei_sterkhov.online_shop.dto.User;
import com.epam.andrei_sterkhov.online_shop.dto.Role;
import com.epam.andrei_sterkhov.online_shop.service.SessionUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;
import java.util.Optional;

public class AdminInterceptor implements HandlerInterceptor {

    @Autowired
    private SessionUserService sessionUserService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        User user = sessionUserService.getCurrentSessionUser();

        Optional<String> client = user.getRoles().stream().map(Role::getName).filter(a -> Objects.equals(a, "client")).findFirst();
        if (client.isPresent()) {
            response.sendRedirect("/client");
            return false;
        }

        return true;
    }
}