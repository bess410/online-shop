package com.epam.andrei_sterkhov.online_shop.service.impl;

import com.epam.andrei_sterkhov.online_shop.dto.Basket;
import com.epam.andrei_sterkhov.online_shop.repository.BasketRepository;
import com.epam.andrei_sterkhov.online_shop.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasketServiceImpl implements BasketService {
    @Autowired
    private BasketRepository basketRepository;

    @Override
    public void createBasketRow(Basket basket) {
        basketRepository.saveAndFlush(basket);
    }

    @Override
    public void deleteBasketById(Long id) {
        basketRepository.deleteById(id);
    }
}
