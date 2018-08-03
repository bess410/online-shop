package com.epam.andrei_sterkhov.online_shop.service.impl;

import com.epam.andrei_sterkhov.online_shop.dto.Item;
import com.epam.andrei_sterkhov.online_shop.dto.User;
import com.epam.andrei_sterkhov.online_shop.exception.UserAlreadyExistException;
import com.epam.andrei_sterkhov.online_shop.repository.UserRepository;
import com.epam.andrei_sterkhov.online_shop.service.SessionUserService;
import com.epam.andrei_sterkhov.online_shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SessionUserService sessionUserService;

    @Override
    public void createUser(User user) throws UserAlreadyExistException {
        Optional<User> optionalUser = findUserByLogin(user.getLogin());
        if(optionalUser.isPresent()){
            throw new UserAlreadyExistException("Пользователь с Логином ".concat(user.getLogin()).concat(" уже существует."));
        }
        userRepository.save(user);
    }
/*
    @Override
    public boolean isExist(String login) {
        return userRepository.isExist(login);
    }*/

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

   /* @Override
    public void addItemToBasket(Item item) {
        sessionUserService.getCurrentSessionUser().getBasket().add(item);
    }*/

   /* @Override
    public void deleteItemFromBasket(Item itemById) {
        sessionUserService.getCurrentSessionUser().getBasket().remove(itemById);
    }*/

    @Override
    public Optional<User> findUserByLogin(String login) {
        return userRepository.findUserByLogin(login);
    }
}
