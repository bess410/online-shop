package com.epam.andrei_sterkhov.online_shop.repository;

import com.epam.andrei_sterkhov.online_shop.dto.Item;

public interface ItemRepository {

    void createItem(Item item);

    void deleteItem(Long itemId);

    void updateItem(Long itemId, Item item);

}
