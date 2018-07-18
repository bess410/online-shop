package com.epam.andrei_sterkhov.online_shop.repository.impl;

import com.epam.andrei_sterkhov.online_shop.dto.Category;
import com.epam.andrei_sterkhov.online_shop.repository.CategoryRepository;

import java.util.HashMap;
import java.util.Map;

public class CategoryRepositoryImpl implements CategoryRepository {
    private Map<String, Category> categories = new HashMap<>();


    @Override
    public void createCategory(String name) {
        Category category = new Category(name);
        categories.put(name, category);
    }

    @Override
    public void deleteCategory(String name) {
        categories.remove(name);
    }
}
