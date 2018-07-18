package com.epam.andrei_sterkhov.online_shop.repository;

public interface CategoryRepository {
    void createCategory(String name);

    void deleteCategory(String name);
}
