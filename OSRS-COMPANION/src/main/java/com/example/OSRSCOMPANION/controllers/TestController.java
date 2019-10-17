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
@RequestMapping(value = "test")
public class TestController {

    @Autowired
    private PlayerDao playerDao;

    @RequestMapping(value = "playerscore")
    public String index(Model model){



        //start keeping track of time elapsed
        Instant start = Instant.now();

        String searchedName = "franquito";

        Player displayedPlayer;
        Boolean isFound = false;

        if (playerDao.count() > 0){


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

        }




        /*

        Player testPlayer = new Player("franquito");
        testPlayer.updateData();
        playerDao.save(testPlayer);

         */





        //model.addAttribute("player",playerDao.findById(1).get());

        //finish and display elapsed time
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start,finish).toMillis();
        System.out.println("time elapsed:" + timeElapsed);
        return "test";

    }
}
