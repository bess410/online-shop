package com.epam.andrei_sterkhov.online_shop.service;

import com.epam.andrei_sterkhov.online_shop.dto.Item;
import com.epam.andrei_sterkhov.online_shop.dto.User;
import com.epam.andrei_sterkhov.online_shop.exception.UserAlreadyExistException;

import java.util.Optional;

public interface UserService {
    void createUser(User user) throws UserAlreadyExistException;

    void updateUser(User user);

    Optional<User> getUserById(Long id);

    void addItemToBasket(Item item);

    void deleteItemFromBasket(Item itemById);

    Optional<User> findUserByLogin(String login);
}
