package com.example.OSRSCOMPANION.controllers;


import com.example.OSRSCOMPANION.models.Player;
import com.example.OSRSCOMPANION.models.data.PlayerDao;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.time.Duration;
import java.time.Instant;

@Controller
@RequestMapping("test")
public class TestController {

    @Autowired
    private PlayerDao playerDao;

    @RequestMapping(value = "")
    public String index(Model model){



        //start keeping track of time elapsed
        Instant start = Instant.now();

        String searchedName = "franquito";

        Player displayedPlayer;
        Boolean isFound = false;

        for (Player player : playerDao.findAll()){
            if (player.getDisplayName().equals(searchedName) & (isFound == false)){
                displayedPlayer = player;
                isFound = true;
                model.addAttribute(playerDao.findById(player.getId()).get());

                return "home/player";
            } else {
                continue;
            }
        }




        /*

        Player testPlayer = new Player("franquito");
        testPlayer.updateData();
        playerDao.save(testPlayer);

         */



        System.out.println(playerDao.findAll());
        System.out.println(playerDao.findById(1).get());

        model.addAttribute("player",playerDao.findById(1).get());

        //finish and display elapsed time
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start,finish).toMillis();
        System.out.println("time elapsed:" + timeElapsed);

        return "test";
    }
}
