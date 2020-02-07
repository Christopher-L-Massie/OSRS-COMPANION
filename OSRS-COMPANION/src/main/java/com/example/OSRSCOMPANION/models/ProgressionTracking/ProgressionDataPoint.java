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
    private List<clueProgressionData> clueProgressionData = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<bountyProgressionData> bountyProgressionData = new ArrayList<>();

    //|||CONSTRUCTORS|||

    //empty constructor for database functionality
    public ProgressionDataPoint(){}

    public ProgressionDataPoint(skillProgressionData skillProgressionData,boolean isNormal, boolean isIronman, boolean isHardcore, boolean isUltimate, Integer Type){
        this.progressionData.add(skillProgressionData);
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


}
