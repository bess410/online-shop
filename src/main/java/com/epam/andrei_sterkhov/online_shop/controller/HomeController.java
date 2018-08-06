package com.epam.andrei_sterkhov.online_shop.controller;

import com.epam.andrei_sterkhov.online_shop.service.BasketService;
import com.epam.andrei_sterkhov.online_shop.service.CategoryService;
import com.epam.andrei_sterkhov.online_shop.service.SessionUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigInteger;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class HomeController {

    private SessionUserService sessionUserService;

    private BasketService basketService;

    private CategoryService categoryService;

    @GetMapping({"/", "/index"})
    private ModelAndView home(ModelAndView modelAndView) {
        long amount = 0;
        long userId = sessionUserService.getCurrentSessionUser().getId();
        Optional<BigInteger> itemCount = basketService.getItemCount(userId);
        if (itemCount.isPresent()) {
            amount = itemCount.get().intValue();
        }
        modelAndView.addObject("basketSize", amount);
        modelAndView.addObject("categories", categoryService.findAll());
        modelAndView.setViewName("index");
        return modelAndView;
    }
}