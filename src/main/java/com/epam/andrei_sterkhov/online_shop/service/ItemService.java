package com.epam.andrei_sterkhov.online_shop.service;

import com.epam.andrei_sterkhov.online_shop.dto.Item;

public interface ItemService {
    void saveItem(Item item);

    Item getItemById(Long id);

    void deleteItem(Long id);
}
