package com.epam.andrei_sterkhov.online_shop.controller;

import com.epam.andrei_sterkhov.online_shop.dto.User;
import com.epam.andrei_sterkhov.online_shop.service.SessionUserService;
import com.epam.andrei_sterkhov.online_shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

    @Autowired
    private SessionUserService sessionUserService;

    @Autowired
    private UserService userService;

    @GetMapping("admin")
    private ModelAndView admin(ModelAndView modelAndView) {
        modelAndView.addObject("currentUser", sessionUserService.getCurrentSessionUser());
        modelAndView.setViewName("redirect:admin/requests");
        return modelAndView;
    }

    @GetMapping("admin/settings")
    private ModelAndView adminSettings(ModelAndView modelAndView) {
        modelAndView.addObject("currentUser", sessionUserService.getCurrentSessionUser());
        modelAndView.setViewName("admin_settings");
        return modelAndView;
    }

    @PostMapping("admin/settings")
    private ModelAndView adminSettingsPost(ModelAndView modelAndView, User user) {
        //long userId = sessionUserService.getCurrentSessionUser().getId();
        //userService.updateUser(user, userId);
        //sessionUserService.setCurrentSessionUser(userService.findUserById(userId));
        modelAndView.addObject("currentUser", sessionUserService.getCurrentSessionUser());
        modelAndView.setViewName("admin_settings");
        return modelAndView;
    }
}