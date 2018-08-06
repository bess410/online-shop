package com.epam.andrei_sterkhov.online_shop.service;

import com.epam.andrei_sterkhov.online_shop.dto.Basket;
import com.epam.andrei_sterkhov.online_shop.dto.Item;
import com.epam.andrei_sterkhov.online_shop.dto.User;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface BasketService {
    void createBasketRow(Basket basket);

    void deleteBasketById(Long id);

    Optional<Basket> findBasketByUserAndItem(User user, Item item);

    Basket getBasketById(Long basketId);

    Optional<BigInteger> getItemCount(Long userId);

    Optional<List<Basket>> findAllByUserId(Long id);
}