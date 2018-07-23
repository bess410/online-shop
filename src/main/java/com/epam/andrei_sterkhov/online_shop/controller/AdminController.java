package com.epam.andrei_sterkhov.online_shop.controller;

import com.epam.andrei_sterkhov.online_shop.service.CategoryService;
import com.epam.andrei_sterkhov.online_shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserService userService;

    @GetMapping("admin")
    private ModelAndView admin(ModelAndView modelAndView) {
        modelAndView.addObject("categories", categoryService.getAllCategories());
        modelAndView.setViewName("admin");
        return modelAndView;
    }
}