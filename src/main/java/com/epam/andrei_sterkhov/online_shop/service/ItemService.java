package com.epam.andrei_sterkhov.online_shop.service;

import com.epam.andrei_sterkhov.online_shop.dto.Item;

import java.util.Map;

public interface ItemService {
    void createItem(Long id, Item item);

    void deleteItem(Long itemId);

    void updateItem(Long itemId, Item item);

    Item getItemById(Long id);

    Map<Long, Item> getAllItem();
}
