package com.epam.andrei_sterkhov.online_shop.service;

import com.epam.andrei_sterkhov.online_shop.dto.Item;

import java.util.List;

public interface ItemService {
    void saveItem(Item item);

    Item getItemById(Long id);

    List<Item> getAllItem();

    void deleteItem(Long id);
}
