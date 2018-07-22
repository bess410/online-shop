package com.epam.andrei_sterkhov.online_shop.service;

import com.epam.andrei_sterkhov.online_shop.dto.Item;
import com.epam.andrei_sterkhov.online_shop.dto.User;
import com.epam.andrei_sterkhov.online_shop.exception.UserAlreadyExistException;

public interface UserService {
    void createUser(User user) throws UserAlreadyExistException;

    boolean isExist(String login);

    User getUserByLogin(String login);

    void addItemToBusket(Item item);
}
