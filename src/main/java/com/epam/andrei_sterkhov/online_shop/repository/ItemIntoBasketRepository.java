package com.epam.andrei_sterkhov.online_shop.repository;

import com.epam.andrei_sterkhov.online_shop.dto.ItemIntoBasket;
import com.epam.andrei_sterkhov.online_shop.dto.Item;
import com.epam.andrei_sterkhov.online_shop.dto.User;

import java.util.List;

public interface ItemIntoBasketRepository {
    ItemIntoBasket findBasketByUserAndItem(User user, Item item);

    //@Query(value = "SELECT sum(amount) FROM basket WHERE user_id = ?1", nativeQuery = true)
    int getItemCount(Long userId);

    List<ItemIntoBasket> findAllByUserId(Long userId);

    long createItemIntoBasket(ItemIntoBasket itemIntoBasket);

    ItemIntoBasket getById(Long id);

    void deleteById(Long id);

    void increaseAmountOfItem(ItemIntoBasket itemIntoBasket);
}