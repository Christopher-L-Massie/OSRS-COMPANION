package com.example.OSRSCOMPANION.models;
import com.example.OSRSCOMPANION.models.Achievements.Achievement;
import com.example.OSRSCOMPANION.models.ProgressionTracking.ProgressionDataPoint;
import com.example.OSRSCOMPANION.models.constants.playerAchievements;
import com.example.OSRSCOMPANION.models.constants.skillNames;
import com.example.OSRSCOMPANION.models.constants.timeValues;

import com.example.OSRSCOMPANION.models.ProgressionTracking.Progression;
import com.example.OSRSCOMPANION.models.constants.hiscoreTypes;
import com.example.OSRSCOMPANION.models.databuilder.*;
import org.hibernate.annotations.NaturalId;

import javax.net.ssl.HttpsURLConnection;
import javax.persistence.*;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;

@Entity
@Table(name = "player")
public class Player {

    //|||PROPERTIES|||

    @Id
    @GeneratedValue
    int id;

    @NaturalId
    @Column(name="displayname")
    private String displayName;

    /*
    Associates a Progression object to a Player object
    */

    @OneToOne(mappedBy = "player", cascade = CascadeType.ALL)
    private Progression progression;

    /*
    Associates Achievement objects to a Player
    */

    @OneToMany(cascade = CascadeType.ALL)
    private List<Achievement> achievements = new ArrayList<>();

    /*
    Associates normalDataPoint (super of DataPoint) objects to a Player object
    */

    @OneToMany(cascade = CascadeType.ALL)
    private List<DataPoint> normalData = new ArrayList<>();

    /*
    Associates ironmanDataPoint (super of DataPoint) objects to a Player object
    */

    @OneToMany(cascade = CascadeType.ALL)
    private List<DataPoint> ironmanData = new ArrayList<>();

    /*
    Associates ultimateDataPoint (super of DataPoint) objects to a Player object
    */

    @OneToMany(cascade = CascadeType.ALL)
    private List<DataPoint> ultimateData = new ArrayList<>();

    /*
    Associates hardcoreDataPoint (super of DataPoint) objects to a Player object
    */

    @OneToMany(cascade = CascadeType.ALL)
    private List<DataPoint> hardcoreData = new ArrayList<>();

    /*
    The last time this player was updated in the database
    */

    @Column(name="lastUpdated")
    private Timestamp lastUpdated = new Timestamp(System.currentTimeMillis());


    /*
    These four boolean variables determine what boards the player appears on
    They cannot currently tell if the player has been removed from that board.
    */

    private boolean isNormal;

    private boolean isHardcore;

    private boolean isIronman;

    private boolean isUltimate;

    //|||CONSTRUCTORS|||

    //empty for database setup
    public Player(){}

    public Player(String displayName){this.displayName = displayName;}

    //||METHODS||

    public void setNotRecent(String dataType){
        if (dataType.equals("")) {
            for (DataPoint data : this.normalData) {
                data.setIsRecent(false);
            }
        } else if (dataType.equals("_ironman")) {
            for (DataPoint data : this.ironmanData) {
                data.setIsRecent(false);
            }
        } else if (dataType.equals("_ultimate")) {
            for (DataPoint data : this.ultimateData) {
                data.setIsRecent(false);
            }
        } else if (dataType.equals("_hardcore_ironman")) {
            for (DataPoint data : this.hardcoreData) {
                data.setIsRecent(false);
            }
        }
    }

    public void updateData(){
        try{
            for (hiscoreTypes hiscore : hiscoreTypes.values()){
                HttpsURLConnection connection = DataPoint.buildResponse(displayName, hiscore.getHiscore());
                int responseCode = connection.getResponseCode();
                if (connection.getResponseCode() == 200) {
                    if (hiscore.getHiscore().equals("")) {
                        isNormal = true;
                        setNotRecent(hiscore.getHiscore());
                        normalData.add(new normalData(displayName, hiscore.getHiscore(), connection,true,false,false,false));
                    } else if (hiscore.getHiscore().equals("_ironman")) {
                        isIronman = true;
                        setNotRecent(hiscore.getHiscore());
                        ironmanData.add(new ironmanData(displayName, hiscore.getHiscore(), connection,false,true,false,false));
                    } else if (hiscore.getHiscore().equals("_ultimate")) {
                        isUltimate = true;
                        setNotRecent(hiscore.getHiscore());
                        ultimateData.add(new ultimateData(displayName, hiscore.getHiscore(), connection,false,false,true,false));
                    } else if (hiscore.getHiscore().equals("_hardcore_ironman")) {
                        isHardcore = true;
                        setNotRecent(hiscore.getHiscore());
                        hardcoreData.add(new hardcoreData(displayName, hiscore.getHiscore(), connection,false,false,false,true));
                    }
                    this.lastUpdated = new Timestamp(System.currentTimeMillis());
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            /*
            Populates the achievements associated with the Player object  so that is has all the achievements
             */
            if(this.achievements.size() < playerAchievements.values().length ){
                for(playerAchievements achievement : playerAchievements.values()){
                    achievements.add(new Achievement(achievement.getName(),achievement.getDescription(),false,achievement.getId()));
                }
            }
        }
    }

    /*
    this method calls for an update in the Progression object of the Player
    each time this method is called it creates new datapoints in the ProgressionDataPoint subclasses (normal,ironman,ultimate,hardcore)
    these datapoints will be easily referencable for future use
    */
    public void checkProgression(long days){

        long day = timeValues.DAY.getMilliseconds();
        List<DataPoint> pointsInTimeRange = new ArrayList<>();

        /*

        */
        Timestamp earliestDate = new Timestamp(System.currentTimeMillis()-(days * day));

        if (this.normalData.size() > 2) {
            for (DataPoint datapoint : this.normalData) {
                if (datapoint.getDataTimeStamp().after(earliestDate)) {
                    pointsInTimeRange.add(datapoint);
                } else {
                    continue;

                }
            }
        } else {
            return;
        }

        DataPoint oldestDataPoint = pointsInTimeRange.get(0);
        DataPoint currentDataPoint = normalData.get(normalData.size()-1);

        int i = 0;


        for(skillNames skill :skillNames.values()){

        }


    }

    /*
    used to check if achievements that require a base level in all skills have been completed
    */

    public void checkBaseLevelAchievement(Achievement achievement,List<skillData> dataList,int baseLevel){
        for(skillData skillData : dataList){
            if(skillData.getLevel() >= baseLevel){
                achievement.setHasAchieved(true);
                achievement.setDateAchieved(new Timestamp(System.currentTimeMillis()));
                continue;
            } else {
                achievement.setHasAchieved(false);
                achievement.setDateAchieved(null);
                break;
            }
        }

    }

    public void checkAchievements(){

        List<skillData> dataList = this.normalData.get(this.normalData.size() -1).getSkillInfo();

        for(Achievement achievement : this.achievements){
            if(achievement.getAchievementNumber() == 0 & !achievement.isHasAchieved()){
                checkBaseLevelAchievement(achievement,dataList,10);
            }else if (achievement.getAchievementNumber() == 1 & !achievement.isHasAchieved()){
                checkBaseLevelAchievement(achievement,dataList,20);
            }else if (achievement.getAchievementNumber() == 2 & !achievement.isHasAchieved()){
                checkBaseLevelAchievement(achievement,dataList,30);
            }else if (achievement.getAchievementNumber() == 3 & !achievement.isHasAchieved()){
                checkBaseLevelAchievement(achievement,dataList,40);
            }else if (achievement.getAchievementNumber() == 4 & !achievement.isHasAchieved()){
                checkBaseLevelAchievement(achievement,dataList,50);
            }else if (achievement.getAchievementNumber() == 5 & !achievement.isHasAchieved()){
                checkBaseLevelAchievement(achievement,dataList,60);
            }else if (achievement.getAchievementNumber() == 6 & !achievement.isHasAchieved()){
                checkBaseLevelAchievement(achievement,dataList,70);
            }else if (achievement.getAchievementNumber() == 7 & !achievement.isHasAchieved()){
                checkBaseLevelAchievement(achievement,dataList,80);
            }else if (achievement.getAchievementNumber() == 8 & !achievement.isHasAchieved()){
                checkBaseLevelAchievement(achievement,dataList,90);
            }else if (achievement.getAchievementNumber() == 9 & !achievement.isHasAchieved()){
                checkBaseLevelAchievement(achievement,dataList,92);
            }else if (achievement.getAchievementNumber() == 10 & !achievement.isHasAchieved()){
                checkBaseLevelAchievement(achievement,dataList,99);
            }
        }

    }

    //|||ACCESSORS|||

    public int getId(){return this.id;}

    public String getDisplayName(){return this.displayName;}

    public Timestamp getLastUpdated() {return lastUpdated;}

    public List getNormalData(){return this.normalData;}

    public List getIronmanData(){return this.ironmanData;}

    public List getUltimateData(){return this.ultimateData;}

    public List getHardcoreData(){return this.hardcoreData;}

    public boolean getIsNormal(){return this.isNormal;}

    public boolean getIsIronman(){return this.isIronman;}

    public boolean getIsUltimate(){return this.isUltimate;}

    public boolean getIsHardcore(){return this.isHardcore;}

    public Progression getProgression(){return this.progression;}

    public List<Achievement> getAchievements(){return this.achievements;}
}



