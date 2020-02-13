package com.example.OSRSCOMPANION.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "merchant")
public class MerchantController {

    @RequestMapping(value = "logs")
    public String index(Model model){
        model.addAttribute("title","Merchant Logs");

        return "merchants/merchant_logs";
    }
}
