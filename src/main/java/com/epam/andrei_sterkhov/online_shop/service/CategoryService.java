package com.epam.andrei_sterkhov.online_shop.service;

import com.epam.andrei_sterkhov.online_shop.dto.Category;
import com.epam.andrei_sterkhov.online_shop.dto.Item;

import java.util.List;
import java.util.Map;

public interface CategoryService {
    Category createCategory(String name);

    void deleteCategory(String name);

    Category getCategoryByName(String categoryName);

    void setListItemToCategory(String categoryName, List<Item> itemList);

    Map<String, Category> getAllCategories();

    void addItemToCategory(String categoryName, Item item);
}
