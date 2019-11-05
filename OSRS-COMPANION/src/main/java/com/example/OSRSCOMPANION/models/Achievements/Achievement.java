package com.example.OSRSCOMPANION.models.Achievements;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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

    //||Constructors||

    //empty for Database
    public Achievement(){}

    public Achievement(String name, String description, boolean hasAchieved, int achievementNumber){
        this.name = name;
        this.description = description;
        this.hasAchieved = hasAchieved;
        this.achievementNumber = achievementNumber;
    }

    //||Methods||

    //||Accessors||

    public int getId() {
        return id;
    }

    public int getAchievementNumber() {
        return achievementNumber;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isHasAchieved() {
        return hasAchieved;
    }

    public void setHasAchieved(boolean hasAchieved) {
        this.hasAchieved = hasAchieved;
    }
}
