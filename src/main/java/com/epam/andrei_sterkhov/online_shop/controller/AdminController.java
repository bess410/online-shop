package com.epam.andrei_sterkhov.online_shop.controller;

import com.epam.andrei_sterkhov.online_shop.dto.Item;
import com.epam.andrei_sterkhov.online_shop.service.CategoryService;
import com.epam.andrei_sterkhov.online_shop.service.ItemService;
import com.epam.andrei_sterkhov.online_shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private UserService userService;

    @GetMapping("admin")
    private ModelAndView admin(ModelAndView modelAndView) {
        modelAndView.addObject("categories", categoryService.getAllCategories());
        modelAndView.setViewName("admin");
        return modelAndView;
    }

    @PostMapping("admin/createItem")
    private ModelAndView createItem(ModelAndView modelAndView, String categoryName, Item item) {
        categoryService.addItemToCategory(categoryName, item);
        modelAndView.setViewName("redirect:/admin");
        return modelAndView;
    }

    @GetMapping("admin/delete/{categoryName}/{id}")
    private ModelAndView deleteItem(ModelAndView modelAndView, @PathVariable String categoryName, @PathVariable Long id) {
        categoryService.removeItemFromCategory(categoryName, id);
        modelAndView.setViewName("redirect:/admin");
        return modelAndView;
    }
}