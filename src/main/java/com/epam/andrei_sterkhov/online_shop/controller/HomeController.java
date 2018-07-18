package com.epam.andrei_sterkhov.online_shop.controller;

import com.epam.andrei_sterkhov.online_shop.dto.ItemCategory;
import com.epam.andrei_sterkhov.online_shop.generator.Generator;
import com.epam.andrei_sterkhov.online_shop.service.SessionUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private SessionUserService sessionUserService;

    private final Generator generator = new Generator();
    private final List<ItemCategory> categories = generator.getCategories(3);

    @RequestMapping({"/", "/index"})
    private ModelAndView homePost(ModelAndView modelAndView) {
        modelAndView.addObject("categories", categories);
        modelAndView.addObject("currentUser", sessionUserService.getCurrentSessionUser());
        modelAndView.setViewName("index");
        return modelAndView;
    }
}