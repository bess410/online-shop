package com.epam.andrei_sterkhov.online_shop.controller;

import com.epam.andrei_sterkhov.online_shop.dto.User;
import com.epam.andrei_sterkhov.online_shop.exception.UserAlreadyExistException;
import com.epam.andrei_sterkhov.online_shop.service.SessionUserService;
import com.epam.andrei_sterkhov.online_shop.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class AuthController {

    private SessionUserService sessionUserService;

    private UserService userService;

    @GetMapping("registration")
    public ModelAndView registration(ModelAndView modelAndView) {
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @PostMapping("registration")
    public ModelAndView registration(ModelAndView modelAndView, HttpServletRequest request, User user) {
        try {
            userService.createUser(user);
            sessionUserService.setCurrentSessionUser(user);
        } catch (UserAlreadyExistException e) {
            modelAndView.addObject("error", e.getMessage());
            modelAndView.addObject("user", user);
            modelAndView.setViewName("registration");
            return modelAndView;
        }

        modelAndView.setViewName("redirect:index");
        return modelAndView;
    }


    @GetMapping("logout")
    public ModelAndView logout(ModelAndView modelAndView, HttpServletRequest request) {
        request.getSession().invalidate();
        modelAndView.setViewName("redirect:login");
        return modelAndView;
    }

    @GetMapping("login")
    public ModelAndView login(ModelAndView modelAndView) {
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @PostMapping("login")
    public ModelAndView login(ModelAndView modelAndView, User user) {
        String login = user.getLogin();
        Optional<User> optionalUser = userService.findUserByLogin(login);

        if (optionalUser.isPresent()) {
            User userFromDb = optionalUser.get();
            // Проверяем пароль
            if (userFromDb.getPass().equals(user.getPass())) {
                sessionUserService.setCurrentSessionUser(userFromDb);
                modelAndView.setViewName("redirect:client");
                return modelAndView;
            }
        }

        modelAndView.addObject("error", "Неверный логин или пароль");
        modelAndView.addObject("user", user);
        modelAndView.setViewName("login");
        return modelAndView;
    }
}
