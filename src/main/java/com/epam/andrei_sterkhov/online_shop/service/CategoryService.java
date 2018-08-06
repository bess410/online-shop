package com.epam.andrei_sterkhov.online_shop.service;

import com.epam.andrei_sterkhov.online_shop.dto.Category;
import com.epam.andrei_sterkhov.online_shop.dto.Item;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    Category createCategory(String name);

    List<Category> findAll();

    void addItemToCategory(String categoryName, Item item);

    void deleteItem(Long categoryId, Long itemId);

    Category getCategoryById(Long categoryId);

    Optional<Category> findByName(String categoryName);

    void deleteCategory(Category oldCategory);
}
