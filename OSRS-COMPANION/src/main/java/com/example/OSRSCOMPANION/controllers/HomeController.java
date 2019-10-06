package com.example.OSRSCOMPANION.controllers;


import com.example.OSRSCOMPANION.models.data.PlayerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class HomeController {

    @Autowired
    private PlayerDao playerDao;

    @RequestMapping(value = "")
    public String index(){
        return "home/index";
    }

    @RequestMapping(value = "player")
    public String playerStats(Model model){

        //temp test for building table
        model.addAttribute("player",playerDao.findById(1).get());
        return "home/player";
    }




}
