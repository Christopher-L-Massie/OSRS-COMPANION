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

    private long rank;

    private long experience;

    private long level;

    public skillData(){}

    public skillData(long rank, long experience, long level, String skillName){
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
