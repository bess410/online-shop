package com.epam.andrei_sterkhov.online_shop.repository;

import com.epam.andrei_sterkhov.online_shop.dto.User;

public interface UserRepository {
    void createUser(String login, User user);

    boolean isExist(String login);

    User getUserByLogin(String login);
}
