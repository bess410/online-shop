package com.epam.andrei_sterkhov.online_shop.controller;

import com.epam.andrei_sterkhov.online_shop.generator.Generator;
import com.epam.andrei_sterkhov.online_shop.service.CategoryService;
import com.epam.andrei_sterkhov.online_shop.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class HomeController {

    private CategoryService categoryService;

    private UserService userService;

    private Generator generator;

   /* @PostConstruct
    private void initialize() throws UserAlreadyExistException {
        generator.generateCategories(3, 10);
        User user = new User();
        user.setLogin("admin");
        user.setPass("admin");
        user.setUserName("Arnold");
        user.setSurname("Shvartsneger");
        user.setRole(Role.ADMIN);
        userService.createUser(user);
    }*/

    @GetMapping({"/", "/index"})
    private ModelAndView home(ModelAndView modelAndView) {
        modelAndView.addObject("categories", categoryService.findAll());
        modelAndView.setViewName("index");
        return modelAndView;
    }
}