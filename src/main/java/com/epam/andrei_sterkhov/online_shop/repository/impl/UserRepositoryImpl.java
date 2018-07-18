package com.epam.andrei_sterkhov.online_shop.repository.impl;

import com.epam.andrei_sterkhov.online_shop.dto.User;
import com.epam.andrei_sterkhov.online_shop.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private Map<String, User> users = new HashMap<>();

    @Override
    public void createUser(String login, User user) {
        users.put(login, user);
    }

    @Override
    public boolean isExist(String login) {
        return users.containsKey(login);
    }

    @Override
    public User getUserByLogin(String login) {
        return users.get(login);
    }
}
