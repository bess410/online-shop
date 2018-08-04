package com.epam.andrei_sterkhov.online_shop.service.impl;

import com.epam.andrei_sterkhov.online_shop.dto.Basket;
import com.epam.andrei_sterkhov.online_shop.dto.Item;
import com.epam.andrei_sterkhov.online_shop.dto.User;
import com.epam.andrei_sterkhov.online_shop.exception.UserAlreadyExistException;
import com.epam.andrei_sterkhov.online_shop.repository.UserRepository;
import com.epam.andrei_sterkhov.online_shop.service.BasketService;
import com.epam.andrei_sterkhov.online_shop.service.ItemService;
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
    private ItemService itemService;

    @Autowired
    private BasketService basketService;

    @Autowired
    private SessionUserService sessionUserService;

    @Override
    public void createUser(User user) throws UserAlreadyExistException {
        Optional<User> optionalUser = findUserByLogin(user.getLogin());
        if (optionalUser.isPresent()) {
            throw new UserAlreadyExistException("Пользователь с Логином ".concat(user.getLogin()).concat(" уже существует."));
        }
        userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void addItemToBasket(Long itemId) {
        User user = sessionUserService.getCurrentSessionUser();
        Item item = itemService.getItemById(itemId);

        int amount = item.getAmount();
        if (amount > 0) {
            // Уменьшаем количество товаров в базе
            item.setAmount(amount - 1);
            itemService.saveItem(item);
            // Проверяем есть этот товар в корзине, если есть то увеличиваем счетчик
            Optional<Basket> optionalBasket = basketService.findBasketByUserAndItem(user, item);
            Basket basket = new Basket();
            if (optionalBasket.isPresent()) {
                basket = optionalBasket.get();
                basket.setAmount(basket.getAmount() + 1);
            } else {
                basket.setUser(user);
                basket.setItem(item);
                basket.setAmount(1);
            }
            basketService.createBasketRow(basket);
        }
    }

    @Override
    public void deleteItemFromBasket(Long id) {
        basketService.deleteBasketById(id);
    }

    @Override
    public Optional<User> findUserByLogin(String login) {
        return userRepository.findUserByLogin(login);
    }
}
