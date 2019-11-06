package com.example.OSRSCOMPANION.models.databuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class skillData {

    //|||PROPERTIES|||

    @Id
    @GeneratedValue
    private int id;

    private String skillName;

    private long rank;

    private long experience;

    private long level;

    //|||CONSTRUCTORS|||

    public skillData(){}

    public skillData(long rank, long level, long experience, String skillName){
        this.rank = rank;
        this.experience = experience;
        this.level = level;
        this.skillName = skillName;
    }

    //|||ACCESSORS|||

    public int getId() {
        return id;
    }

    public String getSkillName() {
        return skillName;
    }

    public long getRank() {
        return rank;
    }

    public long getExperience() {
        return experience;
    }

    public long getLevel() {
        return level;
    }
}
