package com.epam.andrei_sterkhov.online_shop.service.impl;

import com.epam.andrei_sterkhov.online_shop.dto.Item;
import com.epam.andrei_sterkhov.online_shop.dto.User;
import com.epam.andrei_sterkhov.online_shop.exception.UserAlreadyExistException;
import com.epam.andrei_sterkhov.online_shop.repository.UserRepository;
import com.epam.andrei_sterkhov.online_shop.service.SessionUserService;
import com.epam.andrei_sterkhov.online_shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SessionUserService sessionUserService;

    @Override
    public void createUser(User user) throws UserAlreadyExistException {
        if (isExist(user.getLogin())) {
            throw new UserAlreadyExistException("Пользователь с Логином ".concat(user.getLogin()).concat(" уже существует."));
        } else {
            userRepository.createUser(user.getLogin(), user);
        }
    }

    @Override
    public boolean isExist(String login) {
        return userRepository.isExist(login);
    }

    @Override
    public User getUserByLogin(String login) {
        return userRepository.getUserByLogin(login);
    }

    @Override
    public void addItemToBasket(Item item) {
        sessionUserService.getCurrentSessionUser().getBasket().add(item);
    }

    @Override
    public void deleteItemFromBasket(Item itemById) {
        sessionUserService.getCurrentSessionUser().getBasket().remove(itemById);
    }
}
