package com.epam.andrei_sterkhov.online_shop.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndexController implements ErrorController {

    private static final String PATH = "/error";

    @GetMapping(PATH)
    private ModelAndView errorPage(ModelAndView modelAndView) {
        modelAndView.setViewName("error-page");
        return modelAndView;
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}