package com.epam.andrei_sterkhov.online_shop.repository;

import com.epam.andrei_sterkhov.online_shop.dto.Category;

import java.util.Map;

public interface CategoryRepository {
    Category createCategory(String name);

    void deleteCategory(String name);

    Category getCategoryByName(String name);

    Map<String, Category> getAllCategories();

    boolean isExist(String categoryName);
}
