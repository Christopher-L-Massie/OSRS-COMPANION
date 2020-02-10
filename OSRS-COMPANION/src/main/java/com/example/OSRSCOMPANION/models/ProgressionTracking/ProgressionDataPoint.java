package com.example.OSRSCOMPANION.models.ProgressionTracking;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ProgressionDataPoint {

    //|||PROPERTIES|||
    @Id
    @GeneratedValue
    private int id;

    private long days;

    private boolean isNormal = false;

    private boolean isHardcore = false;

    private boolean isIronman = false;

    private boolean isUltimate = false;

    private boolean isRecent = true;

    private Integer type;

    @OneToMany(cascade = CascadeType.ALL)
    private List<skillProgressionData> progressionData = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<ProgressionData> clueProgressionData = new ArrayList<>();



    //|||CONSTRUCTORS|||

    //empty constructor for database functionality
    public ProgressionDataPoint(){}

    public ProgressionDataPoint(skillProgressionData skillProgressionData,clueProgressionData clueProgressionData,bountyProgressionData bountyProgressionData,lmsProgressionData lmsProgressionData,bossProgressionData bossProgressionData,boolean isNormal, boolean isIronman, boolean isHardcore, boolean isUltimate, Integer type){
        this.progressionData.add(skillProgressionData);
        this.clueProgressionData.add(clueProgressionData);
        this.bountyProgressionData.add(bountyProgressionData);
        this.lmsProgressionData.add(lmsProgressionData);
        this.bossProgressionData.add(bossProgressionData);
        this.isNormal = isNormal;
        this.isIronman = isIronman;
        this.isHardcore = isHardcore;
        this.isUltimate = isUltimate;
        this.type = type;
    }

    //|||METHODS|||

    public void addSkillProgressionData(skillProgressionData skillProgressionData, long days){
        this.progressionData.add(skillProgressionData);
        this.days = days;
    }

    //|||ACCESSORS|||

    public int getId() {
        return this.id;
    }

    public long getDays() {return this.days;}

    public boolean isNormal() {
        return this.isNormal;
    }

    public boolean isHardcore() {
        return this.isHardcore;
    }

    public boolean isIronman() {
        return this.isIronman;
    }

    public boolean isUltimate() {
        return this.isUltimate;
    }

    public boolean isRecent(){return this.isRecent;}

    public void setIsRecent(boolean isRecent){ this.isRecent = isRecent;}

    public List<skillProgressionData> getProgressionData() {
        return this.progressionData;
    }

    public Integer getType(){return this.type;}

    public void setType(Integer type){this.type = type;}

    public void setProgressionData(List<skillProgressionData> progressionData) {
        this.progressionData = progressionData;
    }

    public List<com.example.OSRSCOMPANION.models.ProgressionTracking.clueProgressionData> getClueProgressionData() {
        return clueProgressionData;
    }

    public void setClueProgressionData(List<com.example.OSRSCOMPANION.models.ProgressionTracking.clueProgressionData> clueProgressionData) {
        this.clueProgressionData = clueProgressionData;
    }

    public List<com.example.OSRSCOMPANION.models.ProgressionTracking.bountyProgressionData> getBountyProgressionData() {
        return bountyProgressionData;
    }

    public void setBountyProgressionData(List<com.example.OSRSCOMPANION.models.ProgressionTracking.bountyProgressionData> bountyProgressionData) {
        this.bountyProgressionData = bountyProgressionData;
    }

    public List<com.example.OSRSCOMPANION.models.ProgressionTracking.lmsProgressionData> getLmsProgressionData() {
        return lmsProgressionData;
    }

    public void setLmsProgressionData(List<com.example.OSRSCOMPANION.models.ProgressionTracking.lmsProgressionData> lmsProgressionData) {
        this.lmsProgressionData = lmsProgressionData;
    }

    public List<com.example.OSRSCOMPANION.models.ProgressionTracking.bossProgressionData> getBossProgressionData() {
        return bossProgressionData;
    }

    public void setBossProgressionData(List<com.example.OSRSCOMPANION.models.ProgressionTracking.bossProgressionData> bossProgressionData) {
        this.bossProgressionData = bossProgressionData;
    }
}
