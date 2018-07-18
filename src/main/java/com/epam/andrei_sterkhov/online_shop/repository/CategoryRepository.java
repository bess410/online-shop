package com.epam.andrei_sterkhov.online_shop.repository;

import com.epam.andrei_sterkhov.online_shop.dto.Category;

public interface CategoryRepository {
    void createCategory(String name);

    void deleteCategory(String name);

    Category getCategoryByName(String name);
}
