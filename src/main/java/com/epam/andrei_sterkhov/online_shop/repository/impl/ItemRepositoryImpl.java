package com.epam.andrei_sterkhov.online_shop.repository.impl;

import com.epam.andrei_sterkhov.online_shop.dto.Item;
import com.epam.andrei_sterkhov.online_shop.repository.ItemRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ItemRepositoryImpl implements ItemRepository {
    private Map<Long, Item> items = new HashMap<>();

    @Override
    public void createItem(Long id, Item item) {
        items.put(id, item);
    }

    @Override
    public void deleteItem(Long itemId) {
        items.remove(itemId);
    }

    @Override
    public void updateItem(Long itemId, Item item) {
        items.put(itemId, item);
    }
}
