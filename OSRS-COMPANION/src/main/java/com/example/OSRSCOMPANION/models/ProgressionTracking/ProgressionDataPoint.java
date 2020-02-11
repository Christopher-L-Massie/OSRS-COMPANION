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
    private List<skillProgressionData> skillProgressionData = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<ProgressionData> progressionData = new ArrayList<>();

    //|||CONSTRUCTORS|||

    //empty constructor for database functionality
    public ProgressionDataPoint(){}

    public ProgressionDataPoint(skillProgressionData skillProgressionData,ProgressionData ProgressionData,boolean isNormal, boolean isIronman, boolean isHardcore, boolean isUltimate, Integer type){
        this.skillProgressionData.add(skillProgressionData);
        this.progressionData.add(ProgressionData);
        this.isNormal = isNormal;
        this.isIronman = isIronman;
        this.isHardcore = isHardcore;
        this.isUltimate = isUltimate;
        this.type = type;
    }

    //|||METHODS|||

    public void addSkillProgressionData(skillProgressionData skillProgressionData, long days){
        this.skillProgressionData.add(skillProgressionData);
        this.days = days;
    }

    public void addProgressionData(skillProgressionData skillProgressionData, ProgressionData progressionData, long days){
        this.skillProgressionData.add(skillProgressionData);
        this.progressionData.add(progressionData);
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

    public List<skillProgressionData> getSkillProgressionData() {
        return this.skillProgressionData;
    }

    public Integer getType(){return this.type;}

    public void setType(Integer type){this.type = type;}

    public void setSkillProgressionData(List<skillProgressionData> skillProgressionData) {
        this.skillProgressionData = skillProgressionData;
    }

    public List<ProgressionData> getProgressionData() {
        return this.progressionData;
    }

    public void setProgressionData(List<ProgressionData> progressionData) {
        this.progressionData = progressionData;
    }

}
