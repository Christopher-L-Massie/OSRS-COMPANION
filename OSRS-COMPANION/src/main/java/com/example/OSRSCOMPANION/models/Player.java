package com.example.OSRSCOMPANION.models;
import com.example.OSRSCOMPANION.models.Achievements.Achievement;
import com.example.OSRSCOMPANION.models.ProgressionTracking.*;
import com.example.OSRSCOMPANION.models.constants.playerAchievements;
import com.example.OSRSCOMPANION.models.constants.skillNames;
import com.example.OSRSCOMPANION.models.constants.timeValues;
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
    Associates a List<> of progression objects to the player
    */

    @OneToMany(cascade = CascadeType.ALL)
    private List<ProgressionDataPoint> progression = new ArrayList<>();


    /*
    Associates Achievement objects to a Player
    */

    @OneToMany(cascade = CascadeType.ALL)
    private List<Achievement> achievements = new ArrayList<>();

    /*
    Associates a DataPoint object to  a list for use in progression and current data
    */

    @OneToMany(cascade = CascadeType.ALL)
    private List<DataPoint> data = new ArrayList<>();


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

    public void setNotRecent(){
        for (DataPoint data : this.data) {
            data.setIsRecent(false);
        }

    }

    //helper method
    public DataPoint getRecentDataPoint(List<DataPoint> dataPoints,Integer typeNumber){
        for (DataPoint data : dataPoints){
            if (data.getIsRecent() & data.getType().equals(typeNumber)){
                return data;
            }
        }
        return null;
    }

    public void updateData(){
        try{
            setNotRecent();
            for (hiscoreTypes hiscore : hiscoreTypes.values()){
                HttpsURLConnection connection = DataPoint.buildResponse(displayName, hiscore.getHiscore());
                if (connection.getResponseCode() == 200) {
                    if (hiscore.getHiscore().equals("")) {
                        isNormal = true;
                        data.add(new DataPoint(displayName, hiscore.getHiscore(), connection,true,false,false,false,hiscore.getTypeNumber()));
                    } else if (hiscore.getHiscore().equals("_ironman")) {
                        isIronman = true;
                        data.add(new DataPoint(displayName, hiscore.getHiscore(), connection,false,true,false,false,hiscore.getTypeNumber()));
                    } else if (hiscore.getHiscore().equals("_ultimate")) {
                        isUltimate = true;
                        data.add(new DataPoint(displayName, hiscore.getHiscore(), connection,false,false,true,false,hiscore.getTypeNumber()));
                    } else if (hiscore.getHiscore().equals("_hardcore_ironman")) {
                        isHardcore = true;
                        data.add(new DataPoint(displayName, hiscore.getHiscore(), connection,false,false,false,true,hiscore.getTypeNumber()));
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

    public List<DataPoint> getType(Integer hiscoreTypeNumber){
        List<DataPoint> typeData = new ArrayList<>();
        for(DataPoint datapoint: this.data) {
            if (datapoint.getType().equals(hiscoreTypeNumber)) {
                typeData.add(datapoint);
            }
        }
        return typeData;
    }

    //||Progression System||

    /*
    this method calls for an update in the Progression object of the Player
    each time this method is called it creates new progression object for each
    hiscore board that the player is featured on
    */
    public void checkProgression(long days){

        long day = timeValues.DAY.getMilliseconds();
        List<DataPoint> pointsInTimeRange;

        Timestamp earliestDate = new Timestamp(System.currentTimeMillis()-(days * day));

        if(progression.size() > 0){
            setProgressionNotRecent();
        }

        for (hiscoreTypes hiscore : hiscoreTypes.values()){
            if (findPointsInTimeRange(getType(hiscore.getTypeNumber()),earliestDate).size() > 2){
                pointsInTimeRange = findPointsInTimeRange(getType(hiscore.getTypeNumber()),earliestDate);
                addProgressionDataPoint(findOldestDataPoint(pointsInTimeRange), getType(hiscore.getTypeNumber()).get(getType(hiscore.getTypeNumber()).size() - 1),hiscore.getTypeNumber(),days);
            }
        }
    }

    /*
    ||Progression helper methods||
    */

    public List<ProgressionDataPoint> scanProgressionDataPoints(Integer typeNumber){
        List<ProgressionDataPoint> typeData = new ArrayList<>();
        for(ProgressionDataPoint datapoint: this.progression) {
            if (datapoint.getType().equals(typeNumber)) {
                typeData.add(datapoint);
            }
        }
        return typeData;
    }

    public ProgressionDataPoint  findRecentProgression(Integer typeNumber){
        ProgressionDataPoint dataPoint = new ProgressionDataPoint();
        for (ProgressionDataPoint datapoint : scanProgressionDataPoints(typeNumber)){
            if (datapoint.isRecent() & datapoint.getType().equals(typeNumber)){
                dataPoint = datapoint;
                break;
            }
        }
        return dataPoint;
    }

    public void setProgressionNotRecent(){
        for (ProgressionDataPoint data : this.progression) {
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

    public void addProgressionDataPoint(DataPoint oldestDataPoint,DataPoint currentDataPoint,Integer hiscoreType,long days){

        ProgressionDataPoint newDataPoint = new ProgressionDataPoint();

        for(skillNames skill :skillNames.values()){
            skillData newSkillDataPoint = currentDataPoint.getSkillInfo().get(skill.getSkillNumber());
            skillData oldSkillDataPoint = oldestDataPoint.getSkillInfo().get(skill.getSkillNumber());
            long rankDifference = newSkillDataPoint.getRank() - oldSkillDataPoint.getRank();
            long experienceDifference = newSkillDataPoint.getExperience() - oldSkillDataPoint.getExperience();
            long levelDifference = newSkillDataPoint.getLevel() - oldSkillDataPoint.getLevel();
            newDataPoint.addSkillProgressionData(new skillProgressionData(rankDifference,experienceDifference,levelDifference,skill.getSkillName()),days);
        }

        this.progression.add(newDataPoint);
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
        if(this.data.size() >= 1){
            List<skillData> dataList = getType(hiscoreTypes.NORMAL.getTypeNumber()).get(getType(hiscoreTypes.NORMAL.getTypeNumber()).size() -1).getSkillInfo();
            for(Achievement achievement : this.achievements){
                if((achievement.getAchievementNumber() <= 10) & !achievement.isHasAchieved()){
                    checkBaseLevelAchievement(achievement,dataList,achievement.getTestValue());
                    //slight error with how this is working
                }else if ((10  < (achievement.getAchievementNumber())) & !achievement.isHasAchieved()){
                    checkTotalExperienceAchievement(achievement,dataList,achievement.getTestValue());
                }
            }
        }
    }

    //|||ACCESSORS|||

    public int getId(){return this.id;}

    public String getDisplayName(){return this.displayName;}

    public Timestamp getLastUpdated() {return lastUpdated;}

    public boolean getIsNormal(){return this.isNormal;}

    public boolean getIsIronman(){return this.isIronman;}

    public boolean getIsUltimate(){return this.isUltimate;}

    public boolean getIsHardcore(){return this.isHardcore;}

    public List<Achievement> getAchievements(){return this.achievements;}

    public List<ProgressionDataPoint> getProgression() {
        return this.progression;
    }

    public List<DataPoint> getData(){
        return this.data;
    }

}



