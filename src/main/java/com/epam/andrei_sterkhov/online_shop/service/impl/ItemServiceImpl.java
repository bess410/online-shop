package com.epam.andrei_sterkhov.online_shop.service.impl;

import com.epam.andrei_sterkhov.online_shop.dto.Item;
import com.epam.andrei_sterkhov.online_shop.repository.ItemRepository;
import com.epam.andrei_sterkhov.online_shop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    @Override
    public Item getItemById(Long id) {
        return itemRepository.getOne(id);
    }

    @Override
    public List<Item> getAllItem() {
        return itemRepository.findAll();
    }

    @Override
    public void deleteItem(Long id) {
        Optional<Item> itemOptional = itemRepository.findById(id);
        itemOptional.ifPresent(item -> itemRepository.delete(item));
    }
}
