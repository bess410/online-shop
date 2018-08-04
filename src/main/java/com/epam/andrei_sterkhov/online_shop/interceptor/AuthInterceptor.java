package com.epam.andrei_sterkhov.online_shop.interceptor;

import com.epam.andrei_sterkhov.online_shop.dto.User;
import com.epam.andrei_sterkhov.online_shop.service.SessionUserService;
import com.epam.andrei_sterkhov.online_shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;
import java.util.Optional;

public class AuthInterceptor implements HandlerInterceptor {

    @Autowired
    private SessionUserService sessionUserService;

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        User user = sessionUserService.getCurrentSessionUser();

        if (Objects.isNull(user)) {
            response.sendRedirect("/login");
            return false;
        } else {
            Optional<User> optionalUser = userService.getUserById(user.getId());
            if (optionalUser.isPresent()) {
                user = optionalUser.get();
            }
        }
        request.setAttribute("currentUser", user);
        return true;
    }
}