package com.example.OSRSCOMPANION.controllers;


import com.example.OSRSCOMPANION.models.Player;
import com.example.OSRSCOMPANION.models.constants.hiscoreTypes;
import com.example.OSRSCOMPANION.models.data.PlayerDao;
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
    public String index(){

        return "home/index";
    }

    @RequestMapping(value = "player")
    public String playerStats(Model model){

        //temp test for building table
        model.addAttribute("player",playerDao.findById(1).get());
        return "home/player";
    }

    @RequestMapping(value = "fetch")
    public String fetchHiscore(Model model, @RequestParam String displayName, @RequestParam String hiscoreType){
        if (playerDao.count() > 0){
            for (Player player : playerDao.findAll()){
                if (player.getDisplayName().equals(displayName)){
                    if(hiscoreType.equals("normal")) {
                        model.addAttribute("player",player);
                        model.addAttribute("displayName", player.getDisplayName());
                        model.addAttribute("data",player.getNormalData());
                        return "home/player";
                    } else if (hiscoreType.equals("ironman")){
                        model.addAttribute("player",player);
                        model.addAttribute("displayName",player.getDisplayName());
                        model.addAttribute("data",player.getIronmanData());
                        return "home/player";
                    } else if (hiscoreType.equals("ultimate")){
                        model.addAttribute("player",player);
                        model.addAttribute("displayName",player.getDisplayName());
                        model.addAttribute("data",player.getUltimateData());
                        return "home/player";
                    } else if (hiscoreType.equals("hardcore")){
                        model.addAttribute("player",player);
                        model.addAttribute("displayName",player.getDisplayName());
                        model.addAttribute("data",player.getHardcoreData());
                        return "home/player";
                    }

                } else {
                    continue;
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

        Boolean isFound = false;

        if (playerDao.count() > 0){
            for (Player player : playerDao.findAll()){
                if (player.getDisplayName().equals(displayName) & (!isFound)){
                    model.addAttribute("player",player);
                    model.addAttribute("displayName", player.getDisplayName());
                    model.addAttribute("data",player.getNormalData());
                    return "home/player";
                } else {
                    continue;
                }
            }
        }

        if (!isFound){
            Player newPlayer = new Player(displayName);
            newPlayer.updateData();
            playerDao.save(newPlayer);
            model.addAttribute("player",newPlayer);
            model.addAttribute("displayName",newPlayer.getDisplayName());
            model.addAttribute("data",newPlayer.getNormalData());
            return "home/player";
        }

        return "home/index";
    }


    @RequestMapping(value = "update",method = RequestMethod.GET)
    public String processUpdatePlayer(Model model,@RequestParam String displayName){
        if (playerDao.count() > 0){
            for (Player player : playerDao.findAll()){
                if (player.getDisplayName().equals(displayName)){
                    player.updateData();
                    playerDao.save(player);
                    model.addAttribute("player",player);
                    model.addAttribute("data",player.getNormalData());
                    model.addAttribute("displayName",player.getDisplayName());
                    return "home/player";
                } else {
                    continue;
                }
            }
        }
        return "home/index";

    }




}
