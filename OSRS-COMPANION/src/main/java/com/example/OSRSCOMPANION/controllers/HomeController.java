package com.example.OSRSCOMPANION.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class HomeController {

    @RequestMapping(value = "")
    public String index(){
        return "home/index";
    }


}
