package com.example.OSRSCOMPANION.controllers;

import com.example.OSRSCOMPANION.models.Player;
import com.example.OSRSCOMPANION.models.data.PlayerDao;
import com.example.OSRSCOMPANION.models.databuilder.DataPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "tournaments")
public class TournamentController {

    @Autowired
    private PlayerDao playerDao;

    @RequestMapping(value = "")
    public String index(Model model){
        model.addAttribute("title","Tournaments");

        return "tournaments/tournaments";
    }
}
