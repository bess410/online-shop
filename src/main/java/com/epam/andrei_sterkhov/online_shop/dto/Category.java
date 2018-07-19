package com.epam.andrei_sterkhov.online_shop.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
public class Category {
    private String name;
    private List<Item> itemList = new ArrayList<>();

    public Category(String name) {
        this.name = name;
    }
}
