package com.epam.andrei_sterkhov.online_shop.dto;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private String name;
    private List<Item> itemList = new ArrayList<>();

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}
