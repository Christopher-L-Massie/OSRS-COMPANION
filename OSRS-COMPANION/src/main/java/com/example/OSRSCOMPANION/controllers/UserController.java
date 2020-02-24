package com.example.OSRSCOMPANION.controllers;

import com.example.OSRSCOMPANION.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "login")
    public String userLoginDisplay(Model model){
        model.addAttribute("title","Login");
        
        return "accounts/loginUserAccount";
    }
}
