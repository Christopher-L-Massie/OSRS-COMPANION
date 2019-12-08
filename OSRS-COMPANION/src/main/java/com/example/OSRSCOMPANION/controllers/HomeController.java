package com.example.OSRSCOMPANION.controllers;


import com.example.OSRSCOMPANION.models.Player;
import com.example.OSRSCOMPANION.models.constants.hiscoreTypes;
import com.example.OSRSCOMPANION.models.data.PlayerDao;
import com.example.OSRSCOMPANION.models.databuilder.DataPoint;
import com.example.OSRSCOMPANION.models.databuilder.normalData;
import com.example.OSRSCOMPANION.models.forms.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "")
public class HomeController {

    @Autowired
    private PlayerDao playerDao;


    @RequestMapping(value = "")
    public String index(Model model){
        model.addAttribute("players",playerDao.count());

        long dataPoints = 0;
        for(Player player: playerDao.findAll()){
            for(DataPoint dataPoint : player.getNormalData()){
                dataPoints += 1;
            }
            for(DataPoint dataPoint : player.getIronmanData()){
                dataPoints += 1;
            }
            for(DataPoint dataPoint : player.getUltimateData()){
                dataPoints += 1;
            }
            for(DataPoint dataPoint : player.getHardcoreData()){
                dataPoints += 1;
            }
        }
        model.addAttribute("dataPoints", dataPoints);

        return "home/index";
    }

    @RequestMapping(value = "progression")
    public String displayProgression(Model model, @RequestParam String displayName, @RequestParam String hiscoreType,@RequestParam long days){
        if (playerDao.count() > 0) {
            for (Player player : playerDao.findAll()) {
                if (player.getDisplayName().equals(displayName)) {
                    model.addAttribute("title",player.getDisplayName());
                    model.addAttribute("player",player);
                    model.addAttribute("progressionData",player.findRecentProgression("normal").getProgressionData());
                    model.addAttribute("displayName", player.getDisplayName());
                    model.addAttribute("dataPoint",player.getNormalData().get(0));
                    model.addAttribute("currentData",player.getRecentNormalDataPoint());
                    return "home/progression";
                }
            }
        }
        return "index/home";
    }

    @RequestMapping(value = "player")
    public String playerStats(Model model){

        //temp test for building table
        model.addAttribute("player",playerDao.findById(0).get());
        return "home/player";
    }

    @RequestMapping(value = "achievements")
    public String displayAchievements(Model model, @RequestParam String displayName){
        if (playerDao.count() > 0) {
            for (Player player : playerDao.findAll()) {
                if (player.getDisplayName().equals(displayName)) {
                    model.addAttribute("title",player.getDisplayName());
                    model.addAttribute("player",player);
                    model.addAttribute("displayName", player.getDisplayName());
                    model.addAttribute("achievements",player.getAchievements());
                    model.addAttribute("dataPoint",player.getNormalData().get(0));
                    model.addAttribute("data",player.getNormalData());
                    model.addAttribute("progressionData",player.findRecentProgression("normal").getProgressionData());
                    return "home/achievements";
                }
            }
        }

        processSearchPlayer(model,displayName);
        return "home/achievements";

    }

    @RequestMapping(value = "fetch")
    public String fetchHiscore(Model model, @RequestParam String displayName, @RequestParam String hiscoreType){
        if (playerDao.count() > 0){
            for (Player player : playerDao.findAll()){
                if (player.getDisplayName().equals(displayName)){
                    model.addAttribute("title",player.getDisplayName());
                    model.addAttribute("player",player);
                    model.addAttribute("displayName", player.getDisplayName());
                    model.addAttribute("achievements",player.getAchievements());
                    if(hiscoreType.equals("normal")) {
                        model.addAttribute("dataPoint",player.getNormalData().get(0));
                        model.addAttribute("data",player.getNormalData());
                        model.addAttribute("progressionData",player.findRecentProgression("normal").getProgressionData());
                        return "home/player";
                    } else if (hiscoreType.equals("ironman")){
                        model.addAttribute("dataPoint",player.getIronmanData().get(0));
                        model.addAttribute("data",player.getIronmanData());
                        model.addAttribute("progressionData",player.findRecentProgression("ironman").getProgressionData());
                        return "home/player";
                    } else if (hiscoreType.equals("ultimate")){
                        model.addAttribute("dataPoint",player.getUltimateData().get(0));
                        model.addAttribute("data",player.getUltimateData());
                        model.addAttribute("progressionData",player.findRecentProgression("ultimate").getProgressionData());
                        return "home/player";
                    } else if (hiscoreType.equals("hardcore")){
                        model.addAttribute("dataPoint",player.getHardcoreData().get(0));
                        model.addAttribute("data",player.getHardcoreData());
                        model.addAttribute("progressionData",player.findRecentProgression("hardcore").getProgressionData());
                        return "home/player";
                    }
                }
            }
        } else {
            processSearchPlayer(model,displayName);
        }
        return "home/index";
    }

    @RequestMapping(value = "search",method = RequestMethod.GET)
    public String searchPlayer(){

        return "home/search";
    }

    @RequestMapping(value = "search",method = RequestMethod.POST)
    public String processSearchPlayer(Model model,@RequestParam String displayName){

        if (playerDao.count() > 0) {
            for (Player player : playerDao.findAll()) {
                if (player.getDisplayName().equals(displayName)) {
                    model.addAttribute("title", player.getDisplayName());
                    model.addAttribute("player", player);
                    model.addAttribute("dataPoint", player.getNormalData().get(0));
                    model.addAttribute("displayName", player.getDisplayName());
                    model.addAttribute("data", player.getNormalData());
                    model.addAttribute("achievements", player.getAchievements());
                    model.addAttribute("progressionData", player.findRecentProgression("normal").getProgressionData());
                    System.out.println(player.findRecentProgression("normal"));
                    return "home/player";
                }
            }
        }

        Player newPlayer = new Player(displayName);
        newPlayer.updateData();
        newPlayer.checkAchievements();
        newPlayer.checkProgression(1);
        playerDao.save(newPlayer);
        model.addAttribute("title",newPlayer.getDisplayName());
        model.addAttribute("player",newPlayer);
        model.addAttribute("dataPoint",newPlayer.getNormalData().get(0));
        model.addAttribute("displayName",newPlayer.getDisplayName());
        model.addAttribute("data",newPlayer.getNormalData());
        model.addAttribute("achievements",newPlayer.getAchievements());
        model.addAttribute("progressionData",newPlayer.findRecentProgression("normal").getProgressionData());
        return "home/player";
    }


    @RequestMapping(value = "update",method = RequestMethod.GET)
    public String processUpdatePlayer(Model model,@RequestParam String displayName){
        if (playerDao.count() > 0){
            for (Player player : playerDao.findAll()){
                if (player.getDisplayName().equals(displayName)){
                    player.updateData();
                    player.checkAchievements();
                    player.checkProgression(1);
                    playerDao.save(player);
                    model.addAttribute("title",player.getDisplayName());
                    model.addAttribute("player",player);
                    model.addAttribute("dataPoint",player.getNormalData().get(0));
                    model.addAttribute("data",player.getNormalData());
                    model.addAttribute("displayName",player.getDisplayName());
                    model.addAttribute("achievements",player.getAchievements());
                    model.addAttribute("progressionData",player.findRecentProgression("normal").getProgressionData());
                    return "home/player";
                } else {
                    continue;
                }
            }
        }
        return "home/index";

    }




}
