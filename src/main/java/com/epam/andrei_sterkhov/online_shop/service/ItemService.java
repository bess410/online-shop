package com.epam.andrei_sterkhov.online_shop.service;

import com.epam.andrei_sterkhov.online_shop.dto.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    void saveItem(Item item);

 /*
        @Override
        public void updateItem(Long itemId, Item item) {
            itemRepository.updateItem(itemId, item);
        }
    */
    Optional<Item> getItemById(Long id);

    List<Item> getAllItem();

    void deleteItem(Long id);
}
