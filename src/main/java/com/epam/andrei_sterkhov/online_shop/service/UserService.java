package com.epam.andrei_sterkhov.online_shop.service;

import com.epam.andrei_sterkhov.online_shop.dto.Item;
import com.epam.andrei_sterkhov.online_shop.dto.User;
import com.epam.andrei_sterkhov.online_shop.exception.UserAlreadyExistException;

import java.util.Optional;

public interface UserService {
    void createUser(User user) throws UserAlreadyExistException;



    Optional<User> getUserById(Long id);

    Optional<User> findUserByLogin(String login);
}
