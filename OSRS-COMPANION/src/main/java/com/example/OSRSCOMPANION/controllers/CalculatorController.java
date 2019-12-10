package com.example.OSRSCOMPANION.controllers;

import com.example.OSRSCOMPANION.models.data.PlayerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "calculators")
public class CalculatorController {

    @Autowired
    private PlayerDao playerDao;

    @RequestMapping(value = "")
    public String index(Model model){
        model.addAttribute("title","Calculators");

        return "calculators/calculators";
    }
}