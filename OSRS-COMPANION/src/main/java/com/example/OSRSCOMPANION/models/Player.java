package com.example.OSRSCOMPANION.models;
import com.example.OSRSCOMPANION.models.Achievements.Achievement;
import com.example.OSRSCOMPANION.models.ProgressionTracking.*;
import com.example.OSRSCOMPANION.models.constants.playerAchievements;
import com.example.OSRSCOMPANION.models.constants.skillNames;
import com.example.OSRSCOMPANION.models.constants.timeValues;

import com.example.OSRSCOMPANION.models.constants.hiscoreTypes;
import com.example.OSRSCOMPANION.models.databuilder.*;
import org.hibernate.annotations.Cascade;
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
    Associates different progression objects to the player
    */

    @OneToMany(cascade = CascadeType.ALL)
    private List<ProgressionDataPoint> normalProgression = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<ProgressionDataPoint> ironmanProgression = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<ProgressionDataPoint> ultimateProgression = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<ProgressionDataPoint> hardcoreProgression = new ArrayList<>();

    /*
    Recent Progression Objects
    */

    @OneToOne(cascade = CascadeType.ALL)
    private ProgressionDataPoint recentNormalProgression = new ProgressionDataPoint();

    @OneToOne(cascade = CascadeType.ALL)
    private ProgressionDataPoint recentIronmanProgresion = new ProgressionDataPoint();

    @OneToOne(cascade = CascadeType.ALL)
    private ProgressionDataPoint recentUltimateProgression = new ProgressionDataPoint();

    @OneToOne(cascade = CascadeType.ALL)
    private ProgressionDataPoint recentHardcoreProgression = new ProgressionDataPoint();

    /*
    Associates Achievement objects to a Player
    */

    @OneToMany(cascade = CascadeType.ALL)
    private List<Achievement> achievements = new ArrayList<>();

    /*
    Associates various DataPoint objects to list for use in progression
    */

    @OneToMany(cascade = CascadeType.ALL)
    private List<DataPoint> normalData = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<DataPoint> ironmanData = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<DataPoint> ultimateData = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<DataPoint> hardcoreData = new ArrayList<>();

    /*
    Recent Datapoints - the most recent datapoint making various things easier for frontend
    */

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
                this.achievements.clear();
                for(playerAchievements achievement : playerAchievements.values()){
                    this.achievements.add(new Achievement(achievement.getName(),achievement.getDescription(),false,achievement.getId(),achievement.getTestValue()));
                }
            }
        }
    }

    //||Progression System||

    /*
    this method calls for an update in the Progression object of the Player
    each time this method is called it creates new datapoints in the ProgressionDataPoint subclasses (normal,ironman,ultimate,hardcore)
    these datapoints will be easily referencable for future use
    */
    public void checkProgression(long days){

        long day = timeValues.DAY.getMilliseconds();
        List<DataPoint> pointsInTimeRange = new ArrayList<>();

        Timestamp earliestDate = new Timestamp(System.currentTimeMillis()-(days * day));

        if(normalProgression.size() > 0){
            setProgressionNotRecent();
        }


        if (this.normalData.size() > 2) {
            pointsInTimeRange = findPointsInTimeRange(this.normalData, earliestDate);
            addProgressionDataPoint(findOldestDataPoint(pointsInTimeRange), normalData.get(normalData.size() - 1), "normal",days);
        } else {
            addProgressionDataPoint(new DataPoint(),new DataPoint(),"normal",days);
            return;
        }
        if (this.ironmanData.size() > 2) {
            pointsInTimeRange = findPointsInTimeRange(this.ironmanData, earliestDate);
            addProgressionDataPoint(findOldestDataPoint(pointsInTimeRange), ironmanData.get(ironmanData.size() - 1), "ironman",days);
        }
        if (this.ultimateData.size() > 2) {
            pointsInTimeRange = findPointsInTimeRange(this.ultimateData, earliestDate);
            addProgressionDataPoint(findOldestDataPoint(pointsInTimeRange), ultimateData.get(ultimateData.size() - 1), "ultimate",days);
        }
        if (this.hardcoreData.size() > 2) {
            pointsInTimeRange = findPointsInTimeRange(this.hardcoreData, earliestDate);
            addProgressionDataPoint(findOldestDataPoint(pointsInTimeRange), hardcoreData.get(hardcoreData.size() - 1), "hardcore",days);
        }

    }

    /*
    ||Progression helper methods||
    */

    public ProgressionDataPoint  findRecentProgression(String hiscoreType){




        if (hiscoreType.equals("normal")){
            for (ProgressionDataPoint dataPoint : this.normalProgression) {
                if (dataPoint.isRecent()) {
                    return dataPoint;
                }
            }
        } else if (hiscoreType.equals("ironman")){
            for (ProgressionDataPoint dataPoint : this.ironmanProgression) {
                if (dataPoint.isRecent()) {
                    return dataPoint;
                }
            }
        } else if (hiscoreType.equals("ultimate")){
            for (ProgressionDataPoint dataPoint : this.ultimateProgression) {
                if (dataPoint.isRecent()) {
                    return dataPoint;
                }
            }
        }else if (hiscoreType.equals("hardcore")) {
            for (ProgressionDataPoint dataPoint : this.hardcoreProgression) {
                if (dataPoint.isRecent()) {
                    return dataPoint;
                }
            }
        }
        //shouldn't be reached
        return null;
    }

    public void setProgressionNotRecent(){

        for (ProgressionDataPoint data : this.normalProgression) {
            data.setIsRecent(false);
        }
        for (ProgressionDataPoint data : this.ironmanProgression){
            data.setIsRecent(false);
        }
        for (ProgressionDataPoint data : this.ultimateProgression){
            data.setIsRecent(false);
        }
        for (ProgressionDataPoint data : this.hardcoreProgression){
            data.setIsRecent(false);
        }

    }

    public List<DataPoint> findPointsInTimeRange(List<DataPoint> allDataPoints, Timestamp earliestDate){
        List<DataPoint> pointsInTimeRange = new ArrayList<>();
        for (DataPoint datapoint : allDataPoints){
            if(datapoint.getDataTimeStamp().after(earliestDate)){
                pointsInTimeRange.add(datapoint);
            } else {
                continue;
            }
        }
        return pointsInTimeRange;
    }

    public void addProgressionDataPoint(DataPoint oldestDataPoint,DataPoint currentDataPoint,String hiscoreType,long days){


        ProgressionDataPoint newDataPoint = new ProgressionDataPoint();


        for(skillNames skill :skillNames.values()){
            skillData newSkillDataPoint = currentDataPoint.getSkillInfo().get(skill.getSkillNumber());
            skillData oldSkillDataPoint = oldestDataPoint.getSkillInfo().get(skill.getSkillNumber());
            long rankDifference = newSkillDataPoint.getRank() - oldSkillDataPoint.getRank();
            long experienceDifference = newSkillDataPoint.getExperience() - oldSkillDataPoint.getExperience();
            long levelDifference = newSkillDataPoint.getLevel() - oldSkillDataPoint.getLevel();
            newDataPoint.addSkillProgressionData(new skillProgressionData(rankDifference,experienceDifference,levelDifference,skill.getSkillName()),days);
        }

        if(hiscoreType.equals("normal")){
            this.recentNormalProgression = newDataPoint;
            this.normalProgression.add(newDataPoint);
        }else if(hiscoreType.equals("ironman")){
            this.recentIronmanProgresion = newDataPoint;
            this.ironmanProgression.add(newDataPoint);
        }else if(hiscoreType.equals("ultimate")){
            this.recentUltimateProgression = newDataPoint;
            this.ultimateProgression.add(newDataPoint);
        }else if(hiscoreType.equals("hardcore")){
            this.recentHardcoreProgression = newDataPoint;
            this.hardcoreProgression.add(newDataPoint);
        }

    }

    public DataPoint findOldestDataPoint(List<DataPoint> dataPoints){

        DataPoint oldestDataPoint = new DataPoint();

        for (DataPoint dataPoint : dataPoints){
            if(oldestDataPoint.getDataTimeStamp() == null){
                oldestDataPoint = dataPoint;
            }
            if(dataPoint.getDataTimeStamp().before(oldestDataPoint.getDataTimeStamp())){
                oldestDataPoint = dataPoint;
            }
        }
        return oldestDataPoint;
    }

    //||End Progression System||
    /*
    used to check if achievements that require a base level in all skills have been completed
    */

    public void checkBaseLevelAchievement(Achievement achievement,List<skillData> dataList,long baseLevel){
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

    public void checkTotalExperienceAchievement(Achievement achievement,List<skillData> dataList,long experienceAmount){
        skillData skilldata = dataList.get(0);
        if(skilldata.getExperience() >= experienceAmount){
            achievement.setHasAchieved(true);
            achievement.setDateAchieved(new Timestamp(System.currentTimeMillis()));
        } else {
            achievement.setHasAchieved(false);
        }
    }

    public void checkAchievements(){

        List<skillData> dataList = this.normalData.get(this.normalData.size() -1).getSkillInfo();

        for(Achievement achievement : this.achievements){
            if((achievement.getAchievementNumber() <= 10) & !achievement.isHasAchieved()){
                checkBaseLevelAchievement(achievement,dataList,achievement.getTestValue());
            }else if ((10  < (achievement.getAchievementNumber())) & !achievement.isHasAchieved()){
                checkTotalExperienceAchievement(achievement,dataList,achievement.getTestValue());
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

    public List<Achievement> getAchievements(){return this.achievements;}

    public List<ProgressionDataPoint> getNormalProgression() {
        return normalProgression;
    }

    public List<ProgressionDataPoint> getIronmanProgression() {
        return ironmanProgression;
    }

    public List<ProgressionDataPoint> getUltimateProgression() {
        return ultimateProgression;
    }

    public List<ProgressionDataPoint> getHardcoreProgression() {
        return hardcoreProgression;
    }


}



