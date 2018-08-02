package com.epam.andrei_sterkhov.online_shop.service;

import com.epam.andrei_sterkhov.online_shop.dto.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    void createItem(Item item);


    /*
        @Override
        public void deleteItem(Long itemId) {
            itemRepository.deleteItem(itemId);
        }

        @Override
        public void updateItem(Long itemId, Item item) {
            itemRepository.updateItem(itemId, item);
        }
    */
    Optional<Item> getItemById(Long id);

    List<Item> getAllItem();
}
