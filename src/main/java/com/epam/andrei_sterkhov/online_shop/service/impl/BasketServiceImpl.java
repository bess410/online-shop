package com.epam.andrei_sterkhov.online_shop.service.impl;

import com.epam.andrei_sterkhov.online_shop.dto.ItemIntoBasket;
import com.epam.andrei_sterkhov.online_shop.dto.Item;
import com.epam.andrei_sterkhov.online_shop.dto.User;
import com.epam.andrei_sterkhov.online_shop.repository.ItemIntoBasketRepository;
import com.epam.andrei_sterkhov.online_shop.service.BasketService;
import com.epam.andrei_sterkhov.online_shop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketServiceImpl implements BasketService {
    @Autowired
    private ItemIntoBasketRepository itemIntoBasketRepository;

    @Autowired
    private ItemService itemService;

    @Override
    public void createBasketRow(ItemIntoBasket itemIntoBasket) {
        itemIntoBasketRepository.createItemIntoBasket(itemIntoBasket);
    }

    @Override
    public void deleteBasketById(Long id) {
        ItemIntoBasket itemIntoBasket = itemIntoBasketRepository.getById(id);
        int amount = itemIntoBasket.getAmount();
        Item item = itemIntoBasket.getItem();
        item.setAmount(item.getAmount() + amount);
        itemService.saveItem(item);
        itemIntoBasketRepository.deleteById(id);
    }

    @Override
    public ItemIntoBasket findBasketByUserAndItem(User user, Item item) {
        return itemIntoBasketRepository.findBasketByUserAndItem(user, item);
    }

    @Override
    public ItemIntoBasket getBasketById(Long basketId) {
        return itemIntoBasketRepository.getById(basketId);
    }

    @Override
    public int getItemCount(Long userId) {
        int itemCount = 0;
        try {
            itemCount = itemIntoBasketRepository.getItemCount(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return itemCount;
    }

    @Override
    public List<ItemIntoBasket> findAllByUserId(Long id) {
        return itemIntoBasketRepository.findAllByUserId(id);
    }

    @Override
    public void increaseAmountOfItem(ItemIntoBasket itemIntoBasket) {
        itemIntoBasketRepository.increaseAmountOfItem(itemIntoBasket);
    }
}
