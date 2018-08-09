package com.epam.andrei_sterkhov.online_shop.service;

import com.epam.andrei_sterkhov.online_shop.dto.ItemIntoBasket;
import com.epam.andrei_sterkhov.online_shop.dto.Item;
import com.epam.andrei_sterkhov.online_shop.dto.User;

import java.util.List;

public interface BasketService {
    void createBasketRow(ItemIntoBasket itemIntoBasket);

    void deleteBasketById(Long id);

    ItemIntoBasket findBasketByUserAndItem(User user, Item item);

    ItemIntoBasket getBasketById(Long basketId);

    int getItemCount(Long userId);

    List<ItemIntoBasket> findAllByUserId(Long id);

    void increaseAmountOfItem(ItemIntoBasket itemIntoBasket);
}