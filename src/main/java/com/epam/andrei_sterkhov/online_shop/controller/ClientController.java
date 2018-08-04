package com.epam.andrei_sterkhov.online_shop.controller;

import com.epam.andrei_sterkhov.online_shop.dto.Item;
import com.epam.andrei_sterkhov.online_shop.service.ItemService;
import com.epam.andrei_sterkhov.online_shop.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@AllArgsConstructor
public class ClientController {

    private UserService userService;

    private ItemService itemService;

    @GetMapping("client")
    private ModelAndView client(ModelAndView modelAndView) {
        modelAndView.setViewName("redirect:index");
        return modelAndView;
    }

    @PostMapping("client/add/{id}")
    private void addItem(@PathVariable Long id) {
        userService.addItemToBasket(id);
    }

    @PostMapping("client/delete/{id}")
    private void deleteItem(@PathVariable Long id) {
        Optional<Item> optionalItem = itemService.getItemById(id);
        optionalItem.ifPresent(item -> userService.deleteItemFromBasket(item));

    }

    @GetMapping("client/basket")
    private ModelAndView getBasket(ModelAndView modelAndView) {
        modelAndView.setViewName("basket");
        return modelAndView;
    }

    @GetMapping("client/full-view-after-adding-item/{id}")
    private ModelAndView getFullViewAfterAddingItem(ModelAndView modelAndView, @PathVariable Long id) {
        Optional<Item> optionalItem = itemService.getItemById(id);
        if (optionalItem.isPresent()) {
            modelAndView.addObject(optionalItem.get());
            modelAndView.setViewName("full_view_item");
        }
        return modelAndView;
    }
}
