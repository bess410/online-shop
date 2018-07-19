package com.epam.andrei_sterkhov.online_shop.dto;

import lombok.Data;

import java.util.concurrent.atomic.AtomicLong;

@Data
public class Item {
    private static AtomicLong count = new AtomicLong();
    private long id = count.incrementAndGet();
    private String name;
    private int price;
    private String description;
    private String imageUrl;

    public Item(String name, int price, String description, String imageUrl) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.imageUrl = imageUrl;
    }
}

