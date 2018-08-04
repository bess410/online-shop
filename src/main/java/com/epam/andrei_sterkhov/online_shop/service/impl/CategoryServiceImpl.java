package com.epam.andrei_sterkhov.online_shop.service.impl;

import com.epam.andrei_sterkhov.online_shop.dto.Category;
import com.epam.andrei_sterkhov.online_shop.dto.Item;
import com.epam.andrei_sterkhov.online_shop.repository.CategoryRepository;
import com.epam.andrei_sterkhov.online_shop.service.CategoryService;
import com.epam.andrei_sterkhov.online_shop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ItemService itemService;

    @Override
    public Category createCategory(String name) {
        return categoryRepository.save(new Category(name));
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void addItemToCategory(String categoryName, Item item) {
        Optional<Category> optionalCategory = categoryRepository.findCategoryByName(categoryName);
        Category category;
        category = optionalCategory.orElseGet(() -> categoryRepository.save(new Category(categoryName)));
        item.setCategory(category);
        itemService.saveItem(item);
        category.getItemList().add(item);
    }

    @Override
    public void deleteItem(Long categoryId, Long itemId) {
        itemService.deleteItem(itemId);
        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
        if (optionalCategory.isPresent() && optionalCategory.get().getItemList().isEmpty()) {
            categoryRepository.deleteById(categoryId);
        }
    }

    @Override
    public Category getCategoryById(Long categoryId) {
        return categoryRepository.getOne(categoryId);
    }

    @Override
    public Optional<Category> findByName(String categoryName) {
        return categoryRepository.findCategoryByName(categoryName);
    }
}
