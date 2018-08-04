package com.epam.andrei_sterkhov.online_shop.service;

import com.epam.andrei_sterkhov.online_shop.dto.Basket;
import com.epam.andrei_sterkhov.online_shop.dto.Item;
import com.epam.andrei_sterkhov.online_shop.dto.User;

import java.util.Optional;

public interface BasketService {
    void createBasketRow(Basket basket);

    void deleteBasketById(Long id);

    Optional<Basket> findBasketByUserAndItem(User user, Item item);

    Basket getBasketById(Long basketId);
}