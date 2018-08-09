package com.epam.andrei_sterkhov.online_shop.controller;

import com.epam.andrei_sterkhov.online_shop.dto.ItemIntoBasket;
import com.epam.andrei_sterkhov.online_shop.dto.Item;
import com.epam.andrei_sterkhov.online_shop.dto.User;
import com.epam.andrei_sterkhov.online_shop.service.BasketService;
import com.epam.andrei_sterkhov.online_shop.service.ItemService;
import com.epam.andrei_sterkhov.online_shop.service.SessionUserService;
import com.epam.andrei_sterkhov.online_shop.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@AllArgsConstructor
public class ClientController {

    private UserService userService;

    private ItemService itemService;

    private BasketService basketService;

    private SessionUserService sessionUserService;

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
        basketService.deleteBasketById(id);
    }

    @GetMapping("client/updateItem")
    private ModelAndView getBasket(ModelAndView modelAndView, @RequestParam(value = "item", required = false) Long itemId) {
        Item item = itemService.getItemById(itemId).get();
        modelAndView.addObject("item", item);
        modelAndView.setViewName("hide_view_item");
        return modelAndView;
    }



    @GetMapping("client/basket")
    private ModelAndView getBasket(ModelAndView modelAndView) {
        User user = sessionUserService.getCurrentSessionUser();
        List<ItemIntoBasket> itemIntoBaskets = basketService.findAllByUserId(user.getId());
        user.setItemIntoBaskets(itemIntoBaskets);
        modelAndView.addObject("currentUser", user);
        modelAndView.setViewName("basket");
        return modelAndView;
    }

    @GetMapping("client/full-view-after-adding-item/{id}")
    private ModelAndView getFullViewAfterAddingItem(ModelAndView modelAndView, @PathVariable Long id) {
        Item item = itemService.getItemById(id).get();
        modelAndView.addObject(item);
        modelAndView.setViewName("full_view_item");
        return modelAndView;
    }
}