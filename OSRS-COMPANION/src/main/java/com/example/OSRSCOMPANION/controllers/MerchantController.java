package com.example.OSRSCOMPANION.controllers;

import com.example.OSRSCOMPANION.models.data.LogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "merchant")
public class MerchantController {

    @Autowired
    private LogDao logDao;


    @RequestMapping(value = "logs")
    public String index(Model model){
        model.addAttribute("title","Merchant Logs");

        return "merchants/merchant_logs";
    }

    @RequestMapping(value = "log")
    public String displayLog(Model model){
        model.addAttribute("title","PLACEHOLDER WILL PUT PLAYER NAME");

        return "merchants/merchant_log";
    }

    @RequestMapping(value = "log/create")
    public String displayCreateLogForm(Model model){
        model.addAttribute("title", "Create New Log");

        return "merchants/create_log";
    }

    @RequestMapping(value = "log/create")
    public void processCreateLog(Model model, @RequestParam String logName, @RequestParam long gold){
        model.addAttribute("title", logName);

        displayLog(model);
    }
}
