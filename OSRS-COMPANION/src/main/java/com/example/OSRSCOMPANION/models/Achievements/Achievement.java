package com.example.OSRSCOMPANION.models.Achievements;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Achievement {

    //||Properties||

    @Id
    @GeneratedValue
    int id;

    int achievementNumber;

    private String name;

    private String description;

    private boolean hasAchieved;

    private long testValue;

    private Timestamp dateAchieved;

    //||Constructors||

    //empty for Database
    public Achievement(){}

    public Achievement(String name, String description, boolean hasAchieved, int achievementNumber, long testValue){
        this.name = name;
        this.description = description;
        this.hasAchieved = hasAchieved;
        this.achievementNumber = achievementNumber;
        this.testValue = testValue;
    }

    //||Methods||

    //||Accessors||

    public int getId() {
        return id;
    }

    public int getAchievementNumber() {
        return this.achievementNumber;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean isHasAchieved() {
        return this.hasAchieved;
    }

    public Timestamp getDateAchieved(){return this.dateAchieved;}

    public long getTestValue(){return this.testValue;}

    public void setHasAchieved(boolean hasAchieved) {
        this.hasAchieved = hasAchieved;
    }

    public void setDateAchieved(Timestamp dateAchieved){ this.dateAchieved = dateAchieved;}
}
