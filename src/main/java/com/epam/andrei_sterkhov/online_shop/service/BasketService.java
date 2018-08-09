package com.epam.andrei_sterkhov.online_shop.service;

import com.epam.andrei_sterkhov.online_shop.dto.ItemIntoBasket;
import com.epam.andrei_sterkhov.online_shop.dto.Item;
import com.epam.andrei_sterkhov.online_shop.dto.User;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface BasketService {
    void createBasketRow(ItemIntoBasket itemIntoBasket);

    void deleteBasketById(Long id);

    ItemIntoBasket findBasketByUserAndItem(User user, Item item);

    ItemIntoBasket getBasketById(Long basketId);

    Optional<BigInteger> getItemCount(Long userId);

    List<ItemIntoBasket> findAllByUserId(Long id);

    void increaseAmountOfItem(ItemIntoBasket itemIntoBasket);
}