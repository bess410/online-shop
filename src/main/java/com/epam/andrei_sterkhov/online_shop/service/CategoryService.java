package com.epam.andrei_sterkhov.online_shop.service;

import com.epam.andrei_sterkhov.online_shop.dto.Category;
import com.epam.andrei_sterkhov.online_shop.dto.Item;

import java.util.List;
import java.util.Map;

public interface CategoryService {

    Category createCategory(String name);

    List<Category> findAll();
}
