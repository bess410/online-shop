package com.epam.andrei_sterkhov.online_shop.controller;

import com.epam.andrei_sterkhov.online_shop.dto.User;
import com.epam.andrei_sterkhov.online_shop.enums.Role;
import com.epam.andrei_sterkhov.online_shop.exception.UserAlreadyExistException;
import com.epam.andrei_sterkhov.online_shop.generator.Generator;
import com.epam.andrei_sterkhov.online_shop.service.CategoryService;
import com.epam.andrei_sterkhov.online_shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;

@Controller
public class HomeController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserService userService;

    @Autowired
    private Generator generator;

    @PostConstruct
    private void initialize() throws UserAlreadyExistException {
        generator.generateCategories(3, 10);
        User user = new User();
        user.setLogin("arni");
        user.setPass("arni");
        user.setUserName("Arnold");
        user.setSurname("Shvartsneger");
        user.setRole(Role.ADMIN);
        userService.createUser(user);
    }

    @GetMapping({"/", "/index"})
    private ModelAndView home(ModelAndView modelAndView) {
        modelAndView.addObject("categories", categoryService.getAllCategories());
        modelAndView.setViewName("index");
        return modelAndView;
    }
}