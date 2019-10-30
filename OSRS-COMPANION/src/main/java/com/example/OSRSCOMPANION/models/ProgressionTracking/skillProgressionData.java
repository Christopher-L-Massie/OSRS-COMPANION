package com.example.OSRSCOMPANION.models.ProgressionTracking;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class skillProgressionData {

    //properties

    @Id
    @GeneratedValue
    private int id;

    private String skillName;

    private long rankDifference;

    private long experienceDifference;

    private long levelDifference;





    //constructors

    //empty for database functionality
    public skillProgressionData(){}

    public skillProgressionData(long rankDifference, long experienceDifference, long levelDifference, String skillName){
        this.rankDifference = rankDifference;
        this.experienceDifference = experienceDifference;
        this.levelDifference = levelDifference;
        this.skillName = skillName;
    }

    //accessors
    public int getId() {
        return id;
    }

    public String getSkillName() {
        return skillName;
    }

    public long getRankDifference() {
        return rankDifference;
    }

    public long getExperienceDifference() {
        return experienceDifference;
    }

    public long getLevelDifference() {
        return levelDifference;
    }
}
