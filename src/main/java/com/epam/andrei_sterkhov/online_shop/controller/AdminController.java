package com.epam.andrei_sterkhov.online_shop.controller;

import com.epam.andrei_sterkhov.online_shop.dto.Category;
import com.epam.andrei_sterkhov.online_shop.dto.Item;
import com.epam.andrei_sterkhov.online_shop.service.CategoryService;
import com.epam.andrei_sterkhov.online_shop.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@AllArgsConstructor
public class AdminController {

    private CategoryService categoryService;

    private ItemService itemService;

    @GetMapping("admin")
    private ModelAndView admin(ModelAndView modelAndView) {
        modelAndView.addObject("categories", categoryService.findAll());
        modelAndView.setViewName("admin");
        return modelAndView;
    }

    @PostMapping("admin/saveItem")
    private ModelAndView createItem(ModelAndView modelAndView, String categoryName, Item item) {
        categoryService.addItemToCategory(categoryName, item);
        modelAndView.setViewName("redirect:/admin");
        return modelAndView;
    }

    @GetMapping("admin/delete/{categoryId}/{itemId}")
    private ModelAndView deleteItem(ModelAndView modelAndView, @PathVariable Long categoryId, @PathVariable Long itemId) {
        categoryService.deleteItem(categoryId, itemId);
        modelAndView.setViewName("redirect:/admin");
        return modelAndView;
    }

    @GetMapping("admin/edit/{categoryId}/{id}")
    private ModelAndView openEditItemPopup(ModelAndView modelAndView, @PathVariable Long categoryId, @PathVariable Long id) {
        modelAndView.addObject("categories", categoryService.findAll());
        modelAndView.addObject("item", itemService.getItemById(id).get());
        modelAndView.addObject("category", categoryService.getCategoryById(categoryId));
        modelAndView.setViewName("editingItem");
        return modelAndView;
    }

    @PostMapping("admin/edit")
    private ModelAndView editItem(ModelAndView modelAndView, String categoryName, Item item) {
        Optional<Category> optionalCategory = categoryService.findByName(categoryName);
        Category category = optionalCategory.orElseGet(() -> categoryService.createCategory(categoryName));

        Category oldCategory = itemService.getItemById(item.getId()).get().getCategory();
        item.setCategory(category);
        itemService.saveItem(item);

        if (oldCategory.getItemList().isEmpty()) {
            categoryService.deleteCategory(oldCategory);
        }
        modelAndView.setViewName("redirect:/admin");
        return modelAndView;
    }

    @GetMapping("admin/add")
    private ModelAndView addItem(ModelAndView modelAndView) {
        modelAndView.addObject("categories", categoryService.findAll());
        modelAndView.setViewName("addingItem");
        return modelAndView;
    }
}