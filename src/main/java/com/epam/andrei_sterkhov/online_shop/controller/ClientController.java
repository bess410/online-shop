package com.epam.andrei_sterkhov.online_shop.controller;

import com.epam.andrei_sterkhov.online_shop.dto.User;
import com.epam.andrei_sterkhov.online_shop.service.ItemService;
import com.epam.andrei_sterkhov.online_shop.service.SessionUserService;
import com.epam.andrei_sterkhov.online_shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ClientController {

    @Autowired
    private SessionUserService sessionUserService;

    @Autowired
    private UserService userService;

    @Autowired
    private ItemService itemService;

    @GetMapping("client")
    private ModelAndView client(ModelAndView modelAndView) {
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @PostMapping("client/add/{id}")
    private ModelAndView addItem(ModelAndView modelAndView, @PathVariable Long id, HttpServletResponse response){
        userService.addItemToBusket(itemService.getItemById(id));
        modelAndView.setViewName("redirect:/index");
        return modelAndView;
    }

    @GetMapping("client/settings")
    private ModelAndView clientSettings(ModelAndView modelAndView) {
        modelAndView.addObject("currentUser", sessionUserService.getCurrentSessionUser());
        modelAndView.setViewName("user_settings");
        return modelAndView;
    }

    @PostMapping("client/settings")
    private ModelAndView clientSettingsPost(ModelAndView modelAndView, User user) {
        //long userId = sessionUserService.getCurrentSessionUser().getId();
        //userService.updateUser(user, userId);
        //sessionUserService.setCurrentSessionUser(userService.findUserById(userId));
        modelAndView.addObject("currentUser", sessionUserService.getCurrentSessionUser());
        modelAndView.setViewName("user_settings");
        return modelAndView;
    }
}