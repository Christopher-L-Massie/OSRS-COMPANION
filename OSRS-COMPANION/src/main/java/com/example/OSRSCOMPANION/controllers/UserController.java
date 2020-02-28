package com.example.OSRSCOMPANION.controllers;

import com.example.OSRSCOMPANION.models.User;
import com.example.OSRSCOMPANION.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String userLoginDisplay(Model model){
        model.addAttribute("title","Login");
        model.addAttribute("User", new User());

        return "accounts/loginUserAccount";
    }
}
