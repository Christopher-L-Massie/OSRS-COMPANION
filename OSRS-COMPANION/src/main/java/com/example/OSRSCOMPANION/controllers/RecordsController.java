package com.example.OSRSCOMPANION.controllers;

import com.example.OSRSCOMPANION.models.Player;
import com.example.OSRSCOMPANION.models.data.PlayerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "records")
public class RecordsController {

    @Autowired
    private PlayerDao playerDao;

    @RequestMapping(value = "")
    public String index(Model model){
        model.addAttribute("title","Tournaments");

        List<Player> players = new ArrayList<>();

        for (Player player : playerDao.findAll()){
            players.add(player);
        }
        return "records/records";
    }
}
