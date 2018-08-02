package com.epam.andrei_sterkhov.online_shop.generator;

import com.epam.andrei_sterkhov.online_shop.dto.Item;
import com.epam.andrei_sterkhov.online_shop.dto.Category;
import com.epam.andrei_sterkhov.online_shop.service.CategoryService;
import com.epam.andrei_sterkhov.online_shop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class Generator {
    /*private Random random = new Random();

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ItemService itemService;

    private List<Item> generateItemList(int size) {
        List<Item> itemList = new ArrayList<>();
        Item item;
        int price;
        String[] names = {"Thing", "Another", "Hrenovina", "Same thing"};
        String name;
        for (int i = 0; i < size; i++) {
            price = (random.nextInt(10) + 1) * 1000;
            name = names[random.nextInt(names.length)];
            item = new Item(name, price, "Description", "/images/maifun.jpg");
            itemService.createItem(item.getId(), item);
            itemList.add(item);
        }
        return itemList;
    }

    public void generateCategories(int categoriesSize, int itemSize) {
        String[] namesCategory = {"Technics", "Food", "All for Garden", "Other things"};
        String name;
        for (int i = 0; i < categoriesSize; i++) {
            name = namesCategory[random.nextInt(namesCategory.length)];
            Category category = categoryService.createCategory(name);
            category.setItemList(generateItemList(random.nextInt(itemSize) + 1));
        }
    }*/
}
