package com.epam.andrei_sterkhov.online_shop.controller;

import com.epam.andrei_sterkhov.online_shop.generator.Generator;
import com.epam.andrei_sterkhov.online_shop.service.CategoryService;
import com.epam.andrei_sterkhov.online_shop.service.SessionUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;

@Controller
public class HomeController {

    @Autowired
    private SessionUserService sessionUserService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private Generator generator;

    @PostConstruct
    private void initialize(){
        generator.generateCategories(3, 10);
    }

    @RequestMapping({"/", "/index"})
    private ModelAndView homePost(ModelAndView modelAndView) {
        modelAndView.addObject("categories", categoryService.getAllCategories());
        modelAndView.addObject("currentUser", sessionUserService.getCurrentSessionUser());
        modelAndView.setViewName("index");
        return modelAndView;
    }
}