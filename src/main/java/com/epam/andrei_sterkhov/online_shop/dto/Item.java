package com.epam.andrei_sterkhov.online_shop.dto;

import java.util.concurrent.atomic.AtomicInteger;

public class Item {
    private static AtomicInteger count = new AtomicInteger();
    private int id;
    private String name;
    private int price;
    private String description;
    private String imageUrl;

    public Item(String name, int price, String description, String imageUrl) {
        this.id = count.incrementAndGet();
        this.name = name;
        this.price = price;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}

