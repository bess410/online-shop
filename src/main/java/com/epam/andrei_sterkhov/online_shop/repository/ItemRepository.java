package com.epam.andrei_sterkhov.online_shop.repository;

import com.epam.andrei_sterkhov.online_shop.dto.Item;

public interface ItemRepository {

    void createItem(Long itemId, Item item);

    void deleteItem(Long itemId);

    void updateItem(Long itemId, Item item);

    Item getItemById(Long id);
}
