package com.epam.andrei_sterkhov.online_shop.service.impl;

import com.epam.andrei_sterkhov.online_shop.dto.ItemIntoBasket;
import com.epam.andrei_sterkhov.online_shop.dto.Item;
import com.epam.andrei_sterkhov.online_shop.dto.User;
import com.epam.andrei_sterkhov.online_shop.repository.ItemIntoBasketRepository;
import com.epam.andrei_sterkhov.online_shop.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class BasketServiceImpl implements BasketService {
    @Autowired
    private ItemIntoBasketRepository itemIntoBasketRepository;

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
    public Optional<BigInteger> getItemCount(Long userId) {
        return itemIntoBasketRepository.getItemCount(userId);
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
