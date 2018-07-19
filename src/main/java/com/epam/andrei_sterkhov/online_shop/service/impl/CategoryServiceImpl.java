package com.epam.andrei_sterkhov.online_shop.service.impl;

import com.epam.andrei_sterkhov.online_shop.dto.Category;
import com.epam.andrei_sterkhov.online_shop.dto.Item;
import com.epam.andrei_sterkhov.online_shop.repository.CategoryRepository;
import com.epam.andrei_sterkhov.online_shop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category createCategory(String name) {
        return categoryRepository.createCategory(name);
    }

    @Override
    public void deleteCategory(String name) {
        categoryRepository.deleteCategory(name);
    }

    @Override
    public Category getCategoryByName(String categoryName) {
        return categoryRepository.getCategoryByName(categoryName);
    }

    @Override
    public void setListItemToCategory(String categoryName, List<Item> itemList) {
        getCategoryByName(categoryName).setItemList(itemList);
    }

    @Override
    public Map<String, Category> getAllCategories() {
        return categoryRepository.getAllCategories();
    }
}
