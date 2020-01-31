package com.example.OSRSCOMPANION.controllers;


import com.example.OSRSCOMPANION.models.Player;
import com.example.OSRSCOMPANION.models.constants.hiscoreTypes;
import com.example.OSRSCOMPANION.models.data.PlayerDao;
import com.example.OSRSCOMPANION.models.databuilder.DataPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "")
public class HomeController {

    @Autowired
    private PlayerDao playerDao;

    /*
    Below help with readability
     */

    private Integer NORMAL = hiscoreTypes.NORMAL.getTypeNumber();
    private Integer IRON = hiscoreTypes.IRON.getTypeNumber();
    private Integer ULTIMATE = hiscoreTypes.ULTIMATE.getTypeNumber();
    private Integer HARDCORE = hiscoreTypes.HARDCORE.getTypeNumber();


    @RequestMapping(value = "")
    public String index(Model model){
        model.addAttribute("players",playerDao.count());

        long dataPoints = 0;
        for(Player player: playerDao.findAll()){
            for(DataPoint dataPoint : player.getData()){
                dataPoints += 1;
            }
        }
        model.addAttribute("dataPoints", dataPoints);

        return "home/index";
    }

    @RequestMapping(value = "progression")
    public String displayProgression(Model model,@RequestParam String hiscoreType, @RequestParam long days, @RequestParam String displayName){


        if (playerDao.count() > 0) {
            for (Player player : playerDao.findAll()) {
                if (player.getDisplayName().equals(displayName)) {
                    player.updateData();
                    player.checkProgression(days);
                    playerDao.save(player);
                    model.addAttribute("title",player.getDisplayName());
                    model.addAttribute("player",player);
                    model.addAttribute("progressionData",player.findRecentProgression("normal").getProgressionData());
                    model.addAttribute("displayName", player.getDisplayName());
                    model.addAttribute("dataPoint",player.getNormalData().get(0));
                    model.addAttribute("currentData",player.getRecentNormalDataPoint().getSkillInfo());
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
                        model.addAttribute("dataPoint",player.getType(NORMAL).get(0));
                        model.addAttribute("data",player.getType(NORMAL));
                        model.addAttribute("progressionData",player.findRecentProgression(NORMAL).getProgressionData());
                        return "home/player";
                    } else if (hiscoreType.equals("ironman")){
                        model.addAttribute("dataPoint",player.getType(IRON).get(0));
                        model.addAttribute("data",player.getType(IRON));
                        model.addAttribute("progressionData",player.findRecentProgression(IRON).getProgressionData());
                        return "home/player";
                    } else if (hiscoreType.equals("ultimate")){
                        model.addAttribute("dataPoint",player.getType(ULTIMATE).get(0));
                        model.addAttribute("data",player.getType(ULTIMATE));
                        model.addAttribute("progressionData",player.findRecentProgression(ULTIMATE).getProgressionData());
                        return "home/player";
                    } else if (hiscoreType.equals("hardcore")){
                        model.addAttribute("dataPoint",player.getType(HARDCORE).get(0));
                        model.addAttribute("data",player.getType(HARDCORE));
                        model.addAttribute("progressionData",player.findRecentProgression(HARDCORE).getProgressionData());
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
                    model.addAttribute("dataPoint",player.getType(NORMAL).get(0));
                    model.addAttribute("displayName", player.getDisplayName());
                    model.addAttribute("data", player.getType(NORMAL));
                    model.addAttribute("achievements", player.getAchievements());
                    model.addAttribute("progressionData", player.findRecentProgression(NORMAL).getProgressionData());
                    System.out.println(player.findRecentProgression(NORMAL));
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
        model.addAttribute("dataPoint",newPlayer.getType(NORMAL).get(0));
        model.addAttribute("displayName",newPlayer.getDisplayName());
        model.addAttribute("data",newPlayer.getType(NORMAL));
        model.addAttribute("achievements",newPlayer.getAchievements());
        model.addAttribute("progressionData",newPlayer.findRecentProgression(NORMAL).getProgressionData());
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
                    model.addAttribute("dataPoint",player.getType(NORMAL).get(0));
                    model.addAttribute("data",player.getType(NORMAL));
                    model.addAttribute("displayName",player.getDisplayName());
                    model.addAttribute("achievements",player.getAchievements());
                    model.addAttribute("progressionData",player.findRecentProgression(NORMAL));
                    return "home/player";
                } else {
                    continue;
                }
            }
        }
        return "home/index";

    }




}
