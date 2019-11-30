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

    @RequestMapping(value = "progression")
    public String progressionTest(Model model){

        String searchedName = "franquito";
        long days = 14;
        Boolean isFound = false;

        if (playerDao.count() > 0){
            for (Player player : playerDao.findAll()){
                if (player.getDisplayName().equals(searchedName) & (!isFound)){
                    player.checkProgression(days);
                    playerDao.save(player);
                    model.addAttribute("progression",player.findRecentProgression("normal"));
                    return "home/search";
                } else {
                    continue;
                }
            }
        }

        return "home/index";
    }

    @RequestMapping(value = "playerscore")
    public String index(Model model){

        //start keeping track of time elapsed
        Instant start = Instant.now();

        String searchedName = "franquito";

        Boolean isFound = false;

        if (playerDao.count() > 0){
            for (Player player : playerDao.findAll()){
                if (player.getDisplayName().equals(searchedName) & (!isFound)){
                    model.addAttribute("player",playerDao.findById(player.getId()).get());
                    return "home/player";
                } else {
                    continue;
                }
            }
        }

        if (!isFound){
            Player testPlayer = new Player(searchedName);
            testPlayer.updateData();
            playerDao.save(testPlayer);
            model.addAttribute("player",testPlayer);
            return "home/player";
        }

        //finish and display elapsed time
        //shouldn't be reached normally
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start,finish).toMillis();
        System.out.println("time elapsed:" + timeElapsed);
        return "test";

    }

}
