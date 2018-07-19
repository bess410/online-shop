package com.epam.andrei_sterkhov.online_shop.repository.impl;

import com.epam.andrei_sterkhov.online_shop.dto.Category;
import com.epam.andrei_sterkhov.online_shop.repository.CategoryRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {
    private Map<String, Category> categories = new HashMap<>();


    @Override
    public Category createCategory(String name) {
        Category category = new Category(name);
        categories.put(name, category);
        return category;
    }

    @Override
    public void deleteCategory(String name) {
        categories.remove(name);
    }

    @Override
    public Category getCategoryByName(String name) {
        return categories.get(name);
    }

    @Override
    public Map<String, Category> getAllCategories() {
        return categories;
    }
}
