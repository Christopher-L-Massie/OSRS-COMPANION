package com.example.OSRSCOMPANION.models.databuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class skillData {

    @Id
    @GeneratedValue
    private int id;

    private String skillName;

    private int rank;

    private int experience;

    private int level;

    public skillData(){}

    public skillData(int rank, int experience, int level, String skillName){
        this.rank = rank;
        this.experience = experience;
        this.level = level;
        this.skillName = skillName;
    }

    public int getId() {
        return id;
    }

    public String getSkillName() {
        return skillName;
    }

    public int getRank() {
        return rank;
    }

    public int getExperience() {
        return experience;
    }

    public int getLevel() {
        return level;
    }
}
