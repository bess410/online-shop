package com.epam.andrei_sterkhov.online_shop.service.impl;

import com.epam.andrei_sterkhov.online_shop.dto.User;
import com.epam.andrei_sterkhov.online_shop.service.SessionUserService;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope(proxyMode = ScopedProxyMode.INTERFACES)
public class SessionUserServiceImpl implements SessionUserService {

    private User currentSessionUser;

    @Override
    public User setCurrentSessionUser(User user) {
        currentSessionUser = user;
        return currentSessionUser;
    }

    @Override
    public User getCurrentSessionUser() {
        return currentSessionUser;
    }
}
