package com.epam.andrei_sterkhov.online_shop.controller;

import com.epam.andrei_sterkhov.online_shop.service.ItemService;
import com.epam.andrei_sterkhov.online_shop.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

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

   /* @PostMapping("client/add/{id}")
    private void addItem(@PathVariable Long id) {
        userService.addItemToBasket(itemService.getItemById(id));
    }*/

  /*  @PostMapping("client/delete/{id}")
    private void deleteItem(@PathVariable Long id) {
        userService.deleteItemFromBasket(itemService.getItemById(id));
    }
*/
    @GetMapping("client/basket")
    private ModelAndView getBasket(ModelAndView modelAndView) {
        modelAndView.setViewName("basket");
        return modelAndView;
    }
}
