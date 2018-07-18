package com.epam.andrei_sterkhov.online_shop.generator;

import com.epam.andrei_sterkhov.online_shop.dto.Item;
import com.epam.andrei_sterkhov.online_shop.dto.ItemCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generator {
    private Random random = new Random();

    private List<Item> getItemList(int size) {
        List<Item> itemList = new ArrayList<>();
        Item item;
        int price;
        String[] names = {"Thing", "Another", "Hrenovina", "Same thing"};
        String name;
        for (int i = 0; i < size; i++) {
            price = (random.nextInt(10) + 1) * 1000;
            name = names[random.nextInt(names.length)];
            item = new Item(name, price, "Description", "../images/maifun.jpg");
            itemList.add(item);
        }
        return itemList;
    }

    private ItemCategory getCategory(String name, int size) {
        ItemCategory category = new ItemCategory(name);
        category.setItemList(getItemList(size));
        return category;
    }

    public List<ItemCategory> getCategories(int size) {
        List<ItemCategory> categories = new ArrayList<>();
        String[] namesCategory = {"Technics", "Food", "All for Garden", "Other things"};
        String name;
        for (int i = 0; i < size; i++) {
            name = namesCategory[random.nextInt(namesCategory.length)];
            categories.add(getCategory(name, random.nextInt(20)));
        }
        return categories;
    }
}
