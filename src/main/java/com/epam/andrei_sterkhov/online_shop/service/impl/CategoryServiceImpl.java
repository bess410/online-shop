package com.epam.andrei_sterkhov.online_shop.service.impl;

import com.epam.andrei_sterkhov.online_shop.repository.CategoryRepository;
import com.epam.andrei_sterkhov.online_shop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void createCategory(String name) {
        categoryRepository.createCategory(name);
    }

    @Override
    public void deleteCategory(String name) {
        categoryRepository.deleteCategory(name);
    }
}
