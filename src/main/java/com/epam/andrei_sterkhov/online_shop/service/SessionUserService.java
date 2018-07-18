package com.epam.andrei_sterkhov.online_shop.service;

import com.epam.andrei_sterkhov.online_shop.dto.User;

public interface SessionUserService {
    User setCurrentSessionUser(User user);

    User getCurrentSessionUser();
}
